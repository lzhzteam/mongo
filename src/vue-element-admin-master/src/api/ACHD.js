import request from '@/utils/request'

// CCTA操作
export function insertCCTA(data) {
  return request({
    url: '/CCTA',
    method: 'post',
    data
  })
}
// 搜索
export function search(data) {
  return request({
    url: '/' + data,
    method: 'get'
  })
}
