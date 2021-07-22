<template>
  <div class="menu">

    <div class="head el-menu-item">

        <i class="el-icon-cloudy-and-sunny" style="color: white;"></i>
        <span style="font-size: 24px;color: white">在线监测平台</span>

    </div>

    <div class="search el-menu-item ">
      <el-input
          placeholder="请输入内容"
          clearable
          v-model="search_value">
        <i slot="prefix" class="el-input__icon el-icon-search"></i>
      </el-input>
    </div>

    <div class="left-tab-menu">

      <el-col :span="12">

        <el-menu
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            v-if="nodes !== undefined"
            :collapse="false"
            :default-openeds="groupNames"
        >
          <el-submenu v-for="(group_value, group_name) in nodes" :key="group_name" :index="group_name" :default-openeds="companyNames">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>{{group_name}}</span>
            </template>
            <el-submenu v-for="(company_value,company_name) in group_value" :key="company_name" :index="company_name" :default-openeds="factoryNames">
              <template slot="title"><i class="el-icon-s-cooperation"></i>{{ company_name }}</template>
              <el-submenu v-for="(factory_value,factory_name) in company_value" :key="factory_name" :index="factory_name" :default-openeds="equipmentNames">
                <template slot="title"><i class="el-icon-s-flag"></i>{{factory_name}}</template>
                <div v-for="(equipment_value,equipment_name) in factory_value" :key="equipment_name">
                  <el-menu-item  :index="equipment_name" @click="selectNode" v-if="companyVisible[group_name][company_name][factory_name][equipment_name] === true">
                    <i class="el-icon-setting" :style="{color:(()=>{if (nodes[group_name][company_name][factory_name][equipment_name]['alarmalias'] === '断网') return '#ff0000'; else return '#ffffff';})()}"></i>{{equipment_name}}
                  </el-menu-item>
                </div>
              </el-submenu>
            </el-submenu>
          </el-submenu>


        </el-menu>

        <el-empty v-else-if="nodes === undefined" :description="tree_description" style="width: 240px"></el-empty>
      </el-col>
    </div>
  </div>
</template>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 240px;
}

.menu {
  height: 100%;
  overflow-x: hidden;
  overflow-y: hidden;
}

.left-tab-menu {
  height: 90%;
  width: fit-content;
  box-sizing: border-box;
  border-right: solid 2px #e6e6e6;
  margin: 0;
  overflow-y: hidden;
  overflow-x: hidden;
}

.head {
  background-color: #c4ff58;
  color: white;
  height: 6%;
}

.search {
  height: 4%;
}

</style>

<script>

