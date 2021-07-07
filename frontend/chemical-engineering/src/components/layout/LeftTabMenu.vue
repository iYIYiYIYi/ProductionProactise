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
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose">
          <el-submenu v-for="(group_value, group_name) in nodes" :key="group_name">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>{{group_name}}</span>
            </template>
            <el-menu-item-group v-for="(company_value,company_name) in group_value" :key="company_name">
              <template slot="title">{{ company_name }}</template>
              <el-submenu v-for="(factory_value,factory_name) in company_value" :key="factory_name">
                <template slot="title">{{factory_name}}</template>
                <el-menu-item v-for="(equipment_value,equipment_name) in factory_value" :key="equipment_name">
                  {{equipment_name}}
                </el-menu-item>
              </el-submenu>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
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
  overflow-y: auto;
  overflow-x: hidden;
}

.head {
  background-color: #E6A23C;
  color: white;
  height: 6%;
}

.search {
  height: 4%;
  background-color: white;
}
</style>

<script>

const axios = require('axios');
export default {
  name:'LeftTabMenu',
  data() {
    let node_tree = {};
    this.getNodeId();

    return {
      isCollapse: true,
      search_value:'',
      nodes:node_tree,
    };
  },
  props: {
    select:Function,
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    //获取节点信息//
    getNodeId(){
      // Make a request for a user with a given ID
      let it = this;
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/node/info',
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
      })
      .then(function () {
        // always executed
      });
    },
    //获取设备信息//
    getStatus(node_id){
      let it = this;
      // Make a request for a user with a given ID
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/equipment/node/'+node_id+'/info',
        responseType:'json',
      })
      .then(function (response) {
        // handle success
        let parse = response.data;
        console.log(parse);
        let data = parse.data;
        let tree = {};
        for (const datum of data) {
          if (!tree[datum.groupname]) {
            tree[datum.groupname] = {};
          }
          if (!tree[datum.groupname][datum.companyname]) {
            tree[datum.groupname][datum.companyname] = {};
          }
          if (!tree[datum.groupname][datum.companyname][datum.factoryname]) {
            tree[datum.groupname][datum.companyname][datum.factoryname] = {};
          }
          tree[datum.groupname][datum.companyname][datum.factoryname][datum.equipmentname] = datum;
        }
        it.$data.nodes = tree;
        console.log(tree);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
      })
      .then(function () {
        // always executed
      });
    },
    //获取测点信息//
    getMessage(){
      // Make a request for a user with a given ID
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/point/{equipmentUuid}/detail',
        responseType:'json',
      })
          .then(function (response) {
            // handle success
            let parse = JSON.parse(response.data);
            console.log(parse)
          })
          .catch(function (error) {
            // handle error
            console.log(error);
          })
          .then(function () {
            // always executed
          });
    },
  }
}
</script>