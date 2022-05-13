import Vue from 'vue'
import Vuex from 'vuex'
import apiBoard from "@/api/board.js"
import router from '@/router'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    rootPath: "http://localhost:8888/api/",
    boards: [],
    board: {},
    page: 1
  },
  getters: {
  },
  mutations: {
    GET_BOARDS(state, payload) {
      state.boards = payload;
    },
    GET_BOARD(state, payload) {
      state.board = payload
    },
    CREATE_BOARD(state, payload) {
      state.boards.push(payload)
    }
  },
  actions: {
    getBoards({ commit }, payload) {

      apiBoard
        .getBoardList(payload)
        .then((res) => {
          commit('GET_BOARDS', res.data);
          // console.log(res.data);
        })
        .catch((err) => console.log(err));
    },
    getBoard({ commit },) {
      const pathName = new URL(document.location).pathname.split("/");
      const no = pathName[pathName.length - 1];
      apiBoard
        .getBoard(no)
        .then((res) => {
          commit('GET_BOARD', res.data);
          // console.log(res.data);
        })
        .catch((err) => console.log(err));
    },
    createBoard({ commit }, board) {
      apiBoard.createBoard(board).then(() => {
        commit('CREATE_BOARD', board)
        router.push("/board")
      }).catch((err) => {
        console.log(err)
      })
    }
  },
  modules: {
  }
})
