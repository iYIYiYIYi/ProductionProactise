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
              <el-select v-model="statusValue" placeholder="请选择" default-first-option>
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
              <el-select v-model="selectEquipments"
                         :clearable="true"
                         :filterable="true"
                         multiple
                         placeholder="请选择">
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
            <div v-if="dataMode">
              <br>
              起始日期:
              <el-date-picker
                  v-model="startDate"
                  align="right"
                  type="date"
                  placeholder="选择日期"
                  :picker-options="pickerOptions">
              </el-date-picker>
              结束日期:
              <el-date-picker
                  v-model="endDate"
                  align="right"
                  type="date"
                  placeholder="选择日期"
                  :picker-options="pickerOptions">
              </el-date-picker>
            </div>
            <el-divider><i class="el-icon-receiving"></i></el-divider>
            <el-button :type="stop_switch_type" @click="stopSwitch" style="width: 60%">{{stop_switch}}</el-button>
          </div>
        </div>
      </keep-alive>
  </el-card>
</template>

<script>
import { setInterval, clearInterval } from "timers";
export default {
  name: "InfoMenu",
  props :{
    name:String,
    equipmentUUID:String,
    type:String,
  },
  data() {
    this.getMessage(this.equipmentUUID);

    return {
      openChart:false,
      dataMode:false,
      stop_switch:'停止',
      stop_switch_type:'primary',
      options: [],
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
      startDate: '',
      endDate: '',
      historyDate:{
        start:0,
        end:0,
      },
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
      statusValue:'all',
      trendStatusValues:{},
      historyTrendStatusValues:{},
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
      this.selectEquipments = [];
      this.genData(val);
    },
    startDate(val) {
      this.historyDate.start = val.getTime();
      if ((!this.historyDate.start > this.historyDate.end)) {
        for (let selectEquipment of this.selectEquipments) {
          this.handleHistory(selectEquipment);
        }
      }
    },
    endDate(val) {
      this.historyDate.end = val.getTime();
      if (this.historyDate.start > this.historyDate.end) {
        this.$notify.error({
          title: '时间错误',
          message: '起始日期晚于结束日期'
        });
      } else if (this.historyDate.start === 0||this.historyDate.end === 0) {
        this.$notify.info({
          title:'选择时间',
          message:'请选择起始/结束时间',
        });
      } else {
        for (let selectEquipment of this.selectEquipments) {
          this.handleHistory(selectEquipment);
        }
      }
    },
  },
  methods : {
    handleCheckChange(data, checked, indeterminate) {
      console.log(data, checked, indeterminate);
    },
    handleHistory(pointid) {
      //获取历史数据
      let it = this;
      this.$axios.get('/trend/'+this.equipmentUUID+'/'+pointid+'/'+this.historyDate.start+'/'+this.historyDate.end+'/info')
      .then(responce => {
        let parse = responce.data.data[0];
        let times = [];
        let revs = [];
        /** 获取历史趋势图 **/
        let trendInfos = parse.trendInfos;
        for (let trendInfo of trendInfos) {
          if(!it.historyTrendStatusValues[pointid])
            it.historyTrendStatusValues[pointid] = [];
          let time = new Date(trendInfo.trendtime).format('yyyy-MM-dd hh:mm:ss');
          times.push(time);
          revs.push(trendInfo.rev);
          it.historyTrendStatusValues[pointid].push([time,trendInfo.trendValues[it.statusValue]]);
        }

        it.$emit('drawData',it.historyTrendStatusValues[pointid],pointid,undefined,undefined,times,revs);
        if (it.type === '频率检测' && it.selectEquipments[0] === pointid) {
          console.log('nothing');
          // this.$axios.get('/wave-spectrum/'+this.equipmentUUID+'/'+pointid+'/'+trendInfos[0].trendtime+'/16384/0/info')
          // .then(function (response) {
          //   let parse = response.data.data[0];
          //
          // }).catch(reason => {
          //   console.log(reason);
          //   it.$notify.error({
          //     title: '网络错误',
          //     message: '获取历史数据失败'
          //   });
          // });
        }
      }).catch((error) => {
        console.error(error);
        it.$notify.error({
          title: '网络错误',
          message: '获取历史数据失败'
        });
      });

    },
    change(){
      this.$emit('showCanvas',this.openChart);
      this.changeDataMode();
    },
    changeDataMode(){
      if (this.dataMode) {
        //历史模式
        clearInterval(this.equipmentDataTimer);

      } else if (this.$data.stop_switch !== '恢复') {
        //实时模式
        let it = this;
        this.equipmentDataTimer = setInterval(function () {
          if (!it.openChart) {
            clearInterval(it.equipmentDataTimer);
            it.trendStatusValues = {};
          }

          for (let selectEquipment of it.selectEquipments) {
            it.getEquipmentData(selectEquipment);
          }
        },2500);
      }
    },
    stopSwitch() {
      if (this.$data.stop_switch === '停止') {
        this.$data.stop_switch = '恢复';
        this.$data.stop_switch_type = 'danger';
        clearInterval(this.equipmentDataTimer);
      } else {
        this.$data.stop_switch = '停止';
        this.$data.stop_switch_type = 'primary';
        let it = this;
        //实时模式
        this.equipmentDataTimer = setInterval(function () {
          if (!it.openChart)
            clearInterval(it.equipmentDataTimer);

          for (let selectEquipment of it.selectEquipments) {
            it.getEquipmentData(selectEquipment);
          }
        },2500);
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
          });
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

      // this.statusValue = this.statusOptions[0];
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

        it.$emit('drawData',it.trendStatusValues[pointid],pointid,time,parse.rev);

        if (it.type === '频率检测' && it.selectEquipments[0] === pointid) {
          let spectrumData = {
            x:JSON.parse(parse.trendSpectrumvalue.spectrumx),
            y:JSON.parse(parse.trendSpectrumvalue.spectrumy),
          };
          let waveData = {
            x:JSON.parse(parse.trendWavevalue.wavex),
            y:JSON.parse(parse.trendWavevalue.wavey),
          };


          it.$emit('drawWaveAndSpectrumAndSoOn',spectrumData,waveData,pointid);
        }
      }).catch(() => {
        it.$notify.error({
          title: '网络错误',
          message: '获取图谱数据失败',
        });
      }).then(() => {

      });
    },
  },
  beforeDestroy() {
    clearInterval(this.equipmentDataTimer);
  },
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
  margin: 4px;
  padding: 0;
}

.box-card {
  text-align: center;
}

.piece {
  color: #c4ff58;
  width: fit-content;
  padding: 16px 16px;
  margin: 4px auto;
  border: #E4E7ED 1px solid;
  border-radius: 4px;
  overflow-y: auto;
  max-height: 50vh;
  min-width: min-content;
}

.panel {
  padding: 4px 4px;
  min-height: 8vh;
}

.el-card__body {
  padding: 8px;
  background-color: #4e4e43;
}
</style>