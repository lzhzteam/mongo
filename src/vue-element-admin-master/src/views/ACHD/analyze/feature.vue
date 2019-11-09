<template>
  <div>
    <el-tabs tab-position="left">
      <el-tab-pane label="直方图"><div id="featureHistogram" class="featureHistogram" style="height:500px;width:1000px" /></el-tab-pane>
      <el-tab-pane label="扇形图"><div id="featureSector" class="featureSector" style="height:500px;width:1000px" /></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import echarts from 'echarts'

export default {
  props: {
    data: {
      type: Object,
      default() {
        return {
          feature: [1, 2, 3]
        }
      }
    },
    className: {
      type: String,
      default: 'chart'
    },
    id: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '1000px'
    },
    height: {
      type: String,
      default: '500px'
    }
  },
  data() {
    return {
      featureHistogram: null,
      featureSector: null
    }
  },
  mounted() {
    console.info(this.data)
    this.initHistogram()
    this.initSector()
  },
  beforeDestroy() {
    if (this.featureHistogram) {
      this.featureHistogram.dispose()
      this.featureHistogram = null
    }
    if (this.featureSector) {
      this.featureSector.dispose()
      this.featureSector = null
    }
  },
  methods: {
    initHistogram() {
      this.featureHistogram = echarts.init(document.getElementById('featureHistogram'))
      const data = this.data.feature
      var sum = 0
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
      this.featureHistogram.setOption({
        dataset: {
          source: [
            ['score', 'amount', 'product'],
            [score[0], data[0], '钙化斑块'],
            [score[1], data[1], '非钙化斑块'],
            [score[2], data[2], '混合斑块']
          ]
        },
        grid: { containLabel: true },
        xAxis: { name: '人数' },
        yAxis: { type: 'category' },
        visualMap: {
          orient: 'horizontal',
          left: 'center',
          min: 10,
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
      this.featureSector = echarts.init(document.getElementById('featureSector'))
      var data = this.data.feature
      this.featureSector.setOption({
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
          data: ['钙化斑块', '非钙化斑块', '混合斑块']
        },
        series: [
          {
            type: 'pie',
            radius: '65%',
            center: ['50%', '50%'],
            selectedMode: 'single',
            data: [
              { value: data[0], name: '钙化斑块' },
              { value: data[1], name: '非钙化斑块' },
              { value: data[2], name: '混合斑块' }
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
