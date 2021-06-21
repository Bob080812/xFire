<template>
  <div>
    <el-button @click="testPost">访问测试</el-button>
    发送内容：
    <el-input v-model="message"></el-input>
    <el-button @click="sendMessage">发送</el-button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "test",
  data() {
    return {
      path: "ws://127.0.0.1:9000/test/oneToOne",
      socket: "",
      message: ''
    }
  },
  mounted() {
    // 初始化
    this.init()
  },
  destroyed() {
    // 销毁监听
    this.socket.onclose = this.close
  },
  methods: {
    testPost() {
      axios.post('/test/aaa').then(response => {
        console.log(response)
      })
    },
    init() {
      if (typeof (WebSocket) === "undefined") {
        alert("您的浏览器不支持socket")
      } else {
        // 实例化socket
        this.socket = new WebSocket(this.path)
        // 监听socket连接
        this.socket.onopen = this.open
        // 监听socket错误信息
        this.socket.onerror = this.error
        // 监听socket消息
        this.socket.onmessage = this.getMessage
      }
    },
    open() {
      console.log("socket连接成功")
    },
    error() {
      console.log("连接错误")
    },
    getMessage(msg) {
      console.log(msg.data)
    },
    send(params) {
      this.socket.send(params)
    },
    close() {
      console.log("socket已经关闭")
    },
    sendMessage() {
      let a =
          {
            userId: 0,
            message: this.message
          }
      this.send(JSON.stringify(a));
    }
  }
}
</script>

<style scoped>

</style>
