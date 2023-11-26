<template>
  <div>
    <div class="container">
      <div class="col">
        <h3>{{ this.name }}</h3>
        <div class="row">
          <label>Name: {{ this.name }}</label>
        </div>
        <div class="row">
          <label>Description :{{ this.description }}</label>
        </div>
        <div class="row">
          <label>ImgUrl :{{ this.imgUrl }}</label>
        </div>
        <div class="row">
          <label>Status :{{ this.imgUrl }}</label>
        </div>
      </div>
      <div>
        Posts related to project>
      </div>
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
  },
  created() {
    this.refreshProjectDetails();
  },
};
</script>

<style>
button,
input {
  position: relative;
  z-index: 1;
}
.container,
.col,
.row {
  text-align: center;
  justify-content: center;
}
</style>
