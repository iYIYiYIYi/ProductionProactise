<template>
  <el-row :gutter="20">
    <el-col :span="16">
      <div class="grid-content bg-purple" id="boxes">
        <img :src="'data:image/jepg;base64,'+base64image" alt="示意图" class="image">
      </div>
    </el-col>
    <el-col :span="8">
      <div class="grid-content bg-purple">
        <InfoMenu
          :name="name"
          :equipment-u-u-i-d="dataInfo.equipmentuuid"
        />
      </div>
    </el-col>
  </el-row>
</template>

<script>

import InfoMenu from '../info-component/InfoMenu'

export default {
  name: "ImageCanvas",
  props:{
    name:String,
    dataInfo:Object,
  },
  data() {
    this.getGraphImage(this.dataInfo.equipmentuuid);

    return {
      base64image:'',
    };
  },
  watch :{
    dataInfo(val ,oldVal) {
      console.log(val,oldVal);
      this.getGraphImage(val.equipmentuuid);
    }
  },
  methods:{
    //获取设备信息//
    getStatus(nodeId){
      // Make a request for a user with a given ID
      this.$axios({
        method:'get',
        url:'/equipment/node/'+nodeId+'/info',
        responseType:'json',
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
            console.log(parse);
            it.$data.base64image = parse.data[0]['graphimagebase64code'];
          })
          .catch(function (error) {
            // handle error
            console.log(error);
            it.$alert('获取图片失败', '网络错误', {
              confirmButtonText: '确定',
              callback: action => {
                this.$message({
                  type: 'error',
                  message: `action: ${ action }`
                });
              }
            });
          })
          .then(function () {
            // always executed
          });
    },
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