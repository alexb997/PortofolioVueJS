<template>
  <div>
    <h3>Post</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <div v-if="errors.length">
          <div
            class="alert alert-danger"
            v-bind:key="index"
            v-for="(error, index) in errors"
          >
            {{ error }}
          </div>
        </div>
        <fieldset class="form-group">
          <label>Title</label>
          <input type="text" class="form-control" v-model="title" />
        </fieldset>
        <fieldset class="form-group">
          <label>Type</label>
          <input type="text" class="form-control" v-model="type" />
        </fieldset>
        <fieldset class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description" />
        </fieldset>
        <fieldset class="form-group">
          <label>Reference</label>
          <input type="text" class="form-control" v-model="reference" />
        </fieldset>
        <button class="btn btn-success" type="submit">Save</button>
      </form>
    </div>
  </div>
</template>
<script>
import PostDataService from "../service/PostDataService";

export default {
  name: "Post",
  data() {
    return {
      title: "",
      description: "",
      reference: "",
      type: "",
      errors: [],
    };
  },
  computed: {
    id() {
      return this.$route.params.id;
    },
  },
  methods: {
    refreshPostsDetails() {
      PostDataService.retrievePost(this.id).then((res) => {
        this.title = res.data.title;
        this.description = res.data.description;
        this.reference = res.data.reference;
        this.type = res.data.type;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if (this.id == -1) {
        PostDataService.createPost({
          title: this.title,
          description: this.description,
          reference: this.reference,
          type: this.type,
        }).then(() => {
          this.$router.push("/admin");
        });
      } else {
        PostDataService.updatePost(this.id, {
          id: this.id,
          title: this.title,
          description: this.description,
          reference: this.reference,
          type: this.type,
        }).then(() => {
          this.$router.push("/admin");
        });
      }
    },
  },
  created() {
    this.refreshPostsDetails();
  },
};
</script>

<style>
button,
input {
  position: relative;
  z-index: 1;
}
</style>
