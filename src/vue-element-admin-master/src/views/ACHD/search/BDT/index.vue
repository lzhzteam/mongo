<template>
  <div class="app-container">
    <el-form ref="searchForm" :model="searchForm" label-width="80px">
      <el-form-item label="搜索条件">
        <el-input
          v-model="searchForm.searchCondition"
          placeholder="请输入"
        >

          <el-button slot="append" icon="el-icon-search" @click="submit" />
        </el-input>
      </el-form-item>
      <el-form-item label="搜索结果">
        <el-tree
          :data="searchResult"
        />
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
import { search } from '../../../../api/ACHD'
import { jsonToTree } from '../../../../utils/jsonToTree'

export default {
  data() {
    return {
      loading: false,
      searchForm: {
        searchCondition: ''
      },
      searchResult: []
    }
  },
  mounted() {

  },
  methods: {
    submit() {
      this.search_data()
    },
    search_data() {
      const that = this
      that.loading = true
      search(this.searchForm).then(response => {
        that.loading = false
        if (response.status === 0) {
          this.searchResult = jsonToTree(response.data).children
          that.$message.success('成功')
        } else if (response.status === -1) {
          that.$message.error('失败')
        } else {
          that.$message.error(response.data)
        }
      }).catch(error => {
        that.loading = false
        that.$message.error(error)
      })
    }
  }
}
</script>

