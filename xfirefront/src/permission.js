import router from './router'
import {asyRoutes} from './router/index'
import Cookies from 'js-cookie'
console.log("permissions加载了")
//const whiteList = ['/login', '/auth-redirect', '/bind', '/register']
let addRouFlag = false

router.beforeEach((to, from, next) => {
    if(to.name!='login'){
        if(Cookies.get('Token')){
            next()
            if (!addRouFlag) {
                addRouFlag = true
                // 2.根据用户的角色、和需要动态展示的路由，生成符合用户角色的路由
                router.addRoute(
                    asyRoutes
                )
                console.log("router.push('Layout')");
                router.push({name:'Layout'});
            }
        }else {
            // eslint-disable-next-line no-debugger
            // debugger;
            next({name:'login'})
        }
    }else {
        next()
    }


})
