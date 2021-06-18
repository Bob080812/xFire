import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Layout',
    component:()=>import('../components/Layout/Layout'),
    children:[
      {
        path:'/layout/test',
        name:'test',
        component: (resolve) => require(['@/views/test/test'], resolve)
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
