import request from '@/utils/request'

// CCTA操作
export function insertCCTA(param) {
  console.info(param)
  return request({
    url: '/CCTA',
    method: 'post',
    param
  })
}
