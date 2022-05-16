<template>
  <div>
    <h3>게시판</h3>
    <div class="searchBar">
      <select v-model="mode">
        <option value="1">제목</option>
        <option value="2">내용</option>
        <option value="3">제목+내용</option>
      </select>
      <input type="text" v-model="key" />
      <button @click="search">검색</button>
    </div>

    <b-table
      class="w-100 mx-auto va-middle"
      id="board-table"
      :hover="true"
      :cursor="pointer"
      :current-page="page"
      :total-rows="rows"
      :per-page="perPage"
      :items="boards"
      :fields="columns"
      :busy="isBusy"
      :outlined="false"
      :dark="false"
      :fixed="false"
      @row-clicked="goDetail"
    ></b-table>
    <b-pagination
      id="pagination-bar"
      align="center"
      v-model="page"
      :total-rows="rows"
      :per-page="perPage"
      first-number
      last-number
      aria-controls="board-table"
      type="dark"
      variant="secondary"
    ></b-pagination>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "BoardList",
  data() {
    return {
      columns: [
        { key: "no", label: "글 번호", thClass: "w10" },
        { key: "title", label: "제목", thClass: "w50" },
        { key: "writer", label: "작성자", thClass: "w10" },
        { key: "viewCnt", label: "조회수", thClass: "w10" },
        { key: "regDate", label: "등록일자", thClass: "w20" },
      ],
      key: "",
      mode: 1,
      perPage: 10,
    };
  },
  computed: {
    ...mapState(["boards"]),
    rows() {
      return this.boards.length;
    },
    page: {
      get() {
        return this.$store.state.page;
      },
      set(value) {
        this.$store.state.page = value;
      },
    },
  },
  created() {
    const payload = {
      mode: this.mode,
      key: this.key,
    };
    this.$store.dispatch("getBoards", payload);
  },
  methods: {
    search() {
      const payload = {
        mode: this.mode,
        key: this.key,
      };
      this.$store.dispatch("getBoards", payload);
    },
    goDetail(item) {
      this.$router.push(`board/${item.no}`);
    },
  },
};
</script>

<style>
.board-link {
  text-decoration: none;
  color: black;
  cursor: pointer;
}

.table td,
.table th {
  text-align: center;
  vertical-align: middle;
  cursor: pointer;
}

.searchBar {
  display: flex;
  justify-content: end;
}
#pagination-bar > li > * {
  color: black;
}
#pagination-bar > li.active > button,
#pagination-bar ul > li > button:hover {
  color: white;
  background-color: #333 !important;
}
table.b-table thead th.w10 {
  width: 10%;
}
table.b-table thead th.w20 {
  width: 20%;
}
table.b-table thead th.w50 {
  width: 50%;
}
</style>



    <table class="table" id="boardTable">
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
      <tbody v-if="boards.length">
        <tr v-for="board in boards" :key="board.no">
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
      <tbody v-else>
        <tr>
          <td colspan="5">
            <h5>검색된 게시글이 없습니다.</h5>
          </td>
        </tr>
      </tbody>
    </table>