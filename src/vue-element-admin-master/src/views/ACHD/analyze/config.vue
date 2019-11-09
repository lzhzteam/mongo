<template>
  <el-table
    :data="tableData"
    border
    style="width: 100%"
  >
    <el-table-column
      prop="RR1"
      label="RR1"
      width="180"
    />
    <el-table-column
      prop="RR2"
      label="RR2"
    />
    <el-table-column
      prop="guanlianqiangdu"
      label="关联强度"
      width="180"
    />
  </el-table>
</template>

<script>
export default {
  name: 'Config',
  data() {
    return {
      tableData: [{
        RR1: '0.9~1.0',
        RR2: '1.0~1.1',
        guanlianqiangdu: '无关联'
      }, {
        RR1: '0.7~0.8',
        RR2: '1.2~1.4',
        guanlianqiangdu: '弱'
      },
      {
        RR1: '0.4~0.6',
        RR2: '1.5~2.9',
        guanlianqiangdu: '中'
      },
      {
        RR1: '0.1~0.3',
        RR2:
                  '3.0~9.9',
        guanlianqiangdu:
                  '强'
      },
      {
        RR1: '< 0.1',
        RR2:
                  '10~',
        guanlianqiangdu:
                  '很强'
      }
      ]
    }
  }
}
</script>

<style scoped>

</style>
