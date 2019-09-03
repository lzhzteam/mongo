<template>
  <div class="app-container">
    <el-form ref="analyze" :model="analyze" label-width="80px">
      <el-form-item label="查询类别">
        <el-select v-model="analyze.searchClass" placeholder="请选择查询类别">
          <el-option label="检查目的" value="检查目的" />
          <el-option label="高血压病" value="高血压病" />
          <el-option label="血脂异常" value="血脂异常" />
          <el-option label="糖尿病史" value="糖尿病史" />
          <el-option label="脑卒中病史" value="脑卒中病史" />
          <el-option label="外周血管病" value="外周血管病" />
          <el-option label="吸烟史" value="吸烟史" />
          <el-option label="饮酒史" value="饮酒史" />
          <el-option label="体育锻炼史" value="体育锻炼史" />
          <el-option label="心肌梗死" value="心肌梗死" />
          <el-option label="其他疾病史" value="其他疾病史" />
          <el-option label="家族史" value="家族史" />
        </el-select>
      </el-form-item>

      <el-form-item label="查询类别">
        {{ analyze.searchClass }}
      </el-form-item>

    </el-form>

  </div>
</template>

<script>
export default {
  name: 'Analyze',
  data() {
    return {
      analyze: {
        searchClass: ''
      }
    }
  },
  created() {

  },
  methods: {}
}
</script>
