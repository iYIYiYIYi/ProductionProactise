<template>
  <el-card class="box-card">
    <h3 class="title">操作菜单</h3>
    <div class="piece">
      设备名称:{{ name }}
    </div>
    <el-switch
        v-model="openChart"
        @change="change"
        active-text="显示图谱"
        inactive-text="关闭图谱">
    </el-switch>
    <keep-alive>
      <div class="panel" v-if="openChart">
        <div class="piece">
          <div>
            类型选择:
            <el-select v-model="value" placeholder="请选择">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled">
              </el-option>
            </el-select>
          </div>
          <br>
          <div v-if="statusOptions&&statusOptions.length > 0">
            特征选择:
            <el-select v-model="value" placeholder="请选择">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled">
              </el-option>
            </el-select>
          </div>
          <el-divider><i class="el-icon-monitor"></i></el-divider>
          <div>
<!--            <el-tree-->
<!--                :data="data"-->
<!--                :props="defaultProps"-->
<!--                show-checkbox-->
<!--                @node-click="handleNodeClick"-->
<!--            />-->
            <el-select v-model="selectEquipments" multiple placeholder="请选择">
              <el-option
                  v-for="item in equipmentOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
              </el-option>
            </el-select>
          </div>
          <el-divider><i class="el-icon-data-analysis"></i></el-divider>
          <el-switch
              v-model="dataMode"
              @change="changeDataMode"
              inactive-text="实时模式"
              active-text="历史模式">
          </el-switch>
          <el-divider><i class="el-icon-receiving"></i></el-divider>
          <el-button :type="stop_switch_type" @click="stopSwitch" style="width: 60%">{{stop_switch}}</el-button>
        </div>
      </div>
    </keep-alive>
  </el-card>
</template>

<script>

export default {
  name: "InfoMenu",
  props :{
    name:String,
    equipmentUUID:String,
  },
  data() {
    this.getMessage(this.equipmentUUID);

    return {
      openChart:false,
      dataMode:false,
      stop_switch:'停止',
      stop_switch_type:'primary',
      options: [{
        value: '选项2',
        label: '双皮奶',
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }],
      // eslint-disable-next-line vue/require-prop-type-constructor
      value: '',
      statusOptions:[{
        value: '选项2',
        label: '双皮奶',
      }],
      statusValue:'',
      selectEquipments:[],
      equipmentOptions:[{
        value: '选项2',
        label: '双皮奶',
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }],
      // data: [{
      //   label: '震动测点',
      //   children: [{
      //     label: '二级 1-1',
      //     children: [{
      //       label: '三级 1-1-1'
      //     }]
      //   }]
      // },],
      defaultProps: {
        children: 'children',
        label: 'label'
      }
    }
  },
  methods : {
    handleCheckChange(data, checked, indeterminate) {
      console.log(data, checked, indeterminate);
    },
    handleNodeClick(data) {
      console.log(data);
    },
    change(){

    },
    changeDataMode(){

    },
    stopSwitch() {
      if (this.$data.stop_switch === '停止') {
        this.$data.stop_switch = '恢复';
        this.$data.stop_switch_type = 'danger';

      }
      else {
        this.$data.stop_switch = '停止';
        this.$data.stop_switch_type = 'primary';

      }

    },
    //获取测点信息//
    getMessage(equipmentUuid){
      let it = this;
      // Make a request for a user with a given ID
      this.$axios({
        method:'get',
        url:'/point/'+equipmentUuid+'/detail',
        responseType:'json',
      })
      .then(function (response) {
        // handle success
        var parse = response.data;
        console.log(parse);
        let data = parse.data;
        it.parseData(data);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
        it.$alert('获取设备测点信息失败', '网络错误', {
          confirmButtonText: '确定',
          // callback: action => {
          //
          // }
        });
      })
      .then(function () {
        // always executed
      });
    },
    parseData(data) {
      let channelTypeAliasList = new Set();
      this.equipmentOptions.length=0;

      for (let datum of data) {
        channelTypeAliasList.add(datum.channeltypealias);
        this.equipmentOptions.push({
          value: datum.pointuuid,
          label: datum.pointname,
          id: datum.pointid,
        });
      }
      this.statusOptions = Array.from(channelTypeAliasList)
    },

  }
}
</script>

<style scoped>
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.title {
  font-size: 24px;
  color: #409EFF;
  margin: 5px;
  padding: 0;
}

.box-card {
  text-align: center;
}

.piece {
  color: #303133;
  width: fit-content;
  padding: 16px 16px;
  margin: 8px auto;
  border: #E4E7ED 1px solid;
  border-radius: 4px;
}

.panel {
  padding: 4px 4px;
}
</style>