<template>
  <div style=" text-align: start;">
    <Modal :set_modal="set_modal">
      <div style=" height:auto;padding:10px; min-height:520px; width:480px">
        <Header :set_modal="set_modal" title="<Title Task>" />

        <div class="description">{{ this.list.description }}</div>
        <div class="DandP">
          <div>
            <span style="font-family:'Proxima Nova';font-weight:700;"
              >Date: </span
            ><span>{{
              this.list.day + "/" + this.list.month + "/" + this.list.year
            }}</span>
          </div>
          <div>
            <span style="font-family:'Proxima Nova';font-weight:700;"
              >Priority: </span
            ><span>{{ this.list.priority }}</span>
          </div>
        </div>
        <div class="line1">
          <img class="img1 " src="../../public/assets/line.png" />
        </div>

        <div
          v-for="cm in this.commentObj"
          v-bind:key="cm.id"
          class="givenComments"
        >
          <span style="font-weight:900;"> {{ cm.name }}</span>
          <span style="color:lightgrey;">{{ " " + cm["time"] }}</span>

          <div>{{ cm.commentData }}</div>
        </div>
        <form class="footer" v-on:submit="addComment(list.id, value)">
          <div>
            <input type="text" v-model="value" class="addComment" required />
          </div>
          <div
            style="display:flex; flex-direction:row; justifyContent:flex-end;"
          >
            <button type="submit" class="addBtn">
              <span>Add Comment</span>
            </button>
          </div>
        </form>
      </div>
    </Modal>
  </div>
</template>
<script>
import { INSERT_COMMENT } from "../store/actions.type";
import Modal from "./Modal";

import Header from "./Header";
import store from "../store";
export default {
  name: "Comment",
  props: ["c_id", "set_modal"],
  components: {
    Modal: Modal,
    Header
  },
  data() {
    return { value: null };
  },
  methods: {
    addComment(id, value) {
      const date = new Date();
      const daylist = [
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday ",
        "Thursday",
        "Friday",
        "Saturday"
      ];
      const time =
        daylist[date.getUTCDay()] +
        " at " +
        date.getHours() +
        ":" +
        date.getMinutes();
      const ampm = date.getHours() >= 12 ? "pm" : "am";
      const exactTime = time + ampm;

      store.dispatch(INSERT_COMMENT, {
        id: this.list.id,
        name: sessionStorage.getItem("name"),
        time: exactTime,
        commentData: value
      });
      this.set_modal();
    }
  },
  computed: {
    list() {
      return store.getters.getItem(this.c_id);
    },
    commentObj() {
      return store.getters.getComments(this.c_id);
    }
  }
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
.description {
  word-wrap: break-word;
  position: relative;
  padding: 10px;
  height: 30%;
  width: auto;
}

.DandP {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  padding: 10px;
}
.img1 {
  width: 100%;
  height: 2px;
  font-family: "ArialMT", "Arial";
  font-weight: 400;
  font-style: normal;
  font-size: 13px;
  color: #333333;
  line-height: normal;
}
.givenComments {
  margin-top: 15px;
}
.footer {
  display: flex;
  justify-content: space-around;
  align-items: center;
  position: absolute;
  left: 0px;
  bottom: 0px;
  width: 100%;
  height: 70px;
  background: inherit;
  background-color: rgba(240, 240, 240, 1);
  box-sizing: border-box;
  border-width: 1px;
  border-style: solid;
  border-color: rgba(214, 214, 214, 1);
  border-radius: 0px;
  -moz-box-shadow: none;
  -webkit-box-shadow: none;
  box-shadow: none;
}
.addComment {
  position: relative;
  left: 0px;

  width: 310px;
  height: 30px;
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
}
.addBtn {
  width: 120px;
  height: 30px;
  background: inherit;
  background-image: inherit;
  background-position-x: inherit;
  background-position-y: inherit;
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
  margin-bottom: 25px;
  margin-top: 25px;
  left: 10px;

  width: 470px;
  height: 1px;
  font-family: "ArialMT", "Arial";
  font-weight: 400;
  font-style: normal;
  font-size: 13px;

  background-color: #3333;
  line-height: normal;
}

@media screen and (max-width: 767.98px) {
  .DandP {
    width: auto;
    max-width: 380px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin-right: 50px;
  }
  .description {
    width: auto;
    max-width: 400px;
  }

  .img1 {
    width: auto;
    max-width: 579px;
  }
  .addComment {
    max-width: 250px;
  }
  .givenComments {
    padding: 25px;
  }
}
@media screen and (max-width: 500px) {
  .DandP {
    margin: 0;
    padding: 0;
    width: auto;
    max-width: 340px;
    justify-content: space-around;
    align-items: space-around;
  }
  .description {
    width: auto;
    max-width: 340px;
  }
}
.addBtn {
  width: 100px;
}
</style>