import { INSERT_LIST } from "./actions.type";
import { EDIT_LIST } from "./actions.type";
import { INSERT_COMMENT } from "./actions.type";
import { FETCH_LIST } from "./actions.type";
import axios from "axios";
import { ADD_LIST } from "./mutations.type";
import { EDIT_LIST_ITEM } from "./mutations.type";
import { ADD_COMMENT } from "./mutations.type";
import { GET_LIST } from "./mutations.type";
import { fetchList, insertList, editList, addComment } from "../api";
const state = {
  List: [],
  comments: [],
};
const actions = {
  // [FETCH_LIST]: async (context) => {
  //   const res = fetchList();
  //
  //   context.commit(GET_LIST, res.data);
  // },
  [INSERT_LIST]: async (context, data) => {
    const obj = {
      id: data.id,
      title: data.title,
      description: data.description,
      day: data.day,
      month: data.month,
      year: data.year,
      priority: data.priority,
      commentData: {
        listId: data.id,
        name: data.comments.name,
        time: data.comments.time,
        commentData: data.comments.commentData,
      },
    };

    // const res = await insertList(obj);

    context.commit(ADD_LIST, obj);
  },
  [EDIT_LIST]: async (context, data) => {
    const obj1 = {
      id: data.id,
      title: data.title,
      description: data.description,
      day: data.day,
      month: data.month,
      year: data.year,
      priority: data.priority,
    };

    // const res = await editList(data);

    context.commit(EDIT_LIST_ITEM, data);
  },
  [INSERT_COMMENT]: async (context, data) => {
    const obj2 = {
      listId: data.id,
      name: data.name,
      time: data.time,
      commentData: data.commentData,
    };

    // const res = await addComment(data);

    context.commit(ADD_COMMENT, data);
  },
};
const mutations = {
  // [GET_LIST]: (res) => {
  //   state.List = res.data;
  // },

  [ADD_LIST]: (state, data) => {
    state.List.push({
      id: data.id,
      title: data.title,
      description: data.description,
      day: data.day,
      month: data.month,
      year: data.year,
      priority: data.priority,
    });

    state.comments.push(data.commentData);
  },

  [EDIT_LIST_ITEM]: (state, data) => {
    const index = state.List.findIndex((obj) => obj.id === data.id);

    const obj = {
      id: data.id,
      title: data.title,
      description: data.description,
      date: data.date,
      priority: data.priority,
    };

    console.log(state.list[index] + "index has changed");
    state.List[index] = obj;
  },
  [ADD_COMMENT]: (state, data) => {
    state.comments.push({
      listId: data.id,
      name: data.name,
      time: data.time,
      commentData: data.commentData,
    });
  },
};
const getters = {
  list() {
    return state.List;
  },

  getItem() {
    return (id) => {
      return state.List.find((obj) => obj.id === id);
    };
  },

  getComments() {
    return (id) => {
      return state.comments.filter((obj) => obj.listId === id);
    };
  },
};

export default {
  state,
  actions,
  mutations,
  getters,
};
