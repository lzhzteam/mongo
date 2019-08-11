<template>
  <div style="max-width: 1250px; margin-left: 50px;">
    <h1 align="center">冠心病患者基线资料表</h1>
    <el-form ref="form" :model="ccta" label-width="100px" label-position="left">
      <el-form-item label="编号">
        <el-input v-model="ccta.编号"/>
      </el-form-item>
      <el-form :inline="true" class="demo-form-inline" label-width="100px">
        <el-form-item label="姓名" >
          <el-input v-model="ccta.姓名"/>
        </el-form-item>
        <el-form-item label="性别">
          <el-input v-model="ccta.性别"/>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="ccta.年龄"/>
        </el-form-item>
        <el-form-item label="检查时间">
          <el-date-picker
            v-model="ccta.检查时间"
            align="center"
            type="date"
            placeholder="选择日期"
            :picker-options="pickerOptions">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <el-form-item label="冠状动脉CT是否异常" label-width="200px">
        <el-radio v-model="ccta.冠状动脉CT是否异常" label="true">是</el-radio>
        <el-radio v-model="ccta.冠状动脉CT是否异常" label="false">否</el-radio>
      </el-form-item>
      <span v-if="ccta.冠状动脉CT是否异常">
        <el-form-item label="病变位置">
          <el-radio-group v-model="ccta.病变位置">
            <el-radio v-for="location in locationOptions" :label="location.value" style="width: 150px; margin: 10px;">{{location.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="病变长度">
          <el-radio-group v-model="ccta.病变长度">
            <el-radio v-for="length in lengthOptions" :label="length.value" style="width: 150px; margin: 10px;">{{length.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="斑块特征">
          <el-radio-group v-model="ccta.斑块特征">
            <el-radio v-for="feature in featureOptions" :label="feature.value" style="width: 150px; margin: 10px;">{{feature.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="狭窄度">
          <el-input v-model="ccta.狭窄度" style="width: 100px;"/><span> mm </span>
        </el-form-item>
      </span>
    </el-form>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        ccta: {
          编号: '',
          姓名: '',
          性别: '',
          年龄: '',
          检查时间: '',
          冠状动脉CT是否异常: 'true',
          病变位置: '',
          病变长度: '',
          斑块特征: ''
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
            return time.getTime() > Date.now();
          },
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      }
    }
  }
</script>
