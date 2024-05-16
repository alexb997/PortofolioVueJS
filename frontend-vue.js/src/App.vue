<template>
  <Container fluid>
    <Row>
      <NavBar />
      <router-view />
    </Row>
  </Container>
</template>

<script>
import NavBar from "./components/NavBar.vue";
import { Container, Row } from "bootstrap-vue";

export default {
  components: {
    NavBar,
    Container,
    Row,
  },
  name: "app",
};
</script>

<style>
@import url(https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css);
@import url(./style/Global.css);
</style>
