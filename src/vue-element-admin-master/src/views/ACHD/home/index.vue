<template>
  <div class="block">
    <el-carousel trigger="click" height="600px">
      <el-carousel-item v-for="item in images" :key="item">
        <img :src="item" style="height:100%; width: 100%">
      </el-carousel-item>
    </el-carousel>
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
  }
}
</script>
