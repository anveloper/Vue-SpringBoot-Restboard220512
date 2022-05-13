<template>
  <div>
    <h3>게시판</h3>
    <div v-if="boardList.length">
      <table class="table">
        <colgroup>
          <col style="width: 10%" />
          <col style="width: 50%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
          <col style="width: 20%" />
        </colgroup>
        <thead>
          <tr>
            <th>글 번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>등록일자</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(board, index) in boardList" :key="index">
            <td>{{ board.no }}</td>
            <td>
              <router-link class="board-link" :to="`board/${board.no}`">{{
                board.title
              }}</router-link>
            </td>
            <td>{{ board.writer }}</td>
            <td>{{ board.viewCnt }}</td>
            <td>{{ board.regDate }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import apiBoard from "@/api/board.js";

export default {
  name: "BoardList",
  data() {
    return {
      // columns: [ { key: "no", label: "글 번호", }, { key: "title", label: "제목", }, { key: "writer", label: "작성자", }, { key: "viewCnt", label: "조회수", }, { key: "regDate", label: "등록일자", }, ],
      boardList: [],
    };
  },
  mounted() {
    apiBoard
      .getBoardList()
      .then((res) => {
        this.boardList = res.data;
      })
      .catch((err) => console.log(err));
  },
};
</script>

<style>
.board-link{
  text-decoration: none;
  color:black;
  cursor: pointer;
}
.table {
  text-align: center;
}
</style>