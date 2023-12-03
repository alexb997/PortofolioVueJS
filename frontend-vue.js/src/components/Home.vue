<template>
  <div>
    <Top />
    <Experience />
    <About />
    <Contact />
  </div>
</template>

<script>
import Top from "./Top.vue";
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
