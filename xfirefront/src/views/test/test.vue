<template>
  <el-button @click="testPost">访问测试</el-button>
</template>

<script>
import axios from "axios";

export default {
name: "test",
  methods:{
  testPost(){
    axios.post('/test/aaa').then(response=>{
      console.log(response)
    })
  }
  }
}
</script>

<style scoped>

</style>
