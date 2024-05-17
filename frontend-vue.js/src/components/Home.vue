<template>
  <Row class="row flex-xl-nowrap2">
    <NavBar />
    <div class="bd-content col-md-9 col-xl-8 col-12 pb-md-3 pl-md-5">
      <Top />
      <Experience />
      <About />
      <Contact />
    </div>
  </Row>
</template>

<script>
import Top from "./Top.vue";
import Experience from "./Experience.vue";
import Contact from "./Contact.vue";
import About from "./About.vue";
import NavBar from "./NavBar.vue";
import { Row } from "bootstrap-vue";

export default {
  components: {
    Top,
    Experience,
    Contact,
    NavBar,
    About,
    Row,
  },
};
</script>
