<template>
  <div class="hello">
<!--    <h1>{{ msg }}</h1>-->
    <NavMenu></NavMenu>
    <LeftTabMenu></LeftTabMenu>
  </div>
</template>

<script>
import NavMenu from "@/components/layout/NavMenu";
import LeftTabMenu from "@/components/layout/LeftTabMenu";
export default {
  name: 'HelloWorld',
  components: {NavMenu,LeftTabMenu},
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
</style>
