<template>
    <div class="container">
      <h3>All Posts</h3>
      <div class="container">
        <table class="table">
          <thead>
            <tr>
              <th>Title</th>
              <th>Type</th>
              <th>Description</th>
              <th>Reference</th>
              <th>Update</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="post in posts" v-bind:key="post.title">
              <td>{{ post.title }}</td>
              <td>{{ post.type }}</td>
              <td>{{ post.description }}</td>
              <td>{{ post.reference }}</td>
              <td>
                <button
                  class="btn btn-warning"
                  v-on:click="updatePost(post.id)"
                >
                  Update
                </button>
              </td>
              <td>
                <button
                  class="btn btn-danger"
                  v-on:click="deletePost(post.id)"
                >
                  Delete
                </button>
              </td>
            </tr>
          </tbody>
        </table>
        <div class="row">
          <button class="btn btn-success" v-on:click="addPost()">Add</button>
        </div>
      </div>
    </div>
  </template>
  <script>
  import PostDataService from "../service/PostDataService";
  
  export default {
    name: "Posts",
    data() {
      return {
        posts:[],
        message: "",
      };
    },
    methods: {
      refreshPosts() {
        PostDataService.retrieveAllPosts().then((res) => {
          this.posts = res.data;
        });
      },
      addPost() {
        this.$router.push(`/admin/post/-1`);
      },
      updatePost(id) {
        this.$router.push(`/admin/post/${id}`);
      },
      deletePost(id) {
        PostDataService.deletePost(id).then(() => {
          this.refreshPosts();
        });
      },
    },
    created() {
      this.refreshPosts();
    },
  };
  </script>

  <style>
  button{
    position: relative;
    z-index: 1;
  }
</style>
  