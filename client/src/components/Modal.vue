<template>
  <div class="modal">
    <div v-on:click="set_modal">
      <Blur></Blur>
    </div>

    <div class="taskContainer"><slot></slot></div>
  </div>
</template>
<script>
import Blur from "./Blur";
export default {
  name: "Modal",
  props: ["set_modal", "nameheight"],
  components: {
    Blur
  }
};
</script>
<style scoped>
.taskContainer {
  top: 15%;

  /* width: 480px;
  height: 520px; */
  position: absolute;
  z-index: 200;
  background-color: rgba(255, 255, 255, 1);
  opacity: 100%;
  padding: 10px;
}
nameContainer {
  height: 50px;
}

@media screen and (max-width: 630px) {
  .taskContainer {
    width: auto;
    max-width: 400px;
  }
}
@media screen and (max-width: 500px) {
  .taskContainer {
    width: auto;
    max-width: 350px;

    justify-content: space-around;
    align-items: space-around;
  }
}
@media screen and (max-width: 500px) {
  .taskContainer {
    width: auto;
    max-width: 340px;

    justify-content: space-around;
    align-items: space-around;
  }
}
</style>