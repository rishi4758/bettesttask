<template>
  <Modal :set_modal="set_modal">
    <div class="container" style="height:520px; width:480px">
      <Header :set_modal="set_modal" title="New Task"></Header>

      <form class="form" v-on:submit="this.submitForm">
        <div class="form-group">
          <div>Title:</div>
          <input type="text" class="input" v-model="title" required />
        </div>
        <div class="form-group">
          <div>Description:</div>
          <textarea
            type="text"
            v-model="description"
            class="input"
            style="height:80px"
            required
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
            maxlength="2"
            placeholder="DD"
            v-model="day"
            required
          />
          <input
            type="number"
            class="date-input"
            style="width:60px; height:30px;"
            placeholder="MM"
            v-model="month"
            min="1"
            max="12"
            maxlength="2"
            required
          />
          <input
            type="number"
            maxlength="4"
            class="date-input"
            style="width:100px; height:30px;"
            v-model="year"
            max="9999"
            placeholder="YYYY"
            required
          />
        </div>

        <div class="form-group">
          <label for="cars">Priority:</label>
          <div>
            <select
              name="cars"
              v-model="priority"
              class="input"
              style="width:285px;"
              required
            >
              <option disabled selected value>
                -- select an option --
              </option>
              <option value="High">High</option>
              <option value="Medium">Medium</option>
              <option value="Low">Low</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <div>Comments:</div>
          <input
            v-model="comments.description"
            type="text"
            class="input"
            style="height:100px;"
            required
          />
        </div>
        <div class="form-group btn-form">
          <button type="submit" class="addBtn">
            <span>Add a new task</span>
          </button>
        </div>
      </form>
      <div></div>
    </div>
  </Modal>
</template>
<script>
// import Blur from "./blur";
import Modal from "./Modal";
import store from "../store";
import Header from "./Header";
import { INSERT_LIST } from "../store/actions.type";
export default {
  name: "AddTask",
  components: {
    Modal,
    Header
  },
  props: ["set_modal", "commentView"],
  data() {
    return {
      id: Math.random(),
      title: "",
      description: "",
      day: "",
      month: "",
      year: "",
      priority: "",
      isName: false,
      comments: { name: "", time: null, description: null }
    };
  },
  methods: {
    submitForm: function() {
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

      store.dispatch(INSERT_LIST, {
        id: Math.random(),
        title: this.title,
        description: this.description,
        day: this.day.toString(),
        month: this.month.toString(),
        year: this.year.toString(),
        priority: this.priority,
        comments: {
          name: sessionStorage.getItem("name"),
          time: exactTime,
          commentData: this.comments.description
        }
      });

      this.set_modal();
    }
  }
};
</script>
<style scoped>
container {
  position: absolute;
}
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
  text-align: start;
  font-family: "Proxima Nova";
  font-weight: 200;
  font-style: normal;
  font-size: 15px;
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
.btn-form {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  margin-right: 30px;
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