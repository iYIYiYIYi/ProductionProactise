<template>
  <div class="menu">

    <div class="head el-menu-item">

        <i class="el-icon-cloudy-and-sunny" style="color: white;"></i>
        <span style="font-size: 24px;color: white">在线监测平台</span>

    </div>

    <div class="search el-menu-item ">
      <el-input
          placeholder="请输入内容"
          clearable
          v-model="search_value">
        <i slot="prefix" class="el-input__icon el-icon-search"></i>
      </el-input>
    </div>

    <div class="left-tab-menu">

      <el-col :span="12">

        <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>导航一</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </div>
  </div>
</template>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 240px;
}

.menu {
  height: 100%;
  overflow-x: hidden;
  overflow-y: hidden;
  background-color: #545c64;
}

.left-tab-menu {
  height: 90%;
  background-color: #545c64;
  width: fit-content;
  box-sizing: border-box;
  border-right: solid 2px #e6e6e6;
  margin: 0;
  overflow-y: auto;
  overflow-x: hidden;
}

.head {
  background-color: #E6A23C;
  color: white;
  height: 6%;
}

.search {
  height: 4%;
  background-color: white;
}
</style>

<script>
export default {
  name:'LeftTabMenu',
  data() {
    return {
      isCollapse: true,
      search_value:'',

    };
  },
  props: {

  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>