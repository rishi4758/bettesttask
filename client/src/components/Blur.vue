<template>
  <div class="modal"><slot></slot></div>
</template>
<script>
export default {
  name: "Blur"
};
</script>
<style scoped>
.modal {
  position:fixed;
  z-index:1;
  top: 0;
  left: 0;
  display: flex;
  box-sizing: border-box;
  height: 100%;
  width: 100%;
  background-color: black;
  opacity: 0.7;
}
</style>