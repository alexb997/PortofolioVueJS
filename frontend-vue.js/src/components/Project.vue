<template>
  <div>
    <h3>Project</h3>
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
          <label>Name</label>
          <input type="text" class="form-control" v-model="name" />
        </fieldset>
        <fieldset class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description" />
        </fieldset>
        <fieldset class="form-group">
          <label>ImgUrl</label>
          <input type="text" class="form-control" v-model="imgUrl" />
        </fieldset>
        <fieldset class="form-group">
          <label>Status</label>
          <input type="text" class="form-control" v-model="status" />
        </fieldset>
        <button class="btn btn-success" type="submit">Save</button>
      </form>
    </div>
  </div>
</template>
<script>
import ProjectDataService from "../service/ProjectDataService";

export default {
  name: "Project",
  data() {
    return {
      name: "",
      description: "",
      imgUrl: "",
      status: "",
      errors: [],
    };
  },
  computed: {
    id() {
      return this.$route.params.id;
    },
  },
  methods: {
    refreshProjectDetails() {
      ProjectDataService.retrieveProject(this.id).then((res) => {
        this.name = res.data.name;
        this.description = res.data.description;
        this.imgUrl = res.data.imgUrl;
        this.status = res.data.status;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if (this.id == -1) {
        ProjectDataService.createProject({
          name: this.name,
          description: this.description,
          imgUrl: this.imgUrl,
          status: this.status,
        }).then(() => {
          this.$router.push("/projects");
        });
      } else {
        ProjectDataService.updateProject(this.id, {
          id: this.id,
          name: this.name,
          description: this.description,
          imgUrl: this.imgUrl,
          status: this.status,
        }).then(() => {
          this.$router.push("/projects");
        });
      }
    },
  },
  created() {
    this.refreshProjectDetails();
  },
};
</script>