export default {
  name:'LeftTabMenu',
  data() {
    this.getNodeId();

    return {
      isCollapse: true,
      search_value:'',
      nodes:undefined,
      tree_description:'正在获取节点信息...',
      companyVisible:{},
      groupNames:[],
      companyNames:[],
      factoryNames:[],
      equipmentNames:[],

    };
  },
  props: {

  },
  watch: {
    search_value(val) {
      for (const nodesKey in this.$data.nodes) {

          let companyNodes = this.$data.nodes[nodesKey];
          for (let companyNodesKey in companyNodes) {

              let factoryNodes = companyNodes[companyNodesKey];
              for (let factoryNodesKey in factoryNodes) {

                  let equipmentNodes = factoryNodes[factoryNodesKey];
                  for (let equipmentNodesKey in equipmentNodes) {
                    if (equipmentNodes[equipmentNodesKey].equipmentname.indexOf(val) === -1) {
                      this.companyVisible[nodesKey][companyNodesKey][factoryNodesKey][equipmentNodesKey] = false;
                    } else {
                      this.companyVisible[nodesKey][companyNodesKey][factoryNodesKey][equipmentNodesKey] = true;
                    }
                  }

              }

          }

      }
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    selectNode(obj) {
      let name = obj.indexPath[obj.indexPath.length - 1];
      let dataObj = this.searchNodes(obj.indexPath);
      this.$emit('changeContent',dataObj,name);
    },
    searchNodes(indexPath) {
      for (const nodesKey in this.$data.nodes) {
        if (nodesKey === indexPath[0]) {
          let companyNodes = this.$data.nodes[nodesKey];
          for (let companyNodesKey in companyNodes) {
            if (companyNodesKey === indexPath[1]) {
              let factoryNodes = companyNodes[companyNodesKey];
              for (let factoryNodesKey in factoryNodes) {
                if (factoryNodesKey === indexPath[2]) {
                  let equipmentNodes = factoryNodes[factoryNodesKey];
                  for (let equipmentNodesKey in equipmentNodes) {
                    if (equipmentNodesKey === indexPath[3]) {
                      return equipmentNodes[equipmentNodesKey];
                    }
                  }
                }
              }
            }
          }
        }
      }
    },
    //获取节点信息//
    getNodeId(){
      // Make a request for a user with a given ID
      let it = this;
      this.$axios({
        method:'get',
        url:'/node/info',
        responseType:'json',
      })
      .then(function (response) {
        // handle success
        let parse = response.data;
        let data = parse.data;
        for (const datum of data) {
          it.getStatus(datum['nodeid']);
        }
      })
      .catch(function (error) {
        // handle error
        console.log(error);
        it.$data.tree_description = '获取节点信息失败';
        it.$notify.error({
          title: '网络错误',
          message: '获取节点信息失败'
        });
      })
      .then(function () {
        // always executed
      });
    },
    //获取设备信息//
    getStatus(node_id){
      let it = this;
      // Make a request for a user with a given ID
      this.$axios({
        method:'get',
        url:'/equipment/node/'+node_id+'/info',
        responseType:'json',
      })
      .then(function (response) {
        // handle success
        let parse = response.data;
        console.log(parse);
        let data = parse.data;
        let tree = {};
        let groupSet = new Set();
        let companySet = new Set();
        let factorySet = new Set();
        let equipmentSet = new Set();
        for (const datum of data) {
          if (!tree[datum.groupname]) {
            tree[datum.groupname] = {};
            it.companyVisible[datum.groupname] = {};
          }
          if (!tree[datum.groupname][datum.companyname]) {
            tree[datum.groupname][datum.companyname] = {};
            it.companyVisible[datum.groupname][datum.companyname] = {};
          }
          if (!tree[datum.groupname][datum.companyname][datum.factoryname]) {
            tree[datum.groupname][datum.companyname][datum.factoryname] = {};
            it.companyVisible[datum.groupname][datum.companyname][datum.factoryname] = {};
          }
          tree[datum.groupname][datum.companyname][datum.factoryname][datum.equipmentname] = datum;
          it.companyVisible[datum.groupname][datum.companyname][datum.factoryname][datum.equipmentname] = true;

          groupSet.add(datum.groupname);
          companySet.add(datum.companyname);
          factorySet.add(datum.factoryname);
          equipmentSet.add(datum.equipmentname);
        }

        it.groupNames = Array.from(groupSet);
        it.companyNames = Array.from(companySet);
        it.factoryNames = Array.from(factorySet);
        it.equipmentNames = Array.from(equipmentSet);
        it.$data.nodes = tree;
        console.log(tree);
      })
      .catch(function (error) {
        // handle error
        // it.$alert('获取设备信息失败', '网络错误', {
        //   confirmButtonText: '确定',
        //   callback: action => {
        //     this.$message({
        //       type: 'error',
        //       message: `action: ${ action }`
        //     });
        //   }
        // });
        it.$notify.error({
          title: '网络错误',
          message: '获取设备信息失败'
        });
        it.$data.tree_description = '获取设备信息失败';
        console.log(error);
      })
      .then(function () {
        // always executed
      });
    },
  }
}
</script>