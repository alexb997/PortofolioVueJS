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
      name: "ProjectDetails",
      component: () => import("./components/ProjectDetails"),
    },
    {
      path: "/admin",
      name: "Admin",
      component: () => import("./components/Admin"),
    },
    {
      path: "/admin/projects",
      name: "AdminProjects",
      component: () => import("./components/AdminProjects"),
    },
    {
      path: "/admin/posts",
      name: "AdminPosts",
      component: () => import("./components/AdminPosts"),
    },
    {
      path: "/admin/Project/:id",
      name: "Project",
      component: () => import("./components/Project"),
    },
    {
      path: "admin/Post/:id",
      name: "Post",
      component: () => import("./components/Post"),
    },
    {
      path: '/:pathMatch(.*)*',
      name: "404",
      component: () => import("./components/404"),
    },
  ],
});

export default router;
