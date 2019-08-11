<template>
  <div class="app-container">
    <el-dropdown @command="handleCommand">
      <span class="el-dropdown-link">
        查询类别<i class="el-icon-arrow-down el-icon--right" />
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="检查目的">检查目的</el-dropdown-item>
        <el-dropdown-item command="高血压病">高血压病</el-dropdown-item>
        <el-dropdown-item command="血脂异常">血脂异常</el-dropdown-item>
        <el-dropdown-item command="糖尿病史">糖尿病史</el-dropdown-item>
        <el-dropdown-item command="脑卒中病史">脑卒中病史</el-dropdown-item>
        <el-dropdown-item command="外周血管病">外周血管病</el-dropdown-item>
        <el-dropdown-item command="吸烟史">吸烟史</el-dropdown-item>
        <el-dropdown-item command="饮酒史">饮酒史</el-dropdown-item>
        <el-dropdown-item command="体育锻炼史">体育锻炼史</el-dropdown-item>
        <el-dropdown-item command="心肌梗死">心肌梗死</el-dropdown-item>
        <el-dropdown-item command="其他疾病史">其他疾病史</el-dropdown-item>
        <el-dropdown-item command="家族史">家族史</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>

  </div>
</template>

<script>
export default {
  name: 'Analyze',
  data() {
    return {
      searchClass: null
    }
  },
  created() {

  },
  methods: {
    handleCommand(command) {
      // this.$message('click on item ' + command)
      this.searchClass = command
    }
  }
}
</script>
