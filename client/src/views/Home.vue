<template>
  <div>
    <Main class="list"></Main>
  </div>
</template>

<script>
// @ is an alias to /src
import Main from "@/components/Main.vue";
import { fetchList } from "../api";
import axios from "axios";
import store from "../store";
import { FETCH_LIST } from "../store/actions.type";
export default {
  components: { Main },
  methods: {},
  mounted() {
    // store.dispatch(FETCH_LIST);
  }
};
</script>
<style>
.list {
  height: 100%;
  width: 100%;
  position: inherit;
}
</style>
