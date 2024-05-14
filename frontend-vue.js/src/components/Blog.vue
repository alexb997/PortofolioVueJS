<template>
  <div class="container posts">
    <h3>All Posts</h3>
    <div class="row">
      <div class="col-md-4" v-for="post in currentPagePosts" :key="post.id">
        <div class="card mb-3">
          <div class="card-body">
            <h5 class="card-title">{{ post.title }}</h5>
            <h6 class="card-subtitle mb-2 text-muted">{{ post.type }}</h6>
            <p class="card-text">{{ post.description }}</p>
            <a :href="post.reference" class="card-link">Reference</a>
          </div>
        </div>
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
