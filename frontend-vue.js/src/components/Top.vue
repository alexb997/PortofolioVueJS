<template>
  <section class="d-flex align-items-center">
    <Container class="header">
      <Row class="justify-content-center">
        <Col class="info-box">
          <h1>Bună, sunt Eu</h1>
          <h2>Un programator curios axat pe java si javascript.</h2>
          <p>În continuă aspirație spre mai bine.</p>
        </Col>
      </Row>
    </Container>
  </section>
</template>

<script>
import { Container, Row, Col } from "bootstrap-vue";

export default {
  components: {
    Container,
    Row,
    Col,
  },
};
</script>
