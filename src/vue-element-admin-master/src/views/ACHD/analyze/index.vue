<template>
  <div class="app-container">
    <div>
      <span v-for="(value, index) in values" :key="value" :class="values[index]">
        <el-cascader
          v-model="values[index]"
          :options="options"
          placeholder="请选择查询要素"
          change-on-select
          clearable
          size="mini"
        />
      </span>
      <el-button v-if="values.length <= 5" icon="el-icon-plus" circle size="mini" @click="addSearch" />
      <el-button v-else icon="el-icon-plus" circle disabled size="mini" />
      <el-button type="primary" icon="el-icon-search" circle size="mini" @click="search" />
    </div>

  </div>
</template>

<script>
export default {
  name: 'Analyze',
  data() {
    return {
      options: [
        {
          value: '年龄',
          label: '年龄'
        },
        {
          value: '性别',
          label: '性别'
        },
        {
          value: '检查目的',
          label: '检查目的',
          children: [
            {
              value: '典型心绞痛',
              label: '典型心绞痛'
            },
            {
              value: '非典型性胸部不适',
              label: '非典型性胸部不适'
            },
            {
              value: '非胸痛症状',
              label: '非胸痛症状'
            },
            {
              value: '心电图异常',
              label: '心电图异常'
            },
            {
              value: '心脏超声异常',
              label: '心脏超声异常'
            }
          ]
        },
        {
          value: '高血压病',
          label: '高血压病'
        },
        {
          value: '血脂异常',
          label: '血脂异常'
        },
        {
          value: '糖尿病史',
          label: '糖尿病史',
          children: [
            {
              value: '1型',
              label: '1型'
            },
            {
              value: '2型',
              label: '2型'
            }
          ]
        },
        {
          value: '脑卒中病史',
          label: '脑卒中病史'
        },
        {
          value: '外周血管病',
          label: '外周血管病'
        },
        {
          value: '吸烟史',
          label: '吸烟史'
        },
        {
          value: '饮酒史',
          label: '饮酒史'
        },
        {
          value: '体育锻炼史',
          label: '体育锻炼史'
        },
        {
          value: '心肌梗死',
          label: '心肌梗死'
        },
        {
          value: '目前服药',
          label: '目前服药',
          children: [
            {
              value: '阿司匹林',
              label: '阿司匹林'
            },
            {
              value: '硫酸氢氯吡格雷',
              label: '硫酸氢氯吡格雷'
            },
            {
              value: '硝酸酯类药物',
              label: '硝酸酯类药物'
            },
            {
              value: '华法林等抗凝药',
              label: '华法林等抗凝药'
            }
          ]
        },
        {
          value: '其他疾病史',
          label: '其他疾病史',
          children: [
            {
              value: '肝功能不全',
              label: '肝功能不全'
            },
            {
              value: '肾功能不全',
              label: '肾功能不全'
            },
            {
              value: '肿瘤',
              label: '肿瘤'
            }
          ]
        },
        {
          value: '家族史',
          label: '家族史',
          children: [
            {
              value: '冠心病家族史',
              label: '冠心病家族史'
            },
            {
              value: '高脂血症家族史',
              label: '高脂血症家族史'
            }
          ]
        }
      ],
      values: [''],
      analyze: {
        searchClass: ''
      }
    }
  },
  created() {

  },
  methods: {
    addSearch() {
      this.values.push('')
    },
    search() {
      console.info(this.values)
    }
  }
}
</script>
