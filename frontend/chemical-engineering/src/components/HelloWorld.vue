<template>
  <div class="hello">
<!--    <h1>{{ msg }}</h1>-->
    <LeftTabMenu></LeftTabMenu>
    <div class="right-part">
      <NavMenu></NavMenu>
      <div class="content">
        <Content
            :types="[
            '设备概貌图',
            '全频谱图',//二维跟三维放到一起
            '倒谱图',
            '包络波形频谱图',
            '振动监测',
            '振动历史比较',
            '单多值棒图',
            '轴心轨迹',
            '轴心位置',
            '启停车图形',
            '综合分析',
            '运行状态图',
            '其他参数趋势图',
            '报警查询',
            ]"
            name="k203b"/>
      </div>
    </div>
  </div>
</template>

<script>
import NavMenu from "@/components/layout/NavMenu";
import LeftTabMenu from "@/components/layout/LeftTabMenu";
import Content from "@/components/layout/Content";

export default {
  name: 'HelloWorld',
  components: {Content, NavMenu,LeftTabMenu},
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 10px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.hello {
  width: 100vw;
  height: 100vh;
  box-sizing: border-box;
  display: flex;
}

.right-part {
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
}
</style>
