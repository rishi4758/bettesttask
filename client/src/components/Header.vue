<template>
  <div class="upar">
    <div class="title">{{ title }}</div>

    <div class="closebtn" style="cursor: pointer;" v-on:click="set_modal">
      <img class="img " src="../../public/assets/cross.png" />
    </div>
  </div>
</template>
<script>
export default {
  name: "Header",
  props: ["set_modal", "title"]
};
</script>
<style scoped>
.upar {
  position: relative;
  z-index: 200;
  display: flex;
  justify-content: space-between;
  margin-top: 2px;
}
.title {
  margin-top: 2px;
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  font-size: 24px;
  margin-bottom: 10px;
}
.img {
  width: 20px;
  height: 20px;
}

@media screen and (max-width: 630px) {
  .img {
    width: 20px;
    margin-right: 100px;
  }
}

@media screen and (max-width: 500px) {
  .img {
    width: 20px;
    margin-right: 140px;
  }
}
</style>

