import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "Projects",
      component: () => import("./components/Projects"),
    },
    {
      path: "/Projects",
      name: "Projects",
      component: () => import("./components/Projects"),
    },
    {
      path: "/Project/:id",
      name: "Project",
      component: () => import("./components/Project"),
    },
  ],
});

export default router;
