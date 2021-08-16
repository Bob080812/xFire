<template>
  <div>
    <el-menu
        router
        :default-active="$route.path"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
      <template v-for="menu in menus">
        <el-menu-item :index="menu.path" :key="menu.title" v-if="!menu.children">{{menu.title}}</el-menu-item>
        <el-submenu :index="menu.title" :key="menu.title" v-else-if="menu.children">
          <template slot="title">{{menu.title}}</template>
          <el-menu-item v-for="childMenu in menu.children" :key="childMenu.title" :index="childMenu.path">{{childMenu.title}}</el-menu-item>
        </el-submenu>
      </template>
    </el-menu>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: "Layout",

  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      menus:[
        {
          children:[
            {
              path:'/layout/test1',
              title:'test1'
            },
            {
              path:'/layout/test2',
              title: 'test2'
            }
          ],
          title:'大类1',
          path: ''
        },
        {
          children:[
            {
              path:'/layout/test3',
              title:'test3'
            },
            {
              path:'/layout/test4',
              title: 'test4'
            }
          ],
          title: '大类2',
          path: ''
        },
        {
          title: '大类3',
          path:'/layout/test'
        }
      ]
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>

</style>
