<template>
  <div class="login">
    <video id="v1" autoplay loop muted>
      <source src="~@/assets/login.mp4" type="video/mp4"/>
    </video>
    <el-form class="login-form">
      <h3 class="title">duangduangduang</h3>
      <el-form-item label="用户名:">
        <label slot="label" class="label">用户名:</label>
        <el-input v-model="loginForm.username" class="input"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <label slot="label" class="label">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
        <el-input v-model="loginForm.password" class="input" type="password"></el-input>
      </el-form-item>
      <el-button style="margin-left: 80px;" @click="login">登录</el-button>
      <el-button style="margin-left: 96px;">注册</el-button>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
import Cookies from 'js-cookie'

export default {
  name: "login",
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      token: ''
    }
  },
  methods: {
    login() {
      let username = this.loginForm.username;
      let password = this.loginForm.password;
      axios.post('/admin/system/login', {
        username,
        password
      }).then(response => {
            if (response.data.code == '20000') {
              this.token = response;
              console.log(JSON.stringify(response))
              console.log(this.token.data.data.token);
              Cookies.set('Token', response.data.data.token);
              this.$router.push('/layout')
              this.$message({
                message: '登录成功',
                type: 'success'
              });
            } else {
              this.$message.error('登录失败请重新尝试');
            }
          }
      )
    }
  }
}
</script>

<style lang="scss" scoped>
html {
  width: 100%;
  height: 100%;
  margin: 0px;
  padding: 0px;
}

body {
  margin: 0px;
  padding: 0px;
}

.login {
  width: 100%;
  height: 100%;
  margin: 0px;
  padding: 0px;
  position: fixed;
  top: 0px;
  left: 0px;
  //background-color: red;
  //background-image: url("~@/assets/login.jpg");
  //background-size: cover;
}

.login-form {
  border-radius: 6px;
  background-color: #ffff;
  //background-color: transparent;
  width: 400px;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -100%);
  background-color: rgba(0, 0, 0, 0.5);

  .el-form-item {
    margin-left: 30px;
    margin-right: 30px;
  }
}

.el-input {
  width: 80%;
  border: 0px solid #000000;
  border-bottom-width: 1px;
  background-color: transparent;
}

.el-input /deep/ .el-input__inner {
  background-color: transparent;
  border-top-style: none;
  border-left-style: none;
  border-right-style: none;
  border-bottom-style: none;
  color: white;
  text-align: center;
  text-indent: -50px;
}

.title {
  margin: 5% auto 30px auto;
  text-align: center;
  color: white;
}

video {
  position: fixed;
  right: 0px;
  bottom: 0px;
  min-width: 100%;
  min-height: 100%;
  height: auto;
  width: auto;
  /*加滤镜*/
  /*filter: blur(15px); //背景模糊设置 */
  /*-webkit-filter: grayscale(100%);*/
  /*filter:grayscale(100%); //背景灰度设置*/
  z-index: -11
}

source {
  min-width: 100%;
  min-height: 100%;
  height: auto;
  width: auto;
}

.label {
  color: white;
}

.el-button {
  margin-bottom: 30px;
  background-color: rgba(0, 0, 0, 0.8);
  border: black;
  color: white;
}

.el-button:active {
  margin-bottom: 20px;
  background-color: rgba(0, 0, 0, 0.2);
  border: black;
  color: white;
}
</style>
