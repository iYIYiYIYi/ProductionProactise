import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui' //element-ui的全部组件
// import 'element-ui/lib/theme-chalk/index.css'//element-ui的css
import '../theme/index.css'
import Axios from 'axios'
import ECharts from 'vue-echarts'
import * as echarts from 'echarts/core'

// import ECharts modules manually to reduce bundle size
import {
  CanvasRenderer
} from 'echarts/renderers'
import {
  BarChart,
  LineChart,
  ScatterChart,
} from 'echarts/charts'
import {
  GridComponent,
  TooltipComponent,
  ToolboxComponent,
  TitleComponent,
  LegendComponent,
  DataZoomComponent
} from 'echarts/components'

echarts.use([
  CanvasRenderer,
  BarChart,
  GridComponent,
  TooltipComponent,
  DataZoomComponent,
  TooltipComponent,
  GridComponent,
  ToolboxComponent,
  TitleComponent,
  LegendComponent,
  LineChart,
  ScatterChart,
]);

Date.prototype.format = function(fmt) {
  const o = {
    "M+": this.getMonth() + 1,                 //月份
    "d+": this.getDate(),                    //日
    "h+": this.getHours(),                   //小时
    "m+": this.getMinutes(),                 //分
    "s+": this.getSeconds(),                 //秒
    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
    "S": this.getMilliseconds()             //毫秒
  };
  if(/(y+)/.test(fmt)) {
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
  }
  for(const k in o) {
    if(new RegExp("("+ k +")").test(fmt)){
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length===1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    }
  }
  return fmt;
}

