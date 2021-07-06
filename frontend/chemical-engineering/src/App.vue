<template>
  <div id="app">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin: 0;
  width: 100vw;
  height: 100vh;
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}

/* 设置滚动条的样式 */
::-webkit-scrollbar {
  width:4px;
}
/* 滚动槽 */
::-webkit-scrollbar-track {
  -webkit-box-shadow:inset 0 0 6px #409EFF;
  border-radius:0;
}
/* 滚动条滑块 */
::-webkit-scrollbar-thumb {
  border-radius:0;
  background:#F56C6C;
}
::-webkit-scrollbar-thumb:window-inactive {
  background:#909399;
}


body {
  margin: 0;
}
</style>
