<template>
  <div id="app">
    <header-nav></header-nav>
    <b-container class="mt-3">
      <router-view />
    </b-container>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";

export default {
  name: "App",
  components: {
    HeaderNav,
  },
  data() {
    return {
      loginUser: null,
    };
  },
};
</script>


<style>
#app {
  font-family: "SBAggroM", Helvetica, Arial, sans-serif;
}
</style>
