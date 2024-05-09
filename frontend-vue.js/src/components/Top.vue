<template>
  <section class="top d-flex align-items-center justify-content-center">
    <Container fluid>
      <h1>Bună, sunt Eu</h1>
      <h2>Un programator curios axat pe java si javascript.</h2>
      <p>În continuă aspirație spre mai bine.</p>
    </Container>
  </section>
</template>

<script>
import { Container, Row, Col } from "bootstrap-vue";

export default {
  name: "Top",
  components: {
    Container,
    Row,
    Col,
  },
};
</script>
