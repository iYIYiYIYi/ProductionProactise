<template>
  <el-row :gutter="20">
    <el-col :span="18">
      <div class="grid-content bg-purple" ref="boxes" >
         <div v-if="type==='设备概貌图'" >
          <img :src="'data:image/jepg;base64,'+base64image" alt="示意图" class="image" :style="'width:'+imageWidth*imageMultiplier+'px ;height:'+imageHeight+'px'">
          <div class="boxes-container" ref="boxContainer" :style="'width:'+imageWidth*imageMultiplier+'px ;height:'+imageHeight+'px'">
            <div class="header box" v-if="equipmentName" :style="'width:'+equipmentName.width*imageMultiplier+'px;height:'+equipmentName.height+'px;left:'+equipmentName.xpos*imageMultiplier+'px;top:'+equipmentName.ypos+'px;'">{{equipmentName.name}}</div>
            <div class="header box" v-if="equipmentRevInfo" :style="'width:'+equipmentRevInfo.width*imageMultiplier+'px;height:'+equipmentRevInfo.height+'px;left:'+equipmentRevInfo.xpos*imageMultiplier+'px;top:'+equipmentRevInfo.ypos+'px;'">{{equipmentRevInfo.revname}}:{{equipmentRevInfo.revvalue}}</div>
            <div class="header box" v-if="equipmentTime" :style="'width:'+equipmentTime.width*imageMultiplier+'px;height:'+equipmentTime.height+'px;left:'+equipmentTime.xpos*imageMultiplier+'px;top:'+equipmentTime.ypos+'px;'">{{equipmentTime.time}}</div>

            <div :class="box.width*box.height===0?'no':'box'" v-for="(box,index) in boxPoints" :key="index" :style="'width:'+box.width*imageMultiplier+'px;height:'+box.height+'px;left:'+box.xpos*imageMultiplier+'px;top:'+box.ypos+'px;background-color:'+imageBackground+';'">
              <div class="info_piece" v-for="(point,index) in box.points" :key="index"> {{point.pointid}}:{{point.value}} </div>
            </div>
          </div>
          <div v-if="showImage">
            <e-charts :style="'width:'+imageWidth*imageMultiplier+'px ;'" :option="chartOption"></e-charts>
          </div>
         </div>
        <div v-else>
          <e-charts :option="chartOption"></e-charts>
          <e-charts :option="chartOption"></e-charts>
          <e-charts :option="chartOption"></e-charts>
          <e-charts :option="chartOption"></e-charts>
        </div>
      </div>
    </el-col>
    <el-col :span="6" style="z-index: 2000;position: absolute;right: 1vh">
      <div class="grid-content bg-purple">
        <InfoMenu
          :name="name"
          :equipment-u-u-i-d="dataInfo.equipmentuuid"
          @showCanvas="showCanvas"
          @drawData="drawData"
          ref="info"
        />
      </div>
    </el-col>
  </el-row>
</template>

<script>

import InfoMenu from '../info-component/InfoMenu'
import eCharts from '../info-component/eCharts'


export default {
  name: "ImageCanvas",
  props:{
    name:String,
    dataInfo:Object,
    type:String,
  },
  data() {
    this.getGraphImage(this.dataInfo.equipmentuuid);
    let imageMultiplier = 1.3;
    return {
      base64image:'',
      showImage: false,
      imageWidth:0,
      imageHeight:0,
      imageBackground:'#fff',
      boxPoints:[],
      equipmentName:{},
      equipmentRevInfo:{},
      equipmentTime:{},
      netStatus : true,
      imageMultiplier:imageMultiplier,
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
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
              boundaryGap: false,
              data: this.chartxAxis
        },
        yAxis: {
          type: 'value'
        },
        series: [],
      },
    };
  },
  watch :{
    dataInfo(val) {
      this.getGraphImage(val.equipmentuuid);
      clearInterval(this.$interval);
    },
    imageWidth(val) {
      let leftSpace = window.innerWidth - 720;
      this.imageMultiplier = (leftSpace>val)?(leftSpace/val):1;
    }
  },
  methods:{
    drawData(data,name,time){
      if (this.chartData.indexOf(name) === -1) {
        this.chartData.push(name);
      }
      console.log(this.chartData);

      this.chartxAxis.push(time);
      this.chartOption.legend.data = this.chartData;
      this.chartOption.xAxis.data = this.chartxAxis;
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
          data: data
        };
        this.chartOption.series.push(obj);
      }
      this.chartyAxis.add(name);
    },
    //获取频谱图数据//
    getData(equipmentUuid,pointIdString){
      // Make a request for a user with a given ID
      this.$axios({
        method:'get',
        url:'/trend/'+equipmentUuid+'/'+pointIdString+'/real_time',
        responseType:'json',
      })
      .then(function (response) {
        // handle success
        console.log(response);
        var parse = JSON.parse(response.data);
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
    //历史趋势图//
    getHistory(equipmentUuid,pointIdString,startTime,endTime){
      // Make a request for a user with a given ID
      this.$axios({
        method:'get',
        url:'/trend/'+equipmentUuid+'/'+pointIdString+'/'+startTime+'/'+endTime+'/info',
        responseType:'json',
      })
      .then(function (response) {
        // handle success
        console.log(response);
        var parse = JSON.parse(response.data);
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
    //历史波形频谱图//
    getHistoryWave(equipmentUuid,pointId,trendTime,waveNumber,analysisLines){
      // Make a request for a user with a given ID
      // let it = this;
      this.$axios({
        method:'get',
        url:'/wave-spectrum/'+equipmentUuid+'/'+pointId+'/'+trendTime+'/'+waveNumber+'/'+analysisLines+'/info',
        responseType:'json',
      })
      .then(function (response) {
        // handle success
        console.log(response);
        let parse = JSON.parse(response.data);
        console.log(parse);
      })
      .catch(function (error) {
        // handle error
        console.log(error);

      })
      .then(function () {
        // always executed
      });
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
              it.$alert('获取节点数据失败', '网络错误', {
                confirmButtonText: '确定',
                callback: action => {
                  this.$message({
                    type: 'error',
                    message: `action: ${ action }`
                  });
                }
              });
              it.netStatus = false;
            }
      }).then(function () {

      });
      this.infoMe
    }
  },
  provide: {
  },

  components:{
    InfoMenu,eCharts
  }
}
</script>

<style scoped>
.image {
  margin-left: 40px;
  background-color: white;
}

.boxes-container {
  position: absolute;
  left: 0;
  top: 0;
  margin-left: 50px;
  z-index: 2;
}

.box {
  position: absolute;
  border: white 1px solid;
  border-radius: 4px;

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