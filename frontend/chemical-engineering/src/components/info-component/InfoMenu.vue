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
            <el-select v-model="statusValue" placeholder="请选择">
              <el-option
                  v-for="item in statusOptions"
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
        label: '蜜雪冰城',
      }],
      statusValue:'',
      selectEquipments:[],
      FrequencyData:{},
      equipmentOptions:[{
        value: '选项2',
        label: '双皮奶',
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }],
      data:[],
      defaultProps: {
        children: 'children',
        label: 'label'
      }
    }
  },
  watch:{
    equipmentUUID(val) {
      this.selectEquipments.length = 0;
      this.getMessage(val);
    },
    value(val) {
      this.genData(val);
    }
  },
  methods : {
    handleCheckChange(data, checked, indeterminate) {
      console.log(data, checked, indeterminate);
    },
    change(){

    },
    changeDataMode(){

    },
    getFrequencyData(){
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
        it.data = data;
        it.parseData(data);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
        it.$notify.error({
          title: '网络错误',
          message: '获取设备测点信息失败'
        });
      })
      .then(function () {
        // always executed
      });
    },
    parseData(data) {
      let channelTypeAliasList = new Set();
      this.equipmentOptions.length=0;
      this.options = [];

      for (let datum of data) {
        if (!channelTypeAliasList.has(datum.channeltypealias)) {
          this.options.push({
            label:datum.channeltypealias,
            value:datum.channeltypealias,
          })
        }
        channelTypeAliasList.add(datum.channeltypealias);
      }

      this.value = this.options[0].value;
    },

    genData(value) {
      this.statusOptions = [];

      for (let datum of this.data) {
        if (datum.channeltypealias === value) {
          this.equipmentOptions.push({
            id: datum.pointid,
            label: datum.pointname,
            value: datum.pointuuid,
          });


        }
      }
    }

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