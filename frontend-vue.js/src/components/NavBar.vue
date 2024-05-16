<template>
  <div>
    <b-button v-b-toggle.sidebar-left>Toggle Sidebar</b-button>
    <b-sidebar id="sidebar-left" title="Sidebar" left shadow>
      <b-navbar-brand href="#">Portofolio</b-navbar-brand>

      <b-navbar-nav>
        <b-nav-item href="/">Home</b-nav-item>
        <b-nav-item href="/projects">Projects</b-nav-item>
        <b-nav-item href="/blog">Blog</b-nav-item>
      </b-navbar-nav>

      <b-navbar-nav class="ml-auto">
        <b-nav-item href="/admin">Admin</b-nav-item>
      </b-navbar-nav>
    </b-sidebar>
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
.navigation {
  position: fixed;
  top: 0;
}
</style>
