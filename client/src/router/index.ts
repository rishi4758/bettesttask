import Vue from "vue";
import VueRouter, { RouteConfig } from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },

  {
    path: "/comment",
    name: "Comment",
    component: () => import("../components/AddComment.vue"),
  },
];

const router = new VueRouter({
  routes,
});

export default router;
