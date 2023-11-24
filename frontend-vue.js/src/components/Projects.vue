<template>
  <div class="container">
    <h3>All Projects</h3>
    <div v-if="message" class="alert alert-success">{{ this.message }}</div>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Email Id</th>
            <th>Status</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="project in projects" v-bind:key="project.id">
            <td>{{ project.name }}</td>
            <td>{{ project.description }}</td>
            <td>{{ project.imgUrl }}</td>
            <td>{{ project.status }}</td>
            <td>
              <button
                class="btn btn-warning"
                v-on:click="updateProject(project.id)"
              >
                Update
              </button>
            </td>
            <td>
              <button
                class="btn btn-danger"
                v-on:click="deleteProject(project.id)"
              >
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn btn-success" v-on:click="addProject()">Add</button>
      </div>
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
    addProject() {
      this.$router.push(`/project/-1`);
    },
    updateProject(id) {
      this.$router.push(`/project/${id}`);
    },
    deleteProject(id) {
      ProjectDataService.deleteProject(id).then(() => {
        this.refreshProjects();
      });
    },
  },
  created() {
    this.refreshProjects();
  },
};
</script>
