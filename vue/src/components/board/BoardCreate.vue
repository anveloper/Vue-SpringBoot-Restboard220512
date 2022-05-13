<template>
  <div>    
    <fieldset>
      <legend>게시글 작성</legend>
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" /><br />
      <label for="writer">작성자</label>
      <input type="text" id="witer" v-model="writer" /><br />

      <label for="content">글 내용</label>
      <textarea
        class="form-control"
        v-model="content"
        id="content"
        rows="4"
      ></textarea>

      <router-link class="btn" to="/board">목록</router-link>
      <button class="btn" @click="createBoard">등록</button>
    </fieldset>
  </div>
</template>

<script>
export default {
  name: "BoardCreate",
  data() {
    return {
      title: "",
      writer: "",
      content: "",
    };
  },
  methods: {
    createBoard() {
      let newBoard = {
        id: 0,
        title: this.title,
        writer: this.writer,
        content: this.content,
      };

      this.$store.dispatch("createBoard", newBoard);
    },
  },
};
</script>

<style>
</style>
