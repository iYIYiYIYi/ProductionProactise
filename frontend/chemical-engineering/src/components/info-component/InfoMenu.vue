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
          <div v-if="value.indexOf('振动') !== -1">
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
        value: 'all',
        label: '通频',
      },{
        value: 'one',
        label: '1倍频幅值',
      },{
        value: 'two',
        label: '2倍频幅值',
      },{
        value: 'three',
        label: '3倍频幅值',
      },{
        value: 'half',
        label: '1/2倍频幅值',
      },{
        value: 'res',
        label: '残振',
      },{
        value: 'dc',
        label: '直流量',
      },{
        value: 'gap',
        label: '间隙电压',
      },{
        value: 'phaseone',
        label: '1倍频相位',
      },{
        value: 'phasetwo',
        label: '2倍频相位',
      },{
        value: 'phasethree',
        label: '3倍频相位',
      },{
        value: 'phasehalf',
        label: '1/2倍频相位',
      }],
      statusValue:'',
      trendStatusValues:{},
      selectEquipments:[],
      equipmentOptions:[{
        value: '选项2',
        label: '双皮奶',
      }, {
        value: '选项3',
        label: '蚵仔煎'
      }],
      data:[],
      equipmentDataTimer:undefined,
      defaultProps: {
        children: 'children',
        label: 'label'
      }
    }
  },
  watch:{
    equipmentUUID(val) {
      this.selectEquipments = [];
      this.getMessage(val);
    },
    value(val) {
      this.genData(val);
    },
  },
  methods : {
    handleCheckChange(data, checked, indeterminate) {
      console.log(data, checked, indeterminate);
    },
    change(){
      this.$emit('showCanvas',this.openChart);
      if (! this.dataMode) {
        let it = this;
        //实时模式
        this.equipmentDataTimer = setInterval(function () {
          for (let selectEquipment of it.selectEquipments) {
            it.getEquipmentData(selectEquipment);
          }
        },1000);
      }
    },
    changeDataMode(){
      this.selectEquipments.length = 0;
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
        let data = parse.data;
        it.data = data;
        it.parseData(data);
      })
      .catch(function () {
        // handle error
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
      this.equipmentOptions=[];
      this.options = [];

      for (let datum of data) {
        let s = '径向',name = datum.channeltypealias;
        if (datum.channeltypealias.indexOf('振动') !== -1) {
          if (datum.channeltype === 1) {
            name = s + name;
          } else if (datum.channeltype === 2) {
            s = '轴向';
            name = s + name;
          }
        }
        if (!channelTypeAliasList.has(name)) {

          this.options.push({
            label:name,
            value:name,
          })
        }
        channelTypeAliasList.add(name);
      }

      this.value = this.options[0].value;
    },

    genData(value) {
      this.equipmentOptions=[];
      for (let datum of this.data) {
        let s = '径向',name = datum.channeltypealias;
        if (datum.channeltypealias.indexOf('振动') !== -1) {
          if (datum.channeltype === 1) {
            name = s + name;
          } else if (datum.channeltype === 2) {
            s = '轴向';
            name = s + name;
          }
        }
        if (name === value) {
          this.equipmentOptions.push({
            uuid: datum.pointuuid,
            label: datum.pointname,
            value: datum.pointid,
          });
        }
      }
    },
    getEquipmentData(pointid)  {
      let it = this;
      this.$axios.get('/trend/'+this.equipmentUUID+'/'+pointid+'/real_time')
      .then(response => {
        let parse = response.data.data[0];
        /** 获取实时趋势图 **/
        let trendValue = parse.trendvalue;
        if(!it.trendStatusValues[pointid])
          it.trendStatusValues[pointid] = [];
        let time = new Date(parse.trendtime).format('yyyy-MM-dd hh:mm:ss');
        it.trendStatusValues[pointid].push([time,trendValue[it.statusValue]]);
        it.$emit('drawData',it.trendStatusValues[pointid],pointid,time);
      }).catch(() => {

      }).then(() => {

      });
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