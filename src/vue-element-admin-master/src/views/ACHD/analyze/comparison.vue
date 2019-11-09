<template>
  <div>
    <el-row>
      <el-col :span="24"><div class="grid-content bg-grid1" style="margin-top: 10px;">{{ data.title }}</div></el-col>
    </el-row>
    <el-row>
      <el-col :span="4"><div class="grid-content bg-grid1">{{ data.testTitle }}</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2">冠心病患者</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2" /></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2">{{ data.testTrue }} 人</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid1">发病率</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid4" /></el-col>
    </el-row>
    <el-row>
      <el-col :span="4"><div class="grid-content bg-grid3">{{ data.testTotal }} 人</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2">非冠心病患者</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2" /></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2">{{ data.testFalse }} 人</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid3">{{ data.testRate }} %</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid5">比率</div></el-col>
    </el-row>
    <el-row>
      <el-col :span="4"><div class="grid-content bg-grid1">非选择病因</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2">冠心病患者</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2" /></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2">{{ data.controlTrue }} 人</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid1">发病率</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid5">{{ data.scale }}</div></el-col>
    </el-row>
    <el-row>
      <el-col :span="4"><div class="grid-content bg-grid3">{{ data.controlTotal }} 人</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2">非冠心病患者</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2" /></el-col>
      <el-col :span="4"><div class="grid-content bg-grid2">{{ data.controlFalse }} 人</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid3">{{ data.controlRate }} %</div></el-col>
      <el-col :span="4"><div class="grid-content bg-grid5" /></el-col>
    </el-row>
    <el-row>
      <el-col :span="8"><div class="grid-content bg-grid6">RR: {{ data.rr }}</div></el-col>
      <el-col :span="8"><div class="grid-content bg-grid7">AR: {{ data.ar }}</div></el-col>
      <el-col :span="8"><div class="grid-content bg-grid6">PAR: {{ data.par }}</div></el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'Comparison',
  props: {
    data: {
      type: Object,
      default() {
        return {
          title: 'title',
          testTitle: 'test',
          testTotal: 0,
          testTrue: 0,
          testFalse: 0,
          testRate: 0,
          controlTotal: 0,
          controlTrue: 0,
          controlFalse: 0,
          controlRate: 0,
          scale: '0:0',
          rr: 0,
          ar: 0,
          par: 0
        }
      }
    }
  }
}
</script>

<style >
  /*上、左、下*/
  .bg-grid1 {
    border: 1px solid #8c939d;
    border-bottom: 0;
  }
  /*上*/
  .bg-grid2 {
    border-top: 1px solid #8c939d;
  }
  /*左、右*/
  .bg-grid3 {
    border-left: 1px solid #8c939d;
    border-right: 1px solid #8c939d;
  }
  /*上、右*/
  .bg-grid4 {
    border-top: 1px solid #8c939d;
    border-right: 1px solid #8c939d;
  }
  /*右*/
  .bg-grid5 {
    border-right: 1px solid #8c939d;
  }
  /*上、下、左、右*/
  .bg-grid6 {
    border: 1px solid #8c939d;
  }
  .bg-grid7 {
    border-top: 1px solid #8c939d;
    border-bottom: 1px solid #8c939d;
  }
  .grid-content {
    height: 50px;
    border-radius: 0;
    text-align: center;
    line-height: 50px;
    font-size: 20px;
  }
</style>
