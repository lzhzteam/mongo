<template>
  <div style="background-color: #dfe7f4">
    <el-carousel trigger="click" height="500px">
      <el-carousel-item v-for="item in images" :key="item">
        <img :src="item" style="height:100%; width: 100%">
      </el-carousel-item>
    </el-carousel>
    <div style="margin-top: 50px; margin-left: 50px; margin-right: 50px; padding-bottom: 20px">
      <h1>面向冠心病早期预警的患者队列研究数据管理系统</h1>
      <p>本研究项目通过记录存储研究对象基线资料表，使用高效算法查询分析数据库中存储的数据，将数据可视化展现给研究者，为研究者提供高效研究工具，省时省力，降低成本，从而推动冠心病的研究。</p>
      <el-button type="primary" style="margin-top: 30px" @click="more()">了解更多</el-button>
    </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      images: [
        require('../../../assets/home1.jpg'),
        require('../../../assets/home2.jpg'),
        require('../../../assets/home3.png')
      ]
    }
  },
  methods: {
    more() {}
  }
}
</script>
