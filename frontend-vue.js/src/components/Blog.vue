<template>
  <div class="container posts">
    <h3>All Posts</h3>
    <div class="container">
      <b-card-group deck v-for="i in Math.ceil(posts.length / 2)" :key="i">
        <b-card
          class="bCard m-3"
          v-for="post in posts.slice((i - 1) * 2, (i - 1) * 2 + 2)"
          v-bind:key="post.id"
          :title="post.title"
          :sub-title="post.project"
        >
          <b-card-text>
            {{ post.description }}
          </b-card-text>
          <!-- <a :href="'/post/' + post.id" class="card-link">Details</a> -->
          <!-- <b-link href="#" class="card-link">Github</b-link> -->
        </b-card>
      </b-card-group>
    </div>
  </div>
</template>
<script>
import PostDataService from "../service/PostDataService";

export default {
  name: "Posts",
  data() {
    return {
      posts: [],
      message: "",
    };
  },
  methods: {
    refreshPosts() {
      PostDataService.retrieveAllPosts().then((res) => {
        this.posts = res.data;
      });
    },
  },
  created() {
    this.refreshPosts();
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
