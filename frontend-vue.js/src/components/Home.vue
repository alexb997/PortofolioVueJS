<template>
  <div>
    <Header />
    <Experience />
    <About />
    <Contact />
  </div>
</template>

<script>
import Header from "./Header.vue";
import Experience from "./Experience.vue";
import Contact from "./Contact.vue";
import About from "./About.vue";

export default {
  components: {
    Header,
    Experience,
    Contact,
    About,
  },
};
</script>

<style scoped>
@import url(./home.css);
</style>
