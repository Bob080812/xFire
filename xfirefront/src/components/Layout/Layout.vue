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
      <my-layout :menus="menus"></my-layout>
    </el-menu>
    <router-view/>
  </div>
</template>

<script>
import MyLayout from "@/components/Layout/myLayout";
export default {
  name: "Layout",
  components: {MyLayout},
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
            }
          ],
          title:'大类1',
          path: '1'
        },
        {
          children:[
            {
              path:'/layout/test3',
              title:'test3',
              children:[{
                path:'/layout/test2',
                title: 'test2'
              }]
            },
            {
              path:'/layout/test4',
              title: 'test4'
            }
          ],
          title: '大类2',
          path: '2'
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

<style >
.myelmenu{
  padding-left: 100px;
}
</style>
