import axios from 'axios'

const ROOT_URL = "http://localhost:8888/api/";

export default {
  getBoardList() {
    return axios.get(ROOT_URL + `board`);
  },
  getBoard(no) {
    return axios.get(ROOT_URL + `board/${no}`);
  },
  writeBoard(title, writer, content) {
    return axios.post(ROOT_URL + `insert/`,
      {
        title: title,
        writer: writer,
        content: content,
      }
    );
  }
}