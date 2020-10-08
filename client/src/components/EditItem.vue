<template>
  <div>
    <Modal :set_modal="set_modal">
      <div style="height:520px; width:480px">
        <Header :set_modal="set_modal" title="<Title Task>" />
        <form class="form" style="flex:1;" v-on:submit="this.editTask">
          <div class="form-group">
            <div>Title:</div>

            <input type="text" class="input" v-model="editObject.title" />
          </div>
          <div class="form-group">
            <div>Description:</div>
            <textarea
              type="text"
              v-model="editObject.description"
              class="input"
              style="height:80px"
            />
          </div>
          <div class="form-group" style="width:305px ">
            <div>Set due date:</div>

            <input
              type="number"
              class="date-input"
              style="width:60px; height:30px; margin-left:0px;"
              min="1"
              max="31"
              placeholder="DD"
              v-model="editObject.day"
            />
            <input
              type="number"
              class="date-input"
              style="width:60px; height:30px;"
              placeholder="MM"
              v-model="editObject.month"
              min="1"
              max="12"
            />
            <input
              type="year"
              class="date-input"
              style="width:100px; height:30px
              ;"
              v-model="editObject.year"
              min="1000"
              max="9999"
              placeholder="YYYY"
            />
          </div>

          <div class="form-group">
            <label for="cars">Priority:</label>
            <div>
              <select
                name="cars"
                v-model="editObject.priority"
                value="editObject.priority"
                class="input"
                style="width:285px;"
              >
                <option value="volvo">High</option>
                <option value="saab">Low</option>
                <option value="mercedes">Medium</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <div>Comments:</div>
            <input disabled type="text" class="input" style="height:100px;" />
          </div>
          <div class="form-group  btn-form">
            <button type="submit" class="addBtn">
              <span>Edit Task</span>
            </button>
          </div>
        </form>
        <div></div>
      </div>
    </Modal>
  </div>
</template>
<script>
import Modal from "./Modal";
import Header from "./Header";
import { EDIT_LIST } from "../store/actions.type";
import store from "../store";
export default {
  name: "EditItem",
  props: ["e_id", "set_modal"],
  components: {
    Modal: Modal,
    Header: Header
  },
  methods: {
    editTask(e) {
      e.preventDefault();
      store.dispatch(EDIT_LIST, this.editObject);
      this.set_modal();
    }
  },
  computed: {
    editObject() {
      return store.getters.getItem(this.e_id);
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
.input {
  flex: 1;
  height: 30px;
  width: 440px;
  background-color: rgba(255, 255, 255, 1);
  outline-color: rgba(214, 214, 214, 1);
  outline-width: 1px;
  border: 2px solid rgba(214, 214, 214, 1);

  border-radius: 3px;
}
.date-input {
  background-color: rgba(255, 255, 255, 1);
  outline-color: rgba(214, 214, 214, 1);
  outline-width: 1px;
  border: 2px solid rgba(214, 214, 214, 1);
  margin-left: 20px;
  border-radius: 3px;
  text-align: center;
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
.form {
  height: 900px;
}
.form-group {
  border-width: 0px;
  position: relative;
  left: 20px;
  margin-top: 10px;

  font-family: "Proxima Nova";
  font-weight: 200;
  font-style: normal;
  font-size: 15px;
  text-align: start;
}

.addBtn {
  display: flex;
  justify-content: center;
  align-items: center;

  cursor: pointer;

  width: 120px;
  height: 30px;

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

@media screen and (max-width: 630px) {
  .input {
    width: 330px;
  }
  .btn-form {
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    margin-right: 130px;
  }
}

@media screen and (max-width: 575.98px) {
  .input {
    width: 310px;
  }
  .btn-form {
    position: inherit;

    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    margin-right: 180px;
  }
}
</style>