<template>
  <Container>
    <Top />
    <Experience />
    <About />
    <Contact />
  </Container>
</template>

<script>
import Top from "./Top.vue";
import Experience from "./Experience.vue";
import Contact from "./Contact.vue";
import About from "./About.vue";
import { Container } from "bootstrap-vue";

export default {
  components: {
    Top,
    Experience,
    Contact,
    About,
  },
};
</script>
