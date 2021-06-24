import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component:()=>import ('../components/login/login'),
  },
  {
    path: '/layout',
    name: 'Layout',
    component:()=>import('../components/Layout/Layout'),
    redirect:'/layout/test',
    children:[
      {
        path:'/layout/test',
        name:'test',
        component: (resolve) => require(['@/views/test/test'], resolve)
      },
      {
        path:'/layout/test1',
        name:'test1',
        component: (resolve) => require(['@/views/test/test1'], resolve)
      },
      {
        path:'/layout/test2',
        name:'test2',
        component: (resolve) => require(['@/views/test/test2'], resolve)
      },
      {
        path:'/layout/test3',
        name:'test3',
        component: (resolve) => require(['@/views/test/test3'], resolve)
      },{
        path:'/layout/test4',
        name:'test4',
        component: (resolve) => require(['@/views/test/test4'], resolve)
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
