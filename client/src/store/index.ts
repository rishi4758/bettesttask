import Vue from "vue";
import Vuex from "vuex";
import List from "./list";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: { List },
});
