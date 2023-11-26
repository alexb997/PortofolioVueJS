<template>
    <div class="container ">
        <div class="links">
            <a :href="'admin/projects'">
                Projects
            </a>
            <a :href="'admin/posts'">
                Posts
            </a>
        </div>
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
.container{
    height: 100vh;
}
.links{
    padding-top: 10vh;
}
a{
    position: relative;
    z-index: 1;
}
</style>