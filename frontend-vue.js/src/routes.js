import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import("./components/Home"),
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
    {
      path: "/admin",
      name: "Admin",
      component: () => import("./components/Admin"),
    },
  ],
});

export default router;
