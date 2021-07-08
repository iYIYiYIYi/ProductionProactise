import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui' //element-ui的全部组件
import 'element-ui/lib/theme-chalk/index.css'//element-ui的css
import Axios from 'axios'

Vue.config.productionTip = false
Vue.use(ElementUI) //使用elementUI

Vue.prototype.$axios = Axios;
Axios.defaults.baseURL = 'http://192.168.137.1:8848';
Axios.defaults.headers.post['Content-Type'] = 'application/json';

new Vue({
  render: h => h(App),
}).$mount('#app')
