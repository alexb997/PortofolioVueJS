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
      <h3>Related Posts</h3>
      <div class="container" v-if="posts && posts.length">
        <b-card-group deck v-for="i in Math.ceil(posts.length / 2)" :key="i">
          <b-card
            v-for="post in posts.slice((i - 1) * 2, (i - 1) * 2 + 2)"
            v-bind:key="post.id"
            :title="post.title"
            :sub-title="post.type"
          >
            <b-card-text>
              {{ post.description }}
            </b-card-text>
          </b-card>
        </b-card-group>
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
      posts: [],
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
        this.posts = res.data.posts || [];
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
