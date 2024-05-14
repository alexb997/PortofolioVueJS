<template>
  <div class="container projects">
    <h3>All Projects</h3>
    <div class="row">
      <div class="col-md-4" v-for="(project, index) in projects" :key="index">
        <b-card
          img-top
          class="bCard m-3"
          tag="project"
          :title="project.name"
          :sub-title="project.status"
          :img-src="project.imgUrl"
          :img-alt="project.name"
        >
          <b-card-text>
            {{ project.description }}
            {{ project.imgUrl }}
          </b-card-text>

          <router-link :to="'/project/' + project.id" class="card-link"
            >Details</router-link
          >
          <b-link :href="project.gitUrl" class="card-link" target="_blank"
            >Github</b-link
          >
        </b-card>
      </div>
    </div>
    <b-pagination
      v-model="currentPage"
      :total-rows="totalRows"
      :per-page="pageSize"
      @input="pageChanged"
    />
  </div>
</template>
<script>
import ProjectDataService from "../service/ProjectDataService";

export default {
  name: "Projects",
  data() {
    return {
      projects: [],
      currentPage: 1,
      pageSize: 10,
      totalRows: 1,
      totalPages: 1,
      message: "",
    };
  },
  methods: {
    refreshProjects() {
      ProjectDataService.retrieveAllProjects(this.currentPage, this.pageSize)
        .then((response) => {
          const responseData = response.data;
          this.projects = responseData;
          this.totalRows = responseData.totalElements;
          this.totalPages = responseData.totalPages;
        })
        .catch((error) => {
          console.error("Error fetching projects:", error);
        });
    },
    pageChanged(newPage) {
      this.currentPage = newPage;
      this.refreshProjects();
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
