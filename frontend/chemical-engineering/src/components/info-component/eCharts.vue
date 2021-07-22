<template>

  <div class="hello">
    <v-chart class="chart" :option="option" :resizable="true" v-on:resize="resize" v-on:datazoom="dataZoom" v-on:brushselected="click"/>
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
    [THEME_KEY]: "myTheme"
  },
  mounted() {
  },
  methods:{
    dataZoom(event){
      this.$emit('dataZoom',event);
    },
    click(event) {
      if (event.batch[0].areas[0])
        this.$emit('clickChart',event.batch[0].areas[0].coordRange);
    },
    resize() {
      VChart.resize()
    }
  }
};
</script>

<style scoped>
.chart {
  width: 100%;
  height: 100%;
  min-width: 50vw;
  min-height: 40vh;
  //width: 55vw;
  //height: 50vh;
  margin: 10px auto;
}
</style>