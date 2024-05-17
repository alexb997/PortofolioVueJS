<template>
  <div class="bd-sidebar border-bottom-0 col-md-3 col-xl-2 col-12 sideBar">
    <b-navbar-brand href="#">Portofolio</b-navbar-brand>

    <b-navbar-nav>
      <b-nav-item href="/">Home</b-nav-item>
      <b-nav-item href="/projects">Projects</b-nav-item>
      <b-nav-item href="/blog">Blog</b-nav-item>
    </b-navbar-nav>

    <b-navbar-nav class="ml-auto">
      <b-nav-item href="/admin">Admin</b-nav-item>
    </b-navbar-nav>
  </div>
</template>

<script>
import { Container } from "bootstrap-vue";

export default {
  components: {
    Container,
  },
};
</script>

<style scoped>
.sideBar {
  position: sticky;
  height: 100vh;
}
</style>