let data =

    {
      "color": [
        "#dd6b66",
        "#759aa0",
        "#e69d87",
        "#8dc1a9",
        "#ea7e53",
        "#eedd78",
        "#73a373",
        "#73b9bc",
        "#7289ab",
        "#91ca8c",
        "#f49f42"
      ],
      "backgroundColor": "rgb(61,61,61)",
      "textStyle": {},
      "title": {
        "textStyle": {
          "color": "#eeeeee"
        },
        "subtextStyle": {
          "color": "#aaaaaa"
        }
      },
      "line": {
        "itemStyle": {
          "borderWidth": "1"
        },
        "lineStyle": {
          "width": "2"
        },
        "symbolSize": "15",
        "symbol": "emptyPin",
        "smooth": true
      },
      "radar": {
        "itemStyle": {
          "borderWidth": "1"
        },
        "lineStyle": {
          "width": "2"
        },
        "symbolSize": "15",
        "symbol": "emptyPin",
        "smooth": true
      },
      "bar": {
        "itemStyle": {
          "barBorderWidth": "0",
          "barBorderColor": "#ccc"
        }
      },
      "pie": {
        "itemStyle": {
          "borderWidth": "0",
          "borderColor": "#ccc"
        }
      },
      "scatter": {
        "itemStyle": {
          "borderWidth": "0",
          "borderColor": "#ccc"
        }
      },
      "boxplot": {
        "itemStyle": {
          "borderWidth": "0",
          "borderColor": "#ccc"
        }
      },
      "parallel": {
        "itemStyle": {
          "borderWidth": "0",
          "borderColor": "#ccc"
        }
      },
      "sankey": {
        "itemStyle": {
          "borderWidth": "0",
          "borderColor": "#ccc"
        }
      },
      "funnel": {
        "itemStyle": {
          "borderWidth": "0",
          "borderColor": "#ccc"
        }
      },
      "gauge": {
        "itemStyle": {
          "borderWidth": "0",
          "borderColor": "#ccc"
        }
      },
      "candlestick": {
        "itemStyle": {
          "color": "#fd1050",
          "color0": "#0cf49b",
          "borderColor": "#fd1050",
          "borderColor0": "#0cf49b",
          "borderWidth": 1
        }
      },
      "graph": {
        "itemStyle": {
          "borderWidth": "0",
          "borderColor": "#ccc"
        },
        "lineStyle": {
          "width": 1,
          "color": "#aaa"
        },
        "symbolSize": "15",
        "symbol": "emptyPin",
        "smooth": true,
        "color": [
          "#dd6b66",
          "#759aa0",
          "#e69d87",
          "#8dc1a9",
          "#ea7e53",
          "#eedd78",
          "#73a373",
          "#73b9bc",
          "#7289ab",
          "#91ca8c",
          "#f49f42"
        ],
        "label": {
          "color": "#eee"
        }
      },
      "map": {
        "itemStyle": {
          "areaColor": "#eee",
          "borderColor": "#444",
          "borderWidth": 0.5
        },
        "label": {
          "color": "#000"
        },
        "emphasis": {
          "itemStyle": {
            "areaColor": "rgba(255,215,0,0.8)",
            "borderColor": "#444",
            "borderWidth": 1
          },
          "label": {
            "color": "rgb(100,0,0)"
          }
        }
      },
      "geo": {
        "itemStyle": {
          "areaColor": "#eee",
          "borderColor": "#444",
          "borderWidth": 0.5
        },
        "label": {
          "color": "#000"
        },
        "emphasis": {
          "itemStyle": {
            "areaColor": "rgba(255,215,0,0.8)",
            "borderColor": "#444",
            "borderWidth": 1
          },
          "label": {
            "color": "rgb(100,0,0)"
          }
        }
      },
      "categoryAxis": {
        "axisLine": {
          "show": true,
          "lineStyle": {
            "color": "#eeeeee"
          }
        },
        "axisTick": {
          "show": true,
          "lineStyle": {
            "color": "#eeeeee"
          }
        },
        "axisLabel": {
          "show": true,
          "color": "#eeeeee"
        },
        "splitLine": {
          "show": true,
          "lineStyle": {
            "color": [
              "#aaaaaa"
            ]
          }
        },
        "splitArea": {
          "show": false,
          "areaStyle": {
            "color": [
              "#eeeeee"
            ]
          }
        }
      },
      "valueAxis": {
        "axisLine": {
          "show": true,
          "lineStyle": {
            "color": "#eeeeee"
          }
        },
        "axisTick": {
          "show": true,
          "lineStyle": {
            "color": "#eeeeee"
          }
        },
        "axisLabel": {
          "show": true,
          "color": "#eeeeee"
        },
        "splitLine": {
          "show": true,
          "lineStyle": {
            "color": [
              "#aaaaaa"
            ]
          }
        },
        "splitArea": {
          "show": false,
          "areaStyle": {
            "color": [
              "#eeeeee"
            ]
          }
        }
      },
      "logAxis": {
        "axisLine": {
          "show": true,
          "lineStyle": {
            "color": "#eeeeee"
          }
        },
        "axisTick": {
          "show": true,
          "lineStyle": {
            "color": "#eeeeee"
          }
        },
        "axisLabel": {
          "show": true,
          "color": "#eeeeee"
        },
        "splitLine": {
          "show": true,
          "lineStyle": {
            "color": [
              "#aaaaaa"
            ]
          }
        },
        "splitArea": {
          "show": false,
          "areaStyle": {
            "color": [
              "#eeeeee"
            ]
          }
        }
      },
      "timeAxis": {
        "axisLine": {
          "show": true,
          "lineStyle": {
            "color": "#eeeeee"
          }
        },
        "axisTick": {
          "show": true,
          "lineStyle": {
            "color": "#eeeeee"
          }
        },
        "axisLabel": {
          "show": true,
          "color": "#eeeeee"
        },
        "splitLine": {
          "show": true,
          "lineStyle": {
            "color": [
              "#aaaaaa"
            ]
          }
        },
        "splitArea": {
          "show": false,
          "areaStyle": {
            "color": [
              "#eeeeee"
            ]
          }
        }
      },
      "toolbox": {
        "iconStyle": {
          "borderColor": "#999"
        },
        "emphasis": {
          "iconStyle": {
            "borderColor": "#666"
          }
        }
      },
      "legend": {
        "textStyle": {
          "color": "#eeeeee"
        }
      },
      "tooltip": {
        "axisPointer": {
          "lineStyle": {
            "color": "#eeeeee",
            "width": "0"
          },
          "crossStyle": {
            "color": "#eeeeee",
            "width": "0"
          }
        }
      },
      "timeline": {
        "lineStyle": {
          "color": "#eeeeee",
          "width": 1
        },
        "itemStyle": {
          "color": "#dd6b66",
          "borderWidth": 1
        },
        "controlStyle": {
          "color": "#eeeeee",
          "borderColor": "#eeeeee",
          "borderWidth": 0.5
        },
        "checkpointStyle": {
          "color": "#e43c59",
          "borderColor": "#c23531"
        },
        "label": {
          "color": "#eeeeee"
        },
        "emphasis": {
          "itemStyle": {
            "color": "#a9334c"
          },
          "controlStyle": {
            "color": "#eeeeee",
            "borderColor": "#eeeeee",
            "borderWidth": 0.5
          },
          "label": {
            "color": "#eeeeee"
          }
        }
      },
      "visualMap": {
        "color": [
          "#bf444c",
          "#d88273",
          "#f6efa6"
        ]
      },
      "dataZoom": {
        "backgroundColor": "rgba(47,69,84,0)",
        "dataBackgroundColor": "rgba(255,255,255,0.3)",
        "fillerColor": "rgba(167,183,204,0.4)",
        "handleColor": "#a7b7cc",
        "handleSize": "100%",
        "textStyle": {
          "color": "#eeeeee"
        }
      },
      "markPoint": {
        "label": {
          "color": "#eee"
        },
        "emphasis": {
          "label": {
            "color": "#eee"
          }
        }
      }
    };



echarts.registerTheme('myTheme',data)

// register globally (or you can do it locally)
Vue.component('v-chart', ECharts)
Vue.config.productionTip = false
Vue.use(ElementUI) //使用elementUI

Vue.prototype.$axios = Axios;
Axios.defaults.baseURL = 'http://47.117.116.187:8848/';
Axios.defaults.headers.post['Content-Type'] = 'application/json';

new Vue({
  render: h => h(App),
}).$mount('#app')
