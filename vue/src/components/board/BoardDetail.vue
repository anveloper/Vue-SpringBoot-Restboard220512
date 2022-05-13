<template>
  <div>
    <h3>게시글 상세보기</h3>
    <fieldset>
      <label for="no">글 번호</label>
      <input readonly type="text" id="no" v-model="board.no" /><br />
      <label for="title">제목</label>
      <input type="text" id="title" v-model="board.title" /><br />
      <label for="writer">작성자</label>
      <input type="text" id="witer" v-model="board.writer" /><br />
      <label for="regDate">등록일자</label>
      <input type="text" id="regDate" v-model="board.regDate" /><br />
      <label for="modiDate">수정일자</label>
      <input type="text" id="modiDate" v-model="board.modiDate" /><br />

      <label for="content">글 내용</label>
      <textarea
        class="form-control"
        v-model="board.content"
        id="content"
        rows="4"
      ></textarea>

      <router-link class="btn" to="/board">목록</router-link>
      <router-link class="btn" :to="`/board/${board.no}`" method="PUT">수정</router-link>
      <router-link class="btn" :to="`/board/${board.no}`" method="DELETE">삭제</router-link>
    </fieldset>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "BoardDetail",

  data() {
    return {};
  },
  computed: {
    ...mapState(["board"]),
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    this.$store.dispatch("getBoard", id);
  },
};
</script>

<style>
</style>