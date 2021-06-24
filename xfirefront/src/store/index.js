import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userInfo:{
      username:'',
      password:'',
      userRoutes:[],
      userMenu:[]
    }
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
