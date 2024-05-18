<template>
  <b-container>
    <b-row class="mt-5 mb-4 p-3">
      <Top />
    </b-row>
    <b-row class="mb-4 p-3">
      <Experience />
    </b-row>
    <b-row class="mb-4 p-3">
      <About />
    </b-row>
    <b-row class="mb-4 p-3">
      <Contact />
    </b-row>
  </b-container>
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
