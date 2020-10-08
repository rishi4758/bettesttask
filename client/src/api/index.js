import axios from "axios";

const baseUrl = "http://localhost:5678";

//get
export const fetchList = async () => {
  const res = await axios.get(`/${baseUrl}/list`);

  return res.data;
};

//post
export const insertList = async (data) => {
  const res = await axios.post("http://localhost:5678/list", data);

  return res.data;
};
//patch
export const editList = async (data) => {
  const res = await axios.put(`${baseUrl}/list`, data);
  console.log(res + "this is res with put method");
  return res.data;
};
//post
export const addComment = async (data) => {
  const id = data.id;
  const res = await axios.post(`${baseUrl}/list/{id}/comment`, data);
  return res.data;
};
