<template>
  <div class="navigation">
    <b-navbar toggleable="lg" type="dark" variant="dark">
      <b-navbar-brand href="#">Portofolio</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="/">Home</b-nav-item>
          <b-nav-item href="/projects">Projects</b-nav-item>
          <b-nav-item href="/blog">Blog</b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item href="/admin">Admin</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
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
.navbar.navbar-dark.bg-dark {
  background-color: rgba(0, 0, 0, 0.137) !important;
}
.navigation {
  position: sticky;
  top: 0;
  z-index: 1;
}
</style>
