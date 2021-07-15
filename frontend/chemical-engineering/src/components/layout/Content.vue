<template>
  <div>
    <el-tabs v-if="dataInfo.equipmentuuid" type="border-card" class="tabs">
      <el-tab-pane v-for="type in types" :key="type" :label="type">
        <ImageCanvas :name="name" :type="type" :dataInfo="dataInfo">

        </ImageCanvas>
      </el-tab-pane>
    </el-tabs>
    <el-empty description="请选择设备" image="./loading.png" :image-size=500 v-else></el-empty>
  </div>
</template>

<script>
import ImageCanvas from "./ImageCanvas";

export default {
  name: "Content",
  props:{
    types:Array,
    name:String,
    dataInfo:Object,
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