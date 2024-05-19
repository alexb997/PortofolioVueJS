<template>
  <div class="projects">
    <h3>All Projects</h3>
    <div class="col">
      <div class="p-2" v-for="(project, index) in projects" :key="index">
        <router-link :to="`/project/${project.id}`">
          <b-card
            no-body
            bg-variant="dark"
            text-variant="white"
            class="overflow-hidden project-card"
            style="max-height: 300px;"
          >
            <b-row no-gutters>
              <b-col md="6">
                <b-card-img
                  :src="project.imgUrl"
                  :alt="project.name"
                  class="rounded-0"
                ></b-card-img>
              </b-col>
              <b-col md="6">
                <b-card-body :title="project.name" :sub-title="project.status">
                  <hr />
                </b-card-body>
                <div class="container card-underbody">
                  <div class="row-fluid">
                    <b-col align-self="end"
                      ><b-link
                        :href="project.gitUrl"
                        class="card-link"
                        target="_blank"
                        @click.stop
                      >
                        Github
                      </b-link>
                    </b-col>
                  </div>
                </div>
              </b-col>
            </b-row>
          </b-card>
        </router-link>
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
