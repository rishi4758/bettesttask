<template>
  <div>
    <div v-for="item in list" v-bind:key="item.id">
      <div class="listCont">
        <div class="title">
          <div class=" box"></div>

          <div>
            {{ item.title }}
          </div>
        </div>
        <div class="edit" style="width:auto;max-width:500px;">
          <div>
            <img class="calender " src="../../public/assets/calender.png" />
            <span>{{ item.day }}/</span>
            <span>{{ item.month }}/</span>
            <span>{{ item.year }}</span>
          </div>

          <div v-on:click="commentView(item.id)">
            <img class="comment" src="../../public/assets/comment.png" />
          </div>
          <div v-on:click="editView(item.id)">
            <img class="edit-btn" src="../../public/assets/edit.png" />
          </div>
        </div>
      </div>
      <div class="imgLine" style="color:red">
        <img class="Img" src="../../public/assets/line.png" />
      </div>
    </div>
  </div>
</template>
<script>
import store from "../store";
// import AddComment from "./AddComment";
export default {
  name: "TaskList",
  props: ["commentView", "editView"],
  // components: { AddComment },
  data() {
    return { list: store.getters.list };
  },
  methods: {},
  computed: {}
};
</script>
<style>
.box {
  float: left;
  height: 13px;
  width: 13px;
  margin-left: 5px;
  margin-bottom: 15px;
  border: 1px solid black;
  clear: both;
}
.listCont {
  height: 20px;
  width: auto;
  max-width: 600px;
  display: grid;
  grid-template-columns: 60% 40%;
}
.Img {
  max-width: 0px;
}
.edit {
  display: grid;
  grid-template-columns: 60% 20% 20%;
}
.calender {
  width: 20px;
  height: 20px;
}
.comment {
  border-width: 0px;
  background-color: rgba(237, 77, 36, 1);
  position: relative;
  width: 25px;
  height: 25px;
  cursor: pointer;
}
.edit-btn {
  border-width: 0px;
  background-color: rgba(237, 77, 36, 1);
  position: relative;
  width: 25px;
  height: 25px;
  cursor: pointer;
}
.imgLine {
  border-width: 0px;
  margin-bottom: 15px;
  left: 10px;
  width: auto;
  max-width: 600px;
  height: 1px;
  font-family: "ArialMT", "Arial";
  font-weight: 400;
  font-style: normal;
  font-size: 13px;
  margin-top: 26px;
  background-color: #3333;
  line-height: normal;
}
@media screen and (max-width: 630px) {
  .edit {
    display: grid;
    grid-template-columns: 60% 20% 20%;
  }
}
</style>
