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
      path: "/projects",
      name: "Projects",
      component: () => import("./components/Projects"),
    },
    {
      path: "/blog",
      name: "Blog",
      component: () => import("./components/Blog"),
    },
    {
      path: "/project/:id",
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
      path: "/admin/project/:id",
      name: "Project",
      component: () => import("./components/Project"),
    },
    {
      path: "/admin/post/:id",
      name: "Post",
      component: () => import("./components/Post"),
    },

    {
      path: "/project/:id/addPost",
      name: "Post",
      component: () => import("./components/ProjectPost"),
    },
    {
      path: "/:pathMatch(.*)*",
      name: "404",
      component: () => import("./components/404"),
    },
  ],
});

export default router;
