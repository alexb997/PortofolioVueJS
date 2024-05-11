<template>
  <div class="container posts">
    <h3>All Posts</h3>
    <div class="container">
      <b-card-group deck v-for="page in Math.ceil(totalPages)">
        <b-card
          class="bCard m-3"
          tag="post"
          v-for="post in currentPagePosts"
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
      <b-pagination
        v-model="currentPage"
        :total-rows="totalRows"
        :per-page="pageSize"
        @input="pageChanged"
      />
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
      currentPagePosts: [],
      currentPage: 1,
      pageSize: 7,
      totalRows: 0,
      totalPages: 0,
      message: "",
    };
  },
  methods: {
    refreshPosts() {
      PostDataService.retrieveAllPosts({
        page: this.currentPage,
        size: this.pageSize,
      })
        .then((response) => {
          const responseData = response.data;
          this.currentPagePosts = responseData.content;
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
