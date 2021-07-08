import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui' //element-ui的全部组件
import 'element-ui/lib/theme-chalk/index.css'//element-ui的css
import Axios from 'axios'
import ECharts from 'vue-echarts'
import { use } from 'echarts/core'

// import ECharts modules manually to reduce bundle size
import {
  CanvasRenderer
} from 'echarts/renderers'
import {
  BarChart
} from 'echarts/charts'
import {
  GridComponent,
  TooltipComponent
} from 'echarts/components'

use([
  CanvasRenderer,
  BarChart,
  GridComponent,
  TooltipComponent
]);

// register globally (or you can do it locally)
Vue.component('v-chart', ECharts)
Vue.config.productionTip = false
Vue.use(ElementUI) //使用elementUI

Vue.prototype.$axios = Axios;
Axios.defaults.baseURL = 'http://192.168.137.1:8848';
Axios.defaults.headers.post['Content-Type'] = 'application/json';

new Vue({
  render: h => h(App),
}).$mount('#app')
