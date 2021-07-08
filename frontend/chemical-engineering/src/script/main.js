import Vue from 'vue'
import App from '../App.vue'
import ElementUI from 'element-ui' //element-ui的全部组件
import 'element-ui/lib/theme-chalk/index.css'//element-ui的css
import myCharts from '../myCharts'
Vue.use(myCharts)
Vue.config.productionTip = false
Vue.use(ElementUI) //使用elementUI


new Vue({
  render: h => h(App),
}).$mount('#app')
