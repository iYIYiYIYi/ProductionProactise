<template>

  <div class="hello">
    <v-chart class="chart" :option="option1" />
    <v-chart class="chart" :option="option2" />
    <v-chart class="chart" :option="option3" />
    <v-chart class="chart" :option="option4" />
  </div>

</template>

<script>
import * as echarts from 'echarts/core';
import {
  TitleComponent,
  ToolboxComponent,
  TooltipComponent,
  GridComponent,
  LegendComponent
} from 'echarts/components';
import {
  LineChart
} from 'echarts/charts';
import {
  CanvasRenderer
} from 'echarts/renderers';

import VChart, { THEME_KEY } from "vue-echarts";

echarts.use([TitleComponent, ToolboxComponent, TooltipComponent, GridComponent, LegendComponent, LineChart, CanvasRenderer]);

export default {
  name: "eCharts",
  components: {
    VChart
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
      option2 : {
        title: {
          text: 'K-203B 实时转速趋势图'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['联盟广告']
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
            name: '联盟广告',
            type: 'line',
            stack: '总量',
            data: [220, 182, 191, 234, 290, 330, 310]
          },
        ]
      },
      option3 : {
        title: {
          text: 'K203B 仪表位号_1H 实时波形图'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['视频广告']
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
            name: '视频广告',
            type: 'line',
            stack: '总量',
            data: [150, 232, 201, 154, 190, 330, 410]
          },
        ]
      },
      option4 : {
        title: {
          text: 'K203B 仪表位号_1H 实时频谱图'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['直接访问']
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
            name: '直接访问',
            type: 'line',
            stack: '总量',
            data: [320, 332, 301, 334, 390, 330, 320]
          },
        ]
      },
    };
  }
};
</script>

<style scoped>
.chart {
  width: 48vw;
  height: 45vh;
  margin: 0 auto;
}
</style>