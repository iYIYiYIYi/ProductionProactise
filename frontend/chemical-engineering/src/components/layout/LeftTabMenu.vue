<template>
  <div class="left-tab-menu">

    <el-col :span="12">
      <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
        <el-menu-item index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span style="font-size: 18px">在线监测平台</span>
          </template>
        </el-menu-item>
        <div class="node-tree">

          <el-button icon="el-icon-search" circle @click="getNodeld"></el-button>


        </div>
      </el-menu>
    </el-col>
  </div>
</template>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
}

.left-tab-menu {
  height: 100%;
  background-color: #545c64;
  width: fit-content;
  box-sizing: border-box;
  border-right: solid 2px #e6e6e6;
  margin: 0;
}

</style>

<script>
const axios = require('axios');

export default {
  name:'LeftTabMenu',
  data() {
    return {
      isCollapse: true
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    //获取节点信息//
    getNodeld(){
      // Make a request for a user with a given ID
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/node/info',
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
    //获取设备信息//
    getstatus(){
      // Make a request for a user with a given ID
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/equipment/node/{nodeId}/info',
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
    //获取测点信息//
    getmessage(){
      // Make a request for a user with a given ID
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/point/{equipmentUuid}/detail',
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
    //获取频谱图数据//
    getdata(){
      // Make a request for a user with a given ID
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/trend/{equipmentUuid}/{pointIdString}/real_time',
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
    gethistory(){
      // Make a request for a user with a given ID
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/trend/{equipmentUuid}/{pointIdString}/{startTime}/{endTime}/info',
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
    gethistorywave(){
  // Make a request for a user with a given ID
  axios({
    method:'get',
    url:'http://192.168.137.1:8848/wave-spectrum/{equipmentUuid}/{pointId}/{trendTime}/{waveNumber}/{analysisLines}/info',
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
  }
}
</script>