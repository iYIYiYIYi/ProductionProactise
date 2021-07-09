<template>
  <div class="hello">
<!--    <h1>{{ msg }}</h1>-->
    <LeftTabMenu @changeContent="changeContent"></LeftTabMenu>
    <div class="right-part">
      <NavMenu ></NavMenu>
      <div class="content">
        <Content
            :types="[
            '设备概貌图',
            '频率检测',//二维跟三维放到一起
            ]"
            :name="name"
            :dataInfo="select_data"
        />
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
  },
  data(){
    return {
      name:'',
      select_data:{},

    }
  },
  methods :{
    changeContent(data,name) {
      console.log(data,name);
      this.$data.name = name;
      this.$data.select_data = data;
    },

  },
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
