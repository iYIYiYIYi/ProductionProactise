<template>
  <el-row :gutter="20">
    <el-col :span="16">
      <div class="grid-content bg-purple">
        <img src="../../../public/k203b.png" alt="示意图" class="image">
      </div>
    </el-col>
    <el-col :span="8">
      <div class="grid-content bg-purple">
        <InfoMenu
          :name="name"
        ></InfoMenu>
      </div>
    </el-col>
  </el-row>
</template>

<script>
const axios = require('axios');

import InfoMenu from '../info-component/InfoMenu'

export default {
  name: "ImageCanvas",
  props:{
    name:String,
    data:Object,
  },
  data() {
    return {

    };
  },

  methods:{
    //获取设备信息//
    getStatus(nodeId){
      // Make a request for a user with a given ID
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/equipment/node/'+nodeId+'/info',
        responseType:'jsonp',
      })
          .then(function (response) {
            // handle success
            console.log(response);
            var parse = JSON.parse(response.data);
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
  },

  //获取频谱图数据//
  getData(equipmentUuid,pointIdString){
    // Make a request for a user with a given ID
    axios({
      method:'get',
      url:'http://192.168.137.1:8848/trend/'+equipmentUuid+'/'+pointIdString+'/real_time',
      responseType:'jsonp',
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
    axios({
      method:'get',
      url:'http://192.168.137.1:8848/trend/'+equipmentUuid+'/'+pointIdString+'/'+startTime+'/'+endTime+'/info',
      responseType:'jsonp',
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
    axios({
      method:'get',
      url:'http://192.168.137.1:8848/wave-spectrum/'+equipmentUuid+'/'+pointId+'/'+trendTime+'/'+waveNumber+'/'+analysisLines+'/info',
      responseType:'jsonp',
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

  components:{
    InfoMenu,
  }
}
</script>

<style scoped>
.image {
  width: 90%;
  margin: 0 5%;
}
</style>