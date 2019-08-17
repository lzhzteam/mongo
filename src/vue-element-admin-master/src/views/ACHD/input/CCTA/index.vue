<template>
  <div style="max-width: 1250px; margin-left: 50px;">
    <h1 align="center">冠心病患者基线资料表</h1>
    <el-form ref="ccta" :model="ccta" label-width="100px" label-position="left">
      <el-form-item
        label="编号"
        prop="编号"
        :rules="[{ required: true, message: '编号不能为空'}]"
      >
        <el-input v-model="ccta.编号" />
      </el-form-item>
      <el-form ref="ccta_inline" :model="ccta" :inline="true" class="demo-form-inline" label-width="100px">
        <el-form-item
          label="姓名"
          prop="姓名"
          :rules="[{ required: true, message: '姓名不能为空'}]"
        >
          <el-input v-model="ccta.姓名" />
        </el-form-item>
        <el-form-item label="性别" label-width="50px" style="margin-left: 20px;margin-right: 20px">
          <el-radio-group v-model="ccta.性别">
            <el-radio label="男">男</el-radio>
            <el-radio label="女">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item
          label="年龄"
          prop="CCTAs[0].年龄"
          label-width="50px"
          style="margin-left: 20px;margin-right: 20px"
          :rules="[
            { required: true, message: '年龄不能为空'},
            { type: 'number', message: '年龄必须为数字值'}
          ]"
        >
          <el-input v-model.number="ccta.CCTAs[0].年龄" />
        </el-form-item>
        <el-form-item label="检查时间" style="margin-left: 20px;margin-right: 20px">
          <el-date-picker
            v-model="ccta.CCTAs[0].检查时间"
            align="center"
            type="date"
            placeholder="选择日期"
            :picker-options="pickerOptions"
          />
        </el-form-item>
      </el-form>
      <el-form-item label="冠状动脉CT是否异常" label-width="200px">
        <el-radio-group v-model="ccta.CCTAs[0].冠状动脉CT是否异常">
          <el-radio label="true">是</el-radio>
          <el-radio label="false">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <span v-if="ccta.CCTAs[0].冠状动脉CT是否异常 === 'true'">
        <el-form-item
          label="病变位置"
          prop="CCTAs[0].病变位置"
          :rules="[{ required: true, message: '请选择病变位置'}]"
        >
          <el-radio-group v-model="ccta.CCTAs[0].病变位置">
            <el-radio v-for="location in locationOptions" :key="location.value" :label="location.value" style="width: 150px; margin: 10px;">{{ location.label }}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item
          label="病变长度"
          prop="CCTAs[0].病变长度"
          :rules="[{ required: true, message: '请选择病变长度'}]">
          <el-radio-group v-model="ccta.CCTAs[0].病变长度">
            <el-radio v-for="length in lengthOptions" :key="length.value" :label="length.value" style="width: 150px; margin: 10px;">{{ length.label }}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item
          label="斑块特征"
          prop="CCTAs[0].斑块特征"
          :rules="[{ required: true, message: '请选择斑块特征'}]">
          <el-radio-group v-model="ccta.CCTAs[0].斑块特征">
            <el-radio v-for="feature in featureOptions" :key="feature.value" :label="feature.value" style="width: 150px; margin: 10px;">{{ feature.label }}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item
          label="狭窄度"
          prop="CCTAs[0].狭窄度"
          :rules="[
              { required: true, message: '狭窄度不能为空'},
              { type: 'number', message: '狭窄度必须为数字值'}
            ]">
          <el-input v-model.number="ccta.CCTAs[0].狭窄度" type="number" style="width: 100px;"/>
          <span> mm </span>
        </el-form-item>
      </span>
    </el-form>
    <div align="center">
      <el-button type="primary" :loading="loading" @click="submit">提交</el-button>
      <el-button type="primary" @click="reset">重置</el-button>
    </div>
  </div>
</template>

<script>
import { insertCCTA } from '../../../../api/ACHD'

export default {
  data() {
    return {
      loading: false,
      ccta: {
        编号: '',
        姓名: '',
        性别: '男',
        CCTAs: [{
          年龄: '',
          检查时间: new Date(),
          冠状动脉CT是否异常: 'true',
          病变位置: null,
          病变长度: null,
          斑块特征: null,
          狭窄度: null
        }]
      },
      locationOptions: [{
        label: '右冠中端',
        value: 1
      }, {
        label: '右冠近段',
        value: 2
      }, {
        label: '右冠远段',
        value: 3
      }, {
        label: '右冠来源的后降支',
        value: 4
      }, {
        label: '左主干',
        value: 5
      }, {
        label: '前降支近段',
        value: 6
      }, {
        label: '前降支中段',
        value: 7
      }, {
        label: '前降支远段',
        value: 8
      }, {
        label: '第一对角支',
        value: 9
      }, {
        label: '第二对角支',
        value: 10
      }, {
        label: '回旋支近段',
        value: 11
      }, {
        label: '第一钝缘支',
        value: 12
      }, {
        label: '回旋支远段',
        value: 13
      }, {
        label: '第二钝缘支',
        value: 14
      }, {
        label: '回旋支来源的后降支',
        value: 15
      }, {
        label: '右冠来源的左室后支',
        value: 16
      }, {
        label: '回旋支来源的左室后支',
        value: 17
      }, {
        label: '中间支',
        value: 18
      }],
      lengthOptions: [{
        label: '局限(小于1mm)',
        value: 1
      }, {
        label: '节段(10mm - 20mm)',
        value: 2
      }, {
        label: '弥漫(大于20mm)',
        value: 3
      }],
      featureOptions: [{
        label: '钙化斑块',
        value: 1
      }, {
        label: '非钙化斑块',
        value: 2
      }, {
        label: '混合斑块',
        value: 3
      }],
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now()
        },
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date())
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date()
            date.setTime(date.getTime() - 3600 * 1000 * 24)
            picker.$emit('pick', date)
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date()
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', date)
          }
        }]
      }
    }
  },
  mounted() {

  },
  methods: {
    submit() {
      this.$refs['ccta'].validate((valid) => {
        if (valid) {
          this.$refs['ccta_inline'].validate((valid) => {
            if (valid) {
              this.insert_ccta()
            } else {
              return false
            }
          })
        } else {
          return false
        }
      })
    },
    reset() {
      this.$confirm('重置将清除所有输入无法恢复, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.ccta.编号 = ''
        this.ccta.姓名 = ''
        this.ccta.性别 = ''
        this.ccta.CCTAs[0].年龄 = ''
        this.ccta.CCTAs[0].检查时间 = ''
        this.ccta.CCTAs[0].冠状动脉CT是否异常 = 'true'
        this.ccta.CCTAs[0].病变位置 = null
        this.ccta.CCTAs[0].病变长度 = null
        this.ccta.CCTAs[0].斑块特征 = null
        this.ccta.CCTAs[0].狭窄度 = null
      }).catch(() => {

      })
    },
    insert_ccta() {
      const that = this
      that.loading = true
      insertCCTA(that.ccta).then(response => {
        that.loading = false
        if (response.status === 0) {
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
