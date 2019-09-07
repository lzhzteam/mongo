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
