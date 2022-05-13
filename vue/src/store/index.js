import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    rootPath: "http://localhost:8888/api/",
    boardList: [],
  },
  getters: {
  },
  mutations: {
    GET_BOARD_LIST(state) {
      console.log(state.boardList);
    }
  },
  actions: {
    getBoardList({ commit }) {
      commit('GET_BOARD_LIST');
    }
  },
  modules: {
  }
})
