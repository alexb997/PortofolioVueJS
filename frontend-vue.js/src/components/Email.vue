<template>
  <section
    id="email"
    class="email d-flex align-items-center justify-content-center"
  >
    <Container fluid>
      <div>
        <h2>Or send me a mail</h2>
        <b-button variant="outline-primary" class="sendMailButton">
          <b-icon icon="envelope"></b-icon>
        </b-button>
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
          <b-form-group
            id="input-group-1"
            label="Email address:"
            label-for="input-1"
            description="We'll never share your email with anyone else."
          >
            <b-form-input
              id="input-1"
              v-model="form.email"
              type="email"
              placeholder="Enter email"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="input-group-2"
            label="Your Name:"
            label-for="input-2"
          >
            <b-form-input
              id="input-2"
              v-model="form.name"
              placeholder="Enter name"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-3" label="Message:" label-for="input-3">
            <b-form-input
              id="input-3"
              v-model="form.message"
              placeholder="Enter message"
              required
            ></b-form-input>
          </b-form-group>

          <b-button type="submit" variant="primary">Submit</b-button>
          <b-button type="reset" variant="danger">Reset</b-button>
        </b-form>
        <!-- <b-card class="mt-3" header="Form Data Result">
            <pre class="m-0"> -->
      </div>
    </Container>
  </section>
</template>

<script>
import { Container } from "bootstrap-vue";

export default {
  components: {
    Container,
  },
  data() {
    return {
      form: {
        email: "",
        name: "",
        message: "",
      },
      show: true,
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset(event) {
      event.preventDefault();
      this.form.email = "";
      this.form.name = "";
      this.form.food = null;
      this.form.checked = [];
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>
