<template>
  <el-row :gutter="20">
    <el-col :span="18">
      <div class="grid-content bg-purple" ref="boxes" >
         <div v-if="type==='设备概貌图'" >
           <div v-if="fresh" :key="imageMultiplier">
            <img :src="'data:image/jepg;base64,'+base64image" alt="示意图" class="image" :style="{width:imageWidth*imageMultiplier+'px',height:imageHeight+'px'}">
            <div class="boxes-container" ref="boxContainer" :style="{width:imageWidth*imageMultiplier+'px',height:imageHeight+'px'}">
              <div class="header box" v-if="equipmentName" :style="{width:equipmentName.width*imageMultiplier+'px',height:equipmentName.height+'px',left:equipmentName.xpos*imageMultiplier+'px',top:equipmentName.ypos+'px'}">{{equipmentName.name}}</div>
              <div class="header box" v-if="equipmentRevInfo" :style="{width:equipmentRevInfo.width*imageMultiplier+'px',height:equipmentRevInfo.height+'px',left:equipmentRevInfo.xpos*imageMultiplier+'px',top:equipmentRevInfo.ypos+'px'}">{{equipmentRevInfo.revname}}:{{equipmentRevInfo.revvalue}}</div>
              <div class="header box" v-if="equipmentTime" :style="{width:equipmentTime.width*imageMultiplier+'px',height:equipmentTime.height+'px',left:equipmentTime.xpos*imageMultiplier+'px',top:equipmentTime.ypos+'px'}">{{equipmentTime.time}}</div>

              <div :class="box.width*box.height===0?'no':'box'" v-for="(box,index) in boxPoints" :key="index" :style="{width:box.width*imageMultiplier+'px',height:box.height+'px',left:box.xpos*imageMultiplier+'px',top:box.ypos+'px',backgroundColor:imageBackground}">
                <div class="info_piece" v-for="(point,index) in box.points" :key="index"> {{point.pointid}}:{{point.value}} </div>
              </div>
            </div>
            <div v-if="showImage">
              <e-charts :style="{width:imageWidth*imageMultiplier+'px'}" :option="chartOption"></e-charts>
              <br>
            </div>
           </div>
         </div>
        <div v-else>
          <e-charts  v-if="showImage" :option="chartOption"></e-charts>
          <e-charts  v-if="showImage" :option="revOption"></e-charts>
          <e-charts  v-if="showImage" :option="waveOption" @dataZoom="onDataZoom" @clickChart="onClick" style="height: 50vh"></e-charts>
          <e-charts  v-if="showImage" :option="spectrumOption"></e-charts>
          <br>
        </div>
      </div>
    </el-col>
    <el-col :span="4" style="z-index: 2000;position: fixed;right:3vh;top:8vh;padding: 8px;min-width: min-content">
      <div class="grid-content bg-purple">
        <InfoMenu
          :name="name"
          :type="type"
          :equipment-u-u-i-d="dataInfo.equipmentuuid"
          @showCanvas="showCanvas"
          @drawData="drawData"
          @drawWaveAndSpectrumAndSoOn="drawWaveAndSpectrumAndSoOn"
          ref="info"
        />
      </div>
    </el-col>
    <el-dialog
        :visible.sync="dialogVisible"
        width="90vw"
        top="5vh"
        :before-close="handleClose">
      <e-charts style="width: 88vw;height: 78vh" :option="activeOption" @dataZoom="onDataZoom"></e-charts>
    </el-dialog>
  </el-row>
</template>

<script>

import InfoMenu from '../info-component/InfoMenu';
import eCharts from '../info-component/eCharts';
import { setInterval, clearInterval } from "timers";

