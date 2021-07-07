<template>
  <el-card class="box-card">
    <h3 class="title">操作菜单</h3>
    <div class="piece">
      设备名称:{{ name }}
    </div>
    <el-switch
        v-model="openChart"
        @change="change"
        active-text="显示图谱"
        inactive-text="关闭图谱">
    </el-switch>
    <keep-alive>
      <div class="panel" v-if="openChart">
        <div class="piece">
          <div>
            类型选择:
            <el-select v-model="value" placeholder="请选择">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled">
              </el-option>
            </el-select>
          </div>
        </div>
      </div>
    </keep-alive>
  </el-card>
</template>

<script>
const axios = require('axios');

export default {
  name: "InfoMenu",
  props :{
    name:String,
    options: [{
      value: '选项1',
      label: '黄金糕'
    }, {
      value: '选项2',
      label: '双皮奶',
      disabled: true
    }, {
      value: '选项3',
      label: '蚵仔煎'
    }, {
      value: '选项4',
      label: '龙须面'
    }, {
      value: '选项5',
      label: '北京烤鸭'
    }],
    // eslint-disable-next-line vue/require-prop-type-constructor
    value: '',

  },
  data() {
    return {
      openChart:false,
    }
  },
  methods : {
    change(){

    },

    //获取测点信息//
    getMessage(equipmentUuid){
      // Make a request for a user with a given ID
      axios({
        method:'get',
        url:'http://192.168.137.1:8848/point/'+equipmentUuid+'/detail',
        responseType:'jsonp',
      })
          .then(function (response) {
            // handle success
            console.log(response);
            var parse = JSON.parse(response.data);
            console.log(parse)
          })
          .catch(function (error) {
            // handle error
            console.log(error);
          })
          .then(function () {
            // always executed
          });
    },

  }
}
</script>

<style scoped>
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.title {
  font-size: 24px;
  color: #E6A23C;
  margin: 5px;
  padding: 0;
}

.box-card {
  text-align: center;
}

.piece {
  color: #303133;
  width: fit-content;
  padding: 4px 16px;
  margin: 8px auto;
  border: #E4E7ED 1px solid;
  border-radius: 4px;
}
</style>