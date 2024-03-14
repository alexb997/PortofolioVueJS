<template>
  <div class="container projects">
    <h3>All Projects</h3>
    <div class="container">
      <b-card-group deck v-for="i in Math.ceil(projects.length / 2)" :key="i">
        <b-card
          img-top
          class="bCard m-3"
          tag="project"
          v-for="project in projects.slice((i - 1) * 2, (i - 1) * 2 + 2)"
          v-bind:key="project.id"
          :title="project.name"
          :sub-title="project.status"
          :img-src="project.imgUrl"
          :img-alt="Image"
        >
          <b-card-text>
            {{ project.description }}
            {{ project.imgUrl }}
          </b-card-text>

          <a :href="'/project/' + project.id" class="card-link">Details</a>
          <!-- <b-link href="#" class="card-link">Github</b-link> -->
        </b-card>
      </b-card-group>
    </div>
  </div>
</template>
<script>
import ProjectDataService from "../service/ProjectDataService";

export default {
  name: "Projects",
  data() {
    return {
      projects: [],
      message: "",
    };
  },
  methods: {
    refreshProjects() {
      ProjectDataService.retrieveAllProjects().then((res) => {
        this.projects = res.data;
      });
    },
  },
  created() {
    this.refreshProjects();
  },
};
</script>

<style>
a {
  position: relative;
  z-index: 1;
}

.projects {
  min-height: 100vh;
}

.bCard {
  color: white;
  background-color: rgba(0, 0, 0, 0.137);
}
</style>