export default {
  name: "ImageCanvas",
  props:{
    name:String,
    dataInfo:Object,
    type:String,
  },
  data() {
    this.getGraphImage(this.dataInfo.equipmentuuid);
    let vue_it = this;
    return {
      base64image:'',
      fresh:true,
      showImage: false,
      imageWidth:0,
      imageHeight:0,
      imageBackground:'#4e4e43',
      boxPoints:[],
      equipmentName:{},
      equipmentRevInfo:{},
      equipmentTime:{},
      netStatus : true,
      imageMultiplier:1,
      chartxAxis:[],
      chartyAxis:new Set(),
      chartData:[],
      chartOption: {
        title: {
          text: this.name+'实时趋势图'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: this.chartData
        },
        grid: {
          top:'18%',
          left: '12%',
          right: '12%',
          bottom: '4%',
          containLabel: true,
          width:'76%',
          height:'80%',
        },
        toolbox: {
          feature: {
            saveAsImage: {},
            dataZoom: {
              yAxisIndex: 'none'
            },
            myExpand: {
              show: true,
              title: '放大',
              icon: 'path://M432.45,595.444c0,2.177-4.661,6.82-11.305,6.82c-6.475,0-11.306-4.567-11.306-6.82s4.852-6.812,11.306-6.812C427.841,588.632,432.452,593.191,432.45,595.444L432.45,595.444z M421.155,589.876c-3.009,0-5.448,2.495-5.448,5.572s2.439,5.572,5.448,5.572c3.01,0,5.449-2.495,5.449-5.572C426.604,592.371,424.165,589.876,421.155,589.876L421.155,589.876z M421.146,591.891c-1.916,0-3.47,1.589-3.47,3.549c0,1.959,1.554,3.548,3.47,3.548s3.469-1.589,3.469-3.548C424.614,593.479,423.062,591.891,421.146,591.891L421.146,591.891zM421.146,591.891',
              onclick: function (){
                vue_it.openExpandWindow('chartOption');
              }
            },
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.chartxAxis,
          name:'时间'
        },
        yAxis: {
          type: 'value',
          name: 'um',
        },
        series: [],
      },
      revOption: {
        title: {
          text: this.name+'实时转速趋势图'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data:['转速']
        },
        grid: {
          top:'18%',
          left: '12%',
          right: '12%',
          bottom: '4%',
          containLabel: true,
          width:'76%',
          height:'80%',
        },
        toolbox: {
          feature: {
            saveAsImage: {},
            dataZoom: {
              yAxisIndex: 'none'
            },
            myExpand: {
              show: true,
              title: '放大',
              icon: 'path://M432.45,595.444c0,2.177-4.661,6.82-11.305,6.82c-6.475,0-11.306-4.567-11.306-6.82s4.852-6.812,11.306-6.812C427.841,588.632,432.452,593.191,432.45,595.444L432.45,595.444z M421.155,589.876c-3.009,0-5.448,2.495-5.448,5.572s2.439,5.572,5.448,5.572c3.01,0,5.449-2.495,5.449-5.572C426.604,592.371,424.165,589.876,421.155,589.876L421.155,589.876z M421.146,591.891c-1.916,0-3.47,1.589-3.47,3.549c0,1.959,1.554,3.548,3.47,3.548s3.469-1.589,3.469-3.548C424.614,593.479,423.062,591.891,421.146,591.891L421.146,591.891zM421.146,591.891',
              onclick: function (){
                vue_it.openExpandWindow('chartOption');
              }
            },
          }
        },
        xAxis: {
          type: 'category',
          name: '时间',
          boundaryGap: false,
          data: this.chartxAxis
        },
        yAxis: {
          type: 'value',
          name: 'r/min',
        },
        series: [{
          name: '转速',
          type: 'line',
          data: [],
          areaStyle: {},
        }],
      },
      spectrumOption: {
        title: {
          text: this.name+'实时频谱图',
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['频谱']
        },
        grid: {
          top:'18%',
          left: '12%',
          right: '12%',
          bottom: '4%',
          containLabel: true,
          width:'76%',
          height:'80%',
        },
        toolbox: {
          feature: {
            saveAsImage: {},
            dataZoom: {
              yAxisIndex: 'none'
            },
            myExpand: {
              show: true,
              title: '放大',
              icon: 'path://M432.45,595.444c0,2.177-4.661,6.82-11.305,6.82c-6.475,0-11.306-4.567-11.306-6.82s4.852-6.812,11.306-6.812C427.841,588.632,432.452,593.191,432.45,595.444L432.45,595.444z M421.155,589.876c-3.009,0-5.448,2.495-5.448,5.572s2.439,5.572,5.448,5.572c3.01,0,5.449-2.495,5.449-5.572C426.604,592.371,424.165,589.876,421.155,589.876L421.155,589.876z M421.146,591.891c-1.916,0-3.47,1.589-3.47,3.549c0,1.959,1.554,3.548,3.47,3.548s3.469-1.589,3.469-3.548C424.614,593.479,423.062,591.891,421.146,591.891L421.146,591.891zM421.146,591.891',
              onclick: function (){
                vue_it.openExpandWindow('spectrumOption');
              }
            },
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: [],
          name: '秒',
          axisLabel: {
            show: true,

          },
        },
        yAxis: {
          type: 'value',
          name: 'um',
        },
        series: [{
          name: '频谱',
          type: 'line',
          data: [],
        }],
      },
      waveOption: {
        title: {
          text: this.name+'实时波形图',
          subtext: ''
        },
        tooltip: {
          trigger: 'axis'
        },
        grid: {
          top:'26%',
          left: '12%',
          right: '12%',
          bottom: '4%',
          containLabel:true,
          width:'76%',
          height:'58%',
        },
        toolbox: {
          feature: {
            saveAsImage: {},
            dataZoom: {
              yAxisIndex: false
            },
            brush: {
              type: ['lineX', 'clear'],
            },
            myExpand: {
              show: true,
              title: '放大',
              icon: 'path://M432.45,595.444c0,2.177-4.661,6.82-11.305,6.82c-6.475,0-11.306-4.567-11.306-6.82s4.852-6.812,11.306-6.812C427.841,588.632,432.452,593.191,432.45,595.444L432.45,595.444z M421.155,589.876c-3.009,0-5.448,2.495-5.448,5.572s2.439,5.572,5.448,5.572c3.01,0,5.449-2.495,5.449-5.572C426.604,592.371,424.165,589.876,421.155,589.876L421.155,589.876z M421.146,591.891c-1.916,0-3.47,1.589-3.47,3.549c0,1.959,1.554,3.548,3.47,3.548s3.469-1.589,3.469-3.548C424.614,593.479,423.062,591.891,421.146,591.891L421.146,591.891zM421.146,591.891',
              onclick: function (){
                vue_it.openExpandWindow('waveOption');
              }
            },
          }
        },
        brush: {
          xAxisIndex: 'all',
          brushLink: 'all',
          outOfBrush: {
            colorAlpha: 0.1
          }
        },
        dataZoom: [{
          type: 'inside',
          start: 0,
          end: 10
        }, {
          type: 'slider',
          start: 0,
          end: 10,
          top:'85%',
          // handleIcon: 'path://M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
          // handleSize: '70%',
          // handleStyle: {
          //   color: '#fff',
          // }
        }],
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: [],
          name: 'Hz',
        },
        yAxis: {
          type: 'value',
          name: 'um',
        },
        series: [{
          name: '波形',
          type: 'line',
          sampling: 'average',
          data: [],
        }],
      },
      dialogVisible: false,
      dialogName:'',
      activeOption:{
        title: {
          text: '实时图'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: this.chartData
        },
        grid: {
          top:'8%',
          left: '8%',
          right: '8%',
          bottom: '8%',
          containLabel: true,
        },
        toolbox: {
          feature: {
            saveAsImage: {},
            dataZoom: {
              yAxisIndex: 'none'
            },
          }
        },
        xAxis: {},
        yAxis: {},
        series: [],
      },
      screenWidth: document.body.clientWidth,
    };
  },
  watch :{
    dataInfo(val) {
      this.getGraphImage(val.equipmentuuid);
      clearInterval(this.$interval);
    },
    imageWidth(val) {
      this.imageWidth = val;
      this.imageMultiplier = (this.screenWidth*0.60)/this.imageWidth;
    },
    name(val) {
      this.chartOption.title.text = val+'实时趋势图';
      this.waveOption.title.text = val+'实时波形图';
      this.spectrumOption.title.text = val+'实时频谱图';

      this.chartData = []
      this.chartxAxis = []
      this.chartyAxis.clear();

      this.chartOption.xAxis.data = [];
      this.chartOption.series = [];
      this.chartOption.legend.data = [];

      this.revOption.xAxis.data = [];
      this.revOption.series[0].data = [];

      this.waveOption.xAxis.data = [];
      this.waveOption.series[0].data = [];

      this.spectrumOption.xAxis.data = [];
      this.spectrumOption.series[0].data = [];
    },
    screenWidth (val) {
      this.screenWidth = val
      if (!this.timer) {
        this.timer = true;
        // this.$nextTick(() => {
        //   this.fresh = false;
        // });
        let that = this;
        setTimeout(function () {
          // that.screenWidth = that.$store.state.canvasWidth
          that.imageMultiplier = (that.screenWidth*0.60)/that.imageWidth;
          // that.$nextTick(() => {
          //   that.fresh = true;
          // });
          that.timer = false
        }, 200)
      }
    },
  },
  mounted() {
    const that = this
    window.onresize = () => {
      return (() => {
        window.screenWidth = document.body.clientWidth
        that.screenWidth = window.screenWidth
      })()
    }
  },
  methods:{
    handleClose(done) {
      this.$confirm('确认关闭？')
          .then(() => {
            done();
          })
          .catch(() => {});
    },
    openExpandWindow(objName) {
      this.activeOption.title.text = this[objName].title.text;
      this.activeOption.xAxis = this[objName].xAxis;
      this.activeOption.yAxis = this[objName].yAxis;
      this.activeOption.series = this[objName].series;
      if (this[objName].dataZoom)
        this.activeOption.dataZoom = this[objName].dataZoom;
      if (this[objName].brush)
        this.activeOption.brush = this[objName].brush;
      else
        this.activeOption.brush = undefined;
      this.dialogVisible = true;
    },
    onClick(range) {
      let point0 = this.waveOption.xAxis.data[range[0]];
      let point1 = this.waveOption.xAxis.data[range[1]];
      let res = 1 / (point1 - point0)
      this.waveOption.title.subtext = 'ΔF = 1s / ( '+point1+'s - '+point0+'s ) = '+res.toPrecision(4)+' Hz';
    },
    onDataZoom (event) {
      if (event.batch) {
        // 在图表内使用鼠标滚轮缩放
        this.dataZoom = {
          start: event.batch[0].start,
          end: event.batch[0].end
        }
      } else {
        // 使用滑块缩放
        this.dataZoom = {
          start: event.start,
          end: event.end
        }
      }
    },
    drawData(data,name,time,rev,xAxis,revs){
      if (this.chartData.indexOf(name) === -1) {
        this.chartData.push(name);
      }

      if (time) {
        this.chartxAxis.push(time);
        this.revOption.title.text.replace('实时','历史');
        this.chartOption.title.text.replace('实时','历史');
      } else if (xAxis) {
        this.chartxAxis = xAxis;
        this.revOption.title.text.replace('历史','实时');
        this.chartOption.title.text.replace('历史','实时');
      }
      this.chartOption.legend.data = this.chartData;
      if (time&&this.chartxAxis.length > 20) {
        this.chartxAxis.shift();
      }
      this.chartOption.xAxis.data = this.chartxAxis;
      this.revOption.xAxis.data = this.chartxAxis;

      if (rev !== undefined) {
        this.revOption.series[0].data.push(rev);
      }
      else if (revs) {
        this.revOption.series[0].data = revs;
      }

      if (this.chartyAxis.has(name)) {
        for (let serie of this.chartOption.series) {
          if (serie.name === name) {
            serie.data = data;
            break;
          }
        }
      } else {
        let obj =  {
          name: name,
          type: 'line',
          data: data,
          areaStyle: {},
        };
        this.chartOption.series.push(obj);
      }
      this.chartyAxis.add(name);
    },
    drawWaveAndSpectrumAndSoOn(SpectrumData,WaveData,pointId,history) {
      this.spectrumOption.xAxis.data = SpectrumData.x;
      this.spectrumOption.series[0].data = SpectrumData.y;
      if (history) {
        this.spectrumOption.title.text = this.name+' '+pointId+' 历史频谱图';
        this.waveOption.title.text =  this.name+' '+pointId+' 历史波形图';
      }
      else {
        this.spectrumOption.title.text = this.name+' '+pointId+' 实时频谱图';
        this.waveOption.title.text =  this.name+' '+pointId+' 实时波形图';
      }

      this.waveOption.xAxis.data = WaveData.x;
      this.waveOption.series[0].data = WaveData.y;

      if (this.waveOption.dataZoom && this.dataZoom) {
        this.waveOption.dataZoom[0].start = this.dataZoom.start;
        this.waveOption.dataZoom[0].end = this.dataZoom.end;

        this.waveOption.dataZoom[1].start = this.dataZoom.start;
        this.waveOption.dataZoom[1].end = this.dataZoom.end;

        if (this.activeOption.dataZoom) {
          this.activeOption.dataZoom[0].start = this.dataZoom.start;
          this.activeOption.dataZoom[0].end = this.dataZoom.end;

          this.activeOption.dataZoom[1].start = this.dataZoom.start;
          this.activeOption.dataZoom[1].end = this.dataZoom.end;
        }
      }
    },
    showCanvas(bool){
      this.showImage = bool;
    },
    getGraphImage(equipmentUuid){
      let it = this;
      // Make a request for a user with a given ID

      this.$axios({
        method:'get',
        url:'/graph/'+equipmentUuid+'/info',
        responseType:'json',
      })
          .then(function (response) {
            // handle success
            let parse = response.data;
            it.$data.base64image = parse.data[0]['graphimagebase64code'];
            it.$data.imageWidth = parse.data[0].graphimagewidth;
            it.$data.imageHeight = parse.data[0].graphimageheight;
            it.$data.imageBackground = parse.data[0].graphimagebackground;

            it.updateData(equipmentUuid);
            it.$interval = setInterval(function () {
              it.updateData(equipmentUuid);
            },1000);
          })
          .catch(function () {
            // handle error
            it.$notify.error({
              title: '网络错误',
              message: '获取图片失败'
            });
          })
          .then(function () {
            // always executed
          });
    },

    updateData(equipmentUUID){
      let it = this;

      it.$axios.get('/graph/'+equipmentUUID+'/data')
          .then(function (response) {
            let parse = response.data;
            it.$data.boxPoints = parse.data[0].listboxes;
            it.$data.equipmentName = parse.data[0].equipmentname;
            it.$data.equipmentRevInfo = parse.data[0].revinfo;
            it.$data.equipmentTime = parse.data[0].time;
          }).catch(function () {
            if (it.netStatus) {
              it.$notify({
                type: 'error',
                message: `获取节点数据失败`
              });
              it.netStatus = false;
            }
      }).then(function () {

      });
    }
  },
  provide: {
  },

  components:{
    InfoMenu,eCharts
  },
  beforeDestroy() {
    clearInterval(this.$interval)
  }
}
</script>

<style scoped>
.image {
  margin-left: 40px;
  background-color: #3d3d3d;
}

.boxes-container {
  position: absolute;
  left: 0;
  top: 0;
  margin-left: 50px;
  z-index: 2;
}

.el-card__body {
  padding: 8px;
}

.box {
  position: absolute;
  border-radius: 4px;
  border: 1px solid slategray;
  box-sizing: border-box;
  display: block;
  white-space: nowrap;
  font-size: 12px;
  color: #ececec;
  overflow: auto;
  list-style: none;
  z-index: 2;
}

.info_piece {
  font-size: 12px;
  display: flex;
}

.header {
  font-size: 15px;
  text-align: center;
  border: none;
}

.no {
  display: none;
}

</style>