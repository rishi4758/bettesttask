<template>
  <div class="modal"></div>
</template>
<script>
export default {
  name: "Blur"
};
</script>
<style scoped>
.modal {
  top: 0;
  left: 0;
  display: flex;
  box-sizing: border-box;

  height: 100%;
  width: 100%;
  position: fixed;
  z-index: 100;
  background-color: black;
  opacity: 0.7;
}
</style>