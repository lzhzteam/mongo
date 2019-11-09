<template>
  <div>
    <el-tabs tab-position="left">
      <el-tab-pane label="直方图"><div id="lengthHistogram" class="lengthHistogram" style="height:500px;width:1000px" /></el-tab-pane>
      <el-tab-pane label="扇形图"><div id="lengthSector" class="lengthSector" style="height:500px;width:1000px" /></el-tab-pane>
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
          length: [1, 2, 3]
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
      lengthHistogram: null,
      lengthSector: null
    }
  },
  mounted() {
    console.info(this.data)
    this.initHistogram()
    this.initSector()
  },
  beforeDestroy() {
    if (this.lengthHistogram) {
      this.lengthHistogram.dispose()
      this.lengthHistogram = null
    }
    if (this.lengthSector) {
      this.lengthSector.dispose()
      this.lengthSector = null
    }
  },
  methods: {
    initHistogram() {
      this.lengthHistogram = echarts.init(document.getElementById('lengthHistogram'))
      const data = this.data.length
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
      this.lengthHistogram.setOption({
        dataset: {
          source: [
            ['score', 'amount', 'product'],
            [score[0], data[0], '局限(小于1mm)'],
            [score[1], data[1], '节段(10mm-20mm)'],
            [score[2], data[2], '弥漫(大于20mm)']
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
      this.lengthSector = echarts.init(document.getElementById('lengthSector'))
      var data = this.data.length
      this.lengthSector.setOption({
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
          data: ['局限(小于1mm)', '节段(10mm-20mm)', '弥漫(大于20mm)']
        },
        series: [
          {
            type: 'pie',
            radius: '65%',
            center: ['50%', '50%'],
            selectedMode: 'single',
            data: [
              { value: data[0], name: '局限(小于1mm)' },
              { value: data[1], name: '节段(10mm-20mm)' },
              { value: data[2], name: '弥漫(大于20mm)' }
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
