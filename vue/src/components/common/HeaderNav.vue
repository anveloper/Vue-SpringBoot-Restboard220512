<template>
  <div>
    <b-navbar
      toggleable="lg"
      type="dark"
      variant="secondary"
      id="nav-container"
      sticky      
    >
      <b-navbar-brand class="m-2" to="/">HOME</b-navbar-brand>
      <b-navbar-toggle class="m-2" target="nav-collapse"></b-navbar-toggle>

      <b-collapse class="m-2" id="nav-collapse" is-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item to="/board">Board</b-nav-item>
          <b-nav-item to="/">USER</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>