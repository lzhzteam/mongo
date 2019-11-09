<template>
  <div>
    <el-tabs tab-position="left">
      <el-tab-pane label="直方图"><div id="positionHistogram" class="positionHistogram" style="height:500px;width:1000px" /></el-tab-pane>
      <el-tab-pane label="扇形图"><div id="positionSector" class="positionSector" style="height:500px;width:1000px" /></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import echarts from 'echarts'
import resize from '@/components/Charts/mixins/resize'

export default {
  mixins: [resize],
  props: {
    data: {
      type: Object,
      default() {
        return {
          position: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
        }
      }
    }
  },
  data() {
    return {
      positionHistogram: null,
      positionSector: null
    }
  },
  mounted() {
    this.initHistogram()
    this.initSector()
  },
  beforeDestroy() {
    if (this.positionHistogram) {
      this.positionHistogram.dispose()
      this.positionHistogram = null
    }
    if (this.positionSector) {
      this.positionSector.dispose()
      this.positionSector = null
    }
  },
  methods: {
    initHistogram() {
      this.positionHistogram = echarts.init(document.getElementById('positionHistogram'))
      const data = this.data.position
      var sum = 0
      console.info(data)
      data.forEach(item => {
        sum += item
      })
      var score = []
      if (sum === 0) {
        score = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
      } else {
        data.forEach(item => {
          score.push(item / sum * 100)
        })
      }
      this.positionHistogram.setOption({
        dataset: {
          source: [
            ['score', 'amount', 'product'],
            [score[0], data[0], '右冠中段'],
            [score[1], data[1], '右冠近段'],
            [score[2], data[2], '右冠远段'],
            [score[3], data[3], '右冠来源的后降支'],
            [score[4], data[4], '左主干'],
            [score[5], data[5], '前降支近段'],
            [score[6], data[6], '前降支中段'],
            [score[7], data[7], '前降支远段'],
            [score[8], data[8], '第一对角支'],
            [score[9], data[9], '第二对角支'],
            [score[10], data[10], '回旋支近段'],
            [score[11], data[11], '第一钝缘支'],
            [score[12], data[12], '回旋支远段'],
            [score[13], data[13], '第二钝缘支'],
            [score[14], data[14], '回旋支来源的后降支'],
            [score[15], data[15], '右冠来源的左室后支'],
            [score[16], data[16], '回旋支来源的左室后支'],
            [score[17], data[17], '中间支']
          ]
        },
        grid: { containLabel: true },
        xAxis: { name: '人数' },
        yAxis: { type: 'category' },
        visualMap: {
          orient: 'horizontal',
          left: 'center',
          min: 0,
          max: 100,
          text: ['High Score', 'Low Score'],
          // Map the score column to color
          dimension: 0,
          inRange: {
            color: ['#D7DA8B', '#E15457']
          }
        },
        series: [
          {
            type: 'bar',
            encode: {
              // Map the "amount" column to X axis.
              x: 'amount',
              // Map the "product" column to Y axis
              y: 'product'
            }
          }
        ]
      })
    },
    initSector() {
      this.positionSector = echarts.init(document.getElementById('positionSector'))
      var data = this.data.position
      this.positionSector.setOption({
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          type: 'scroll',
          orient: 'vertical',
          right: -30,
          top: 20,
          bottom: 20,
          data: ['右冠中段', '右冠近段', '右冠远段', '右冠来源的后降支', '左主干', '前降支近段',
            '前降支中段', '前降支远段', '第一对角支', '第二对角支', '回旋支近段', '第一钝缘支',
            '回旋支远段', '第二钝缘支', '回旋支来源的后降支', '右冠来源的左室后支', '回旋支来源的左室后支', '中间支']
        },
        series: [
          {
            type: 'pie',
            radius: '65%',
            center: ['50%', '50%'],
            selectedMode: 'single',
            data: [
              { value: data[0], name: '右冠中段' },
              { value: data[1], name: '右冠近段' },
              { value: data[2], name: '右冠远段' },
              { value: data[3], name: '右冠来源的后降支' },
              { value: data[4], name: '左主干' },
              { value: data[5], name: '前降支近段' },
              { value: data[6], name: '前降支中段' },
              { value: data[7], name: '前降支远段' },
              { value: data[8], name: '第一对角支' },
              { value: data[9], name: '第二对角支' },
              { value: data[10], name: '回旋支近段' },
              { value: data[11], name: '第一钝缘支' },
              { value: data[12], name: '回旋支远段' },
              { value: data[13], name: '第二钝缘支' },
              { value: data[14], name: '回旋支来源的后降支' },
              { value: data[15], name: '右冠来源的左室后支' },
              { value: data[16], name: '回旋支来源的左室后支' },
              { value: data[17], name: '中间支' }
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      })
    }
  }
}
</script>

<style scoped>

</style>
