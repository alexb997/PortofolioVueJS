<template>
  <b-container-fluid class="sideBar">
    <div class=" buttons-zone pt-5">
      <div class="button-nav pb-3"><a href="/">Home</a></div>
      <div class="button-nav pb-3"><a href="/projects">Projects</a></div>
      <div class="button-nav pb-3"><a href="/blog">Blog</a></div>
    </div>
    <b-container class="links-zone">
      <b-row>
        <b-col>
          <a
            target="_blank"
            rel="noreferrer"
            href="https://www.linkedin.com/in/alexandru-b%C3%AEl%C4%83-2b91a3198/"
            class="link"
          >
            <b-icon icon="linkedin"></b-icon>
          </a>
        </b-col>
        <b-col>
          <a
            target="_blank"
            rel="noreferrer"
            href="https://github.com/alexb997"
            class="link"
          >
            <b-icon icon="github"></b-icon>
          </a>
        </b-col>
        <b-col>
          <a
            target="_blank"
            rel="noreferrer"
            href="https://www.facebook.com/alexandru.bila.90/"
            class="link"
          >
            <b-icon icon="facebook"></b-icon>
          </a>
        </b-col>
      </b-row>
    </b-container>
  </b-container-fluid>
</template>

<script>
import { Container } from "bootstrap-vue";

export default {
  components: {
    Container,
  },
};
</script>
