<template>
  <section id="About" class="about d-flex align-items-center justify-content-center">
    <Container fluid>
      <h2>About</h2>
      <p>About zone still unsure of content</p>

      <div>
        <h2>Or send me a mail:</h2>
        <Button class="sendMailButton"></Button>
      </div>
    </Container>
  </section>
</template>

<script>
import { Container, Button } from "bootstrap-vue";

export default {
  components: {
    Container,
    Button,
  },
};
</script>