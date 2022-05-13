import axios from 'axios'

const ROOT_URL = "http://localhost:8888/api/";

export default {
  getBoardList(params) {
    return axios.get(ROOT_URL + `board`, { params });
  },
  getBoard(no) {
    return axios.get(ROOT_URL + `board/${no}`);
  },
  createBoard(board) {
    return axios.post(ROOT_URL + `board/`, board );
  }
}