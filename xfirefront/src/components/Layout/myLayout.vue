<template>
  <fragment>
    <template v-for="menu in menus">
      <el-menu-item :index="menu.path" :key="menu.path" v-if="!menu.children">{{menu.title}}</el-menu-item>
      <el-submenu :index="menu.path" :key="menu.path" v-else-if="menu.children">
        <template slot="title">{{menu.title}}</template>
        <my-layout :menus="menu.children"></my-layout>
      </el-submenu>
    </template>
  </fragment>


</template>

<script>
export default {
  name: "myLayout",
  props:{
    menus : Array
  }
}
</script>

<style scoped>

</style>
