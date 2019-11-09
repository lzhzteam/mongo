import request from '@/utils/request'

// CCTA操作
export function insertCCTA(data) {
  return request({
    url: '/CCTA',
    method: 'post',
    data
  })
}

// BDT操作
export function insertBDT(data) {
  return request({
    url: '/BDT',
    method: 'post',
    data
  })
}

// 搜索
export function search(data) {
  return request({
    url: '/search/' + data,
    method: 'get'
  })
}

// 病因分析
export function analyze(data) {
  return request({
    url: '/analyze/' + data.key + '/' + data.value,
    method: 'get'
  })
}

// 病因分析
export function analyzeAll() {
  return request({
    url: '/analyze/all',
    method: 'get'
  })
}
