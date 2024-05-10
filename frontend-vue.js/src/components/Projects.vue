<template>
  <div class="container projects">
    <h3>All Projects</h3>
    <div class="container">
      <b-card-group deck v-for="page in Math.ceil(totalPages)">
        <b-card
          img-top
          class="bCard m-3"
          tag="project"
          v-for="project in currentPageProjects"
          :key="project.id"
          :title="project.name"
          :sub-title="project.status"
          :img-src="project.imgUrl"
          :img-alt="Image"
        >
          <b-card-text>
            {{ project.description }}
            {{ project.imgUrl }}
          </b-card-text>

          <router-link :to="'/project/' + project.id" class="card-link">Details</router-link>
          <b-link href="#" class="card-link">Github</b-link>
        </b-card>
      </b-card-group>
      <b-pagination v-model="currentPage" :total-rows="totalRows" :per-page="pageSize" @input="pageChanged" />
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
      currentPageProjects: [],
      currentPage: 1,
      pageSize: 7, 
      totalRows: 0,
      totalPages: 0,
      message: "",
    };
  },
  methods: {
    refreshProjects() {
      ProjectDataService.retrieveAllProjects({ page: this.currentPage, size: this.pageSize })
      .then((response) => {
        const responseData = response.data;
        this.currentPageProjects = responseData.content;
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
