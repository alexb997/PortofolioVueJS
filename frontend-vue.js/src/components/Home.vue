<template>
  <div >
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
import NavBar from "./NavBar.vue";

export default {
  components: {
    Top,
    Experience,
    Contact,
    NavBar,
    About,
  },
};
</script>
