import Vue from "vue";
import App from "./App.vue";
import router from "./routes";
import { BootstrapVue, BootstrapVueIcons } from "bootstrap-vue";
import { Container } from 'bootstrap-vue';

Vue.component('Container', Container);

Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);
Vue.config.productionTip = false;

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
