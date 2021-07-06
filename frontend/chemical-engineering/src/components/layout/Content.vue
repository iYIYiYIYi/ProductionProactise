<template>
  <div>
    <H1>Hello World</H1>
    <el-button round @click="click">圆角按钮</el-button>
  </div>
</template>

<script>
export default {
  name: "Content",
  methods: {
    click() {
      alert("Hello World");
    },
  },
}
</script>

<style scoped>

</style>