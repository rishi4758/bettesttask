<template>
  <Modal style="margin-left:50px;" :set_modal="set_modal">
    <form
      style="padding:10px position:relative; "
      v-on:submit="setName"
      required
    >
      <div style="text-align:center">
        <h3>please enter your name</h3>
        <input type="text" class="input" v-model="myName" required />
        <div>
          <button type="submit" class="addBtn">Add Your Name</button>
        </div>
      </div>
    </form>
  </Modal>
</template>
<script>
import Modal from "./Modal";
export default {
  name: "AddName",
  props: ["set_modal"],
  components: {
    Modal: Modal
  },
  data() {
    return { myName: "" };
  },
  methods: {
    setName() {
      sessionStorage.setItem("name", this.myName);
      this.set_modal();
    }
  },
  mounted() {
    const a = sessionStorage.getItem("name");
    if (a) {
      this.set_modal();
    }
  },
  computed: {
    style() {
      return "height:" + "50px";
    }
  }
};
</script>
<style scoped>
.input {
  flex: 1;
  height: 30px;
  width: 380px;
  background-color: rgba(255, 255, 255, 1);
  outline-color: rgba(214, 214, 214, 1);
  outline-width: 1px;
  border: 2px solid rgba(214, 214, 214, 1);

  border-radius: 3px;
}

.addBtn {
  cursor: pointer;
  margin-top: 20px;
  margin-left: 200px;

  width: 120px;
  height: 30px;

  background-color: rgba(237, 77, 36, 1);
  box-sizing: border-box;
  border-width: 1px;
  border-style: solid;
  border-color: rgba(237, 77, 36, 1);
  border-radius: 8px;
  -moz-box-shadow: none;
  -webkit-box-shadow: none;
  box-shadow: none;
  font-family: "Proxima Nova";
  font-weight: 700;
  font-style: normal;
  color: #ffffff;
}
</style>