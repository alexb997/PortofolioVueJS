<template>
  <b-col>
    <b-row class=" flex-xl-nowrap">
      <b-col class="col-md-3 col-xl-2 col-12 left-side">
        <NavBar />
      </b-col>
      <b-col
        class="bd-content col-md-9 col-xl-8 col-12 pb-md-3 pl-md-5 right-side"
      >
        <b-container>
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
