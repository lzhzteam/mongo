<template>
  <div class="app-container">
    <div>
      <el-cascader
        v-model="value"
        :options="options"
        placeholder="请选择查询要素"
        change-on-select
        clearable
        size="mini"
      />
      <el-button type="primary" icon="el-icon-search" circle size="mini" @click="search" />
    </div>
    <div>
      <el-tabs v-model="activeGraph">
        <el-tab-pane label="相对危险度与关联强度" name="config"><config /></el-tab-pane>
        <el-tab-pane v-if="analyze.comparison" label="发病率对照表" name="comparison"><comparison :data="analyze" /></el-tab-pane>
        <el-tab-pane :key="analyze.position[0]" label="病变位置统计图" name="position"><position :data="analyze" ref="position"/></el-tab-pane>
        <el-tab-pane :key="analyze.length[0]" label="病变长度统计图" name="length"><length :data="analyze" /></el-tab-pane>
        <el-tab-pane :key="analyze.feature[0]" label="病变特征统计图" name="feature"><feature :data="analyze" /></el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>

import { analyze, analyzeAll } from '@/api/ACHD'
import config from './config'
import comparison from './comparison'
import position from './position'
import length from './length'
import feature from './feature'

export default {
  name: 'Analyze',
  components: {
    config,
    comparison,
    position,
    length,
    feature
  },
  data() {
    return {
      options: [
        // {
        //   value: '年龄',
        //   label: '年龄'
        // },
        // {
        //   value: '性别',
        //   label: '性别'
        // },
        {
          value: '检查目的',
          label: '检查目的',
          children: [
            {
              value: {
                key: '检查目的.典型心绞痛',
                value: true,
                title: '检查目的',
                testTitle: '典型心绞痛'
              },
              label: '典型心绞痛'
            },
            {
              value: {
                key: '检查目的.非典型性胸部不适',
                value: true,
                title: '检查目的',
                testTitle: '非典型性胸部不适'
              },
              label: '非典型性胸部不适'
            },
            {
              value: {
                key: '检查目的.非胸痛症状',
                value: true,
                title: '检查目的',
                testTitle: '非胸痛症状'
              },
              label: '非胸痛症状'
            },
            {
              value: {
                key: '检查目的.心电图异常',
                value: true,
                title: '检查目的',
                testTitle: '心电图异常'
              },
              label: '心电图异常'
            },
            {
              value: {
                key: '检查目的.心脏超声异常',
                value: true,
                title: '检查目的',
                testTitle: '心脏超声异常'
              },
              label: '心脏超声异常'
            }
          ]
        },
        {
          value: {
            key: '高血压病.有无',
            value: 3,
            title: '高血压病',
            testTitle: '有高血压病'
          },
          label: '高血压病'
        },
        {
          value: {
            key: '血脂异常.有无',
            value: 3,
            title: '血脂异常',
            testTitle: '有血脂异常'
          },
          label: '血脂异常'
        },
        {
          value: {
            key: '糖尿病史.有无',
            value: 3,
            title: '糖尿病史',
            testTitle: '有糖尿病史'
          },
          label: '糖尿病史',
          children: [
            {
              value: {
                key: '糖尿病史.分型',
                value: 1,
                title: '糖尿病史',
                testTitle: '1型'
              },
              label: '1型'
            },
            {
              value: {
                key: '糖尿病史.分型',
                value: 2,
                title: '糖尿病史',
                testTitle: '2型'
              },
              label: '2型'
            }
          ]
        },
        {
          value: {
            key: '脑卒中病史.有无',
            value: 3,
            title: '脑卒中病史',
            testTitle: '有脑卒中病史'
          },
          label: '脑卒中病史'
        },
        {
          value: {
            key: '外周血管病.有无',
            value: 3,
            title: '脑卒中病史',
            testTitle: '有外周血管病'
          },
          label: '外周血管病'
        },
        // {
        //   value: '吸烟史',
        //   label: '吸烟史'
        // },
        // {
        //   value: '饮酒史',
        //   label: '饮酒史'
        // },
        // {
        //   value: '体育锻炼史',
        //   label: '体育锻炼史'
        // },
        {
          value: {
            key: '心肌梗死.有无',
            value: 2,
            title: '心肌梗死',
            testTitle: '有心肌梗死'
          },
          label: '心肌梗死'
        },
        // {
        //   value: '目前服药',
        //   label: '目前服药',
        //   children: [
        //     {
        //       value: '阿司匹林',
        //       label: '阿司匹林'
        //     },
        //     {
        //       value: '硫酸氢氯吡格雷',
        //       label: '硫酸氢氯吡格雷'
        //     },
        //     {
        //       value: '硝酸酯类药物',
        //       label: '硝酸酯类药物'
        //     },
        //     {
        //       value: '华法林等抗凝药',
        //       label: '华法林等抗凝药'
        //     }
        //   ]
        // },
        {
          value: '其他疾病史',
          label: '其他疾病史',
          children: [
            {
              value: {
                key: '其他疾病史.肝功能不全',
                value: true,
                title: '其他疾病史',
                testTitle: '肝功能不全'
              },
              label: '肝功能不全'
            },
            {
              value: {
                key: '其他疾病史.肾功能不全',
                value: true,
                title: '其他疾病史',
                testTitle: '肾功能不全'
              },
              label: '肾功能不全'
            },
            {
              value: {
                key: '其他疾病史.肿瘤',
                value: true,
                title: '其他疾病史',
                testTitle: '肿瘤'
              },
              label: '肿瘤'
            }
          ]
        },
        {
          value: '家族史',
          label: '家族史',
          children: [
            {
              value: {
                key: '家族史.冠心病家族史.有无',
                value: 1,
                title: '家族史',
                testTitle: '有冠心病家族史'
              },
              label: '冠心病家族史'
            },
            {
              value: {
                key: '家族史.高脂血症家族史',
                value: 1,
                title: '家族史',
                testTitle: '有高脂血症家族史'
              },
              label: '高脂血症家族史'
            }
          ]
        }
      ],
      value: '',
      analyze: {},
      activeGraph: 'config'
    }
  },

  mounted() {
    this.search()
  },
  methods: {
    search() {
      var param
      if (this.value.length === 0) {
        analyzeAll().then(response => {
          this.analyze.comparison = false
          this.analyze.graph = true
          this.analyze = response
        })
        return
      } else if (this.value.length === 1) {
        switch (this.value[0]) {
          case '年龄':
          case '性别':
          case '检查目的':
          case '吸烟史':
          case '饮酒史':
          case '体育锻炼史':
          case '其他家族病史':
            this.analyze.comparison = true
            this.analyze.graph = true
            return
          default:
            param = this.value[0]
            break
        }
      } else if (this.value.length === 2) {
        param = this.value[1]
      }
      analyze(param).then(response => {
        console.info(response)
        this.analyze = response
        this.analyze.title = param.title
        this.analyze.testTitle = param.testTitle
        this.analyze.comparison = true
        this.analyze.graph = true
        this.activeGraph = 'comparison'
      })
    }
  }
}
</script>
