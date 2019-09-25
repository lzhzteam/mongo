<template>
  <div class="app-container">
    <el-form ref="searchForm" label-width="80px">
      <el-form-item label="搜索条件">
        <el-input
          v-model="searchCondition"
          placeholder="请输入"
        >

          <el-button slot="append" icon="el-icon-search" @click="submit" />
        </el-input>
      </el-form-item>
      <el-row>
        <el-col :span="10">
          <el-tree
            ref="leftTree"
            :data="searchResult"
            highlight-current
            show-checkbox
            @check-change="handleCheckChange"
          />
        </el-col>
        <el-col :span="14">
          <el-timeline>
            <el-timeline-item
              v-for="(activity, index) in activities"
              :key="index"
              :icon="activity.icon"
              :type="activity.type"
              :color="activity.color"
              :size="activity.size"
              :timestamp="activity.timestamp"
              placement="top"
            >
              <el-card>
                <el-tree
                  :data="activity.content"
                />
              </el-card>
            </el-timeline-item>
          </el-timeline>
        </el-col>
      </el-row>
    </el-form>

  </div>
</template>

<script>
import { search } from '../../../api/ACHD'
import { jsonToTree, treeNodeToTimeline, dbJsonToFrontJson } from '../../../utils/jsonToEtc'

export default {
  data() {
    return {
      loading: false,
      searchCondition: '',
      searchResult: [],
      activities: []
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
      search(this.searchCondition).then(response => {
        if (response.status === 0) {
          this.searchResult = jsonToTree(dbJsonToFrontJson(response.data)).children
        } else {
          that.$message.error('失败')
        }
        that.loading = false
      }).catch(error => {
        that.$message.error(error)
        that.loading = false
      })
    },
    handleCheckChange(data, checked, indeterminate) {
      data = this.$refs.leftTree.getCheckedNodes()
      this.activities = treeNodeToTimeline(data, checked, indeterminate)
    }
  }
}
</script>

