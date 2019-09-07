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
      <el-form-item label="搜索结果" class="custom-two-col">

        <el-tree
          :data="searchResult"
        />

        <el-timeline>
          <el-timeline-item
            v-for="(activity, index) in activities"
            :key="index"
            :icon="activity.icon"
            :type="activity.type"
            :color="activity.color"
            :size="activity.size"
            :timestamp="activity.timestamp"
          >
            {{ activity.content }}
          </el-timeline-item>
        </el-timeline>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
import { search } from '../../../api/ACHD'
import { jsonToTree } from '../../../utils/jsonToEtc'

export default {
  data() {
    return {
      loading: false,
      searchCondition: '',
      searchResult: []
    }
  },
  computed: {
    activities: function() {
      const result = []
      if (this.searchResult.size > 0) {
        const son = this.searchResult[0].children
        for (const grandson in son) {
          if (grandson['label'] === 'cctas') {
            const cctas = grandson.children
            for (const ccta in cctas) {
              const timestampStrings = ccta.label.split(' ')
              // "label": "检查时间 : 2019-03-04T16:00:00.000+0000" 所以是按空格分隔第三个
              result.push({
                content: ccta,
                timestamp: timestampStrings[2]
              })
            }
          }
        }
      }
      return result
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

