<template>
  <el-row :gutter="20">
    <el-col :span="16">
      <div class="grid-content bg-purple">
        <img src="../../../public/k203b.png" alt="示意图" class="image">
      </div>
    </el-col>
    <el-col :span="8">
      <div class="grid-content bg-purple">
        <InfoMenu
          :name="name"
        ></InfoMenu>
      </div>
    </el-col>
  </el-row>
</template>

<script>
import InfoMenu from '../info-component/InfoMenu'

export default {
  name: "ImageCanvas",
  props:{
    name:String,
    data:Object,
  },
  data() {
    return {

    };
  },

  methods:{

  },
  components:{
    InfoMenu,
  }
}
</script>

<style scoped>
.image {
  width: 90%;
  margin: 0 5%;
}
</style>