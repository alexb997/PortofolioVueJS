<template>
  <b-col class="app">
    <b-row class="flex-xl-nowrap">
      <b-col class="col-md-4 col-xl-2 col-12 left-side ">
        <NavBar />
      </b-col>
      <b-col class="right-side">
        <b-container fluid>
          <router-view />
        </b-container>
      </b-col>
    </b-row>
  </b-col>
</template>

<script>
import NavBar from "./components/NavBar.vue";

export default {
  components: {
    NavBar,
  },
  name: "app",
};
</script>

<style>
@import url(https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css);
@import url(./style/Global.css);
</style>
