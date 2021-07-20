<template>

  <div class="hello">
    <v-chart class="chart" :option="option" v-on:datazoom="dataZoom"/>
  </div>

</template>

<script>


import VChart, { THEME_KEY } from "vue-echarts";

export default {
  name: "eCharts",
  components: {
    VChart
  },
  props: {
    option:Object,
  },
  provide: {
    [THEME_KEY]: "bright"
  },
  data() {
    return {
      option1 : {
        title: {
          text: 'K-203B 实时趋势图'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['邮件营销']
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
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '邮件营销',
            type: 'line',
            stack: '总量',
            data: [120, 132, 101, 134, 90, 230, 210]
          },
        ]
      },
    };
  },
  methods:{
    dataZoom(event){
      this.$emit('dataZoom',event);
    },
  }
};
</script>

<style scoped>
.chart {
  width: 100%;
  height: 100%;
  min-width: 50vw;
  min-height: 25vh;
  //width: 55vw;
  //height: 50vh;
  margin: 10px auto;
}
</style>