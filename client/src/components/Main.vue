<template>
  <div class="parentList">
    <div class="listContainer">
      <div class="header">
        <div class="title">PawaTask</div>
        <div class="addBtn" v-on:click="taskScreen">
          <span>Add a new task</span>
        </div>
      </div>
      <div class="line1">
        <img class="myImage" src="../../public/assets/line.png" />
      </div>

      <div>
        <TaskList :commentView="commentScreen" :editView="editScreen" />
      </div>
      <div v-if="isName === true">
        <AddName :set_modal="nameScreen" />
      </div>
      <div v-if="isModal && isTask">
        <AddTask :set_modal="taskScreen" />
      </div>
      <div v-if="isModal && isComment">
        <Comment :set_modal="commentScreen" :c_id="commentId" />
      </div>
      <div v-if="isModal && isEdit">
        <EditItem :set_modal="editScreen" :e_id="editId" />
      </div>

      <div class="emptyList" v-if="!this.myList[0]">
        <span> You do not have any task </span>

        <span class="underLineText" v-on:click="taskScreen">
          add a new task</span
        >
      </div>
    </div>
  </div>
</template>

    <script>
import AddTask from "./AddTask";
import TaskList from "./TaskList";
import Comment from "./AddComment";
import EditItem from "./EditItem";
import store from "../store";
import AddName from "./AddName";
import { mount } from "@vue/test-utils";

export default {
  name: "Main",
  components: { AddTask, TaskList, Comment, EditItem, AddName },

  data() {
    return {
      sessionVal: null,
      myName: "",
      isName: true,
      isModal: false,
      isTask: false,
      isComment: false,
      isEdit: false,
      commentId: null,
      editId: null
    };
  },

  methods: {
    taskScreen() {
      this.isTask = !this.isTask;
      this.isModal = !this.isModal;
    },
    nameScreen() {
      this.isName = false;
    },
    commentScreen(cId) {
      this.commentId = cId;
      this.isModal = !this.isModal;
      this.isComment = !this.isComment;
    },
    editScreen(eId) {
      this.editId = eId;
      this.isModal = !this.isModal;
      this.isEdit = !this.isEdit;
    }
  },
  computed: {
    myList() {
      return store.getters.list;
    }
  }
};
</script>

    <style scoped>
.parentList {
  flex-grow: 1;
  justify-self: center;
  justify-content: center;
  align-items: center;
  align-self: center;
}
.myImage {
  width: 0px;
}
.listContainer {
  margin-top: 25px;
  border-width: 0px;
  display: inline-block;
  width: 900px;
  max-width: 600px;
  height: auto;
  min-height: 800px;
  max-height: auto;
  background: inherit;
  background-color: rgba(255, 255, 255, 1);
  box-sizing: border-box;
  border-width: 1px;
  border-style: solid;
  border-color: rgba(214, 214, 214, 1);
  border-radius: 0px;
  -moz-box-shadow: none;
  -webkit-box-shadow: none;
  box-shadow: none;
  padding: 10px;
  position: relative;
  z-index: 0;
  flex: 1;
  justify-content: center;
  align-items: center;
}

.header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 30px;
  width: auto;
  max-width: 600px;
  margin-bottom: 20px;
}

.title {
  border-width: 0px;
  left: 20px;
  top: 25px;
  width: 107px;
  height: 29px;
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  font-size: 24px;
  border-width: 0px;
  left: 0px;
  top: 0px;
  width: 109px;
  white-space: nowrap;
}

.addBtn {
  display: flex;
  justify-content: center;
  align-items: center;
  border-width: 0px;
  cursor: pointer;
  left: 0px;
  top: 0px;
  width: 120px;
  height: 30px;
  background: inherit;
  background-image: inherit;

  background-size: inherit;
  background-repeat-x: inherit;
  background-repeat-y: inherit;
  background-attachment: inherit;
  background-origin: inherit;
  background-clip: inherit;
  background-color: rgba(237, 77, 36, 1);
  background-color: rgba(237, 77, 36, 1);
  box-sizing: border-box;
  border-width: 1px;
  border-style: solid;
  border-color: rgba(237, 77, 36, 1);
  border-radius: 0px;
  -moz-box-shadow: none;
  -webkit-box-shadow: none;
  box-shadow: none;
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  color: #ffffff;
}

.line1 {
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

.emptyList {
  width: auto;
  display: flex;

  justify-content: flex-start;
  font-size: 13px;
  margin-left: 8px;
}
.underLineText {
  color: rgba(237, 77, 36, 1);
  text-decoration: underline;
  margin-left: 3px;
  cursor: pointer;
}

@media screen and (max-width: 991.98px) {
  .myImage {
    width: auto;
    max-width: 0px;
  }
  .listContainer {
    left: 0px;
    flex: 1;
    justify-content: center;
    height: 100%;
    width: 900px;
  }
}

@media screen and (max-width: 767.98px) {
  .myImage {
    width: 0px;
  }
  .listContainer {
    max-width: 500px;
  }
}
@media screen and (max-width: 500px) {
  .myImage {
    width: 0;
  }
  .listContainer {
    width: auto;
    width: 100%;
  }
}
</style>
