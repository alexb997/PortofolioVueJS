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
          <label>Description</label>
          <input
            type="text"
            class="form-control"
            v-model="description"
            required
          />
        </fieldset>
        <fieldset class="form-group">
          <label>ImgURL</label>
          <input type="text" class="form-control" v-model="imgUrl" required />
          <div v-if="!isValidUrl(imgUrl)" class="text-danger">
            Invalid URL format
          </div>
        </fieldset>
        <fieldset class="form-group">
          <label>GitURL</label>
          <input type="text" class="form-control" v-model="gitUrl" required />
          <div v-if="!isValidUrl(gitUrl)" class="text-danger">
            Invalid URL format
          </div>
        </fieldset>
        <fieldset class="form-group">
          <label>Status</label>
          <select class="form-control" v-model="status" required>
            <option value="Complete">Complete</option>
            <option value="In Development">In Development</option>
          </select>
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
      status: "Complete",
      gitUrl: "",
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
        this.gitUrl = res.data.gitUrl;
        this.status = res.data.status;
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
      if (!this.isValidUrl(this.imgUrl)) {
        this.errors.push("Invalid URL format for ImgURL");
        return;
      }
      if (!this.isValidUrl(this.gitUrl)) {
        this.errors.push("Invalid URL format for GitURL");
        return;
      }
      if (this.id == -1) {
        ProjectDataService.createProject({
          name: this.name,
          description: this.description,
          imgUrl: this.imgUrl,
          status: this.status,
          gitUrl: this.gitUrl,
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
          gitUrl: this.gitUrl,
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
