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
        <!-- <fieldset class="form-group">
          <label>{{ project }}</label>
          <input type="text" class="form-control" />
        </fieldset> -->
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
      project: {
        id: "1",
      },
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
        this.project.id = this.id;
        console.log(this.project);
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      PostDataService.createPost({
        title: this.title,
        description: this.description,
        reference: this.reference,
        type: this.type,
        project: this.id,
      }).then(() => {
        this.$router.push("/admin");
      });
    },
  },
  created() {
    this.refreshPostsDetails();
  },
};
</script>
