<template>
  <el-tabs type="border-card" class="tabs">
    <el-tab-pane v-for="type in types" :key="type" :label="type">
      <ImageCanvas :name="name">

      </ImageCanvas>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import ImageCanvas from "./ImageCanvas";

export default {
  name: "Content",
  props:{
    types:Array,
    name:String
  },
  components:{
    ImageCanvas,
  },
}
</script>

<style scoped>
.tabs{
  overflow-y: auto;
  overflow-x: hidden;
}
</style>