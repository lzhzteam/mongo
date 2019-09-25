// 转json到element-tree所需要的格式
// idProp 到 childrenProp 都是那个位置的属性名 可以修改
// labelAvailables 是可以在条目上label位置展示的子内容里的条目属性名 从前到后优先级递增
export function jsonToTree(
  dataObject,
  count = 0,
  name = 'undef',
  idProp = 'id',
  labelProp = 'label',
  childrenProp = 'children',
  labelAvailables = ['姓名', '年龄', '检查时间']
) {
  if (typeof dataObject === 'object') {
    const resultObject = []
    let priority = -1
    for (const prop in dataObject) {
      resultObject.push(jsonToTree(dataObject[prop], count, prop, idProp, labelProp, childrenProp, labelAvailables))
      if (labelAvailables.includes(prop) && labelAvailables.indexOf(prop) > priority) {
        priority = labelAvailables.indexOf(prop)
        name = prop + ' : ' + dataObject[prop]
      }
    }
    return {
      [idProp]: count,
      [labelProp]: name,
      [childrenProp]: resultObject
    }
  } else {
    return {
      [idProp]: count,
      [labelProp]: name + ' : ' + dataObject
    }
  }
}

export function treeNodeToTimeline(treenodes, checked, indeterminate, labelProp = '检查时间') {
  const result = []
  for (const treenode in treenodes) {
    if (treenodes[treenode].label.indexOf(labelProp) !== -1 &&
      Object.keys(treenodes[treenode]).includes('children') &&
      treenodes[treenode].children.length > 0) {
      result.push({
        content: [treenodes[treenode]],
        timestamp: treenodes[treenode].label.split(' ')[2]
      })
    }
  }
  return result
}

const locationOptions = [{
  label: '右冠中端',
  value: 1
}, {
  label: '右冠近段',
  value: 2
}, {
  label: '右冠远段',
  value: 3
}, {
  label: '右冠来源的后降支',
  value: 4
}, {
  label: '左主干',
  value: 5
}, {
  label: '前降支近段',
  value: 6
}, {
  label: '前降支中段',
  value: 7
}, {
  label: '前降支远段',
  value: 8
}, {
  label: '第一对角支',
  value: 9
}, {
  label: '第二对角支',
  value: 10
}, {
  label: '回旋支近段',
  value: 11
}, {
  label: '第一钝缘支',
  value: 12
}, {
  label: '回旋支远段',
  value: 13
}, {
  label: '第二钝缘支',
  value: 14
}, {
  label: '回旋支来源的后降支',
  value: 15
}, {
  label: '右冠来源的左室后支',
  value: 16
}, {
  label: '回旋支来源的左室后支',
  value: 17
}, {
  label: '中间支',
  value: 18
}]

const lengthOptions = [{
  label: '局限(小于1mm)',
  value: 1
}, {
  label: '节段(10mm - 20mm)',
  value: 2
}, {
  label: '弥漫(大于20mm)',
  value: 3
}]
const featureOptions = [{
  label: '钙化斑块',
  value: 1
}, {
  label: '非钙化斑块',
  value: 2
}, {
  label: '混合斑块',
  value: 3
}]

export function dbJsonToFrontJson(dbJson) {
  const frontJson = []
  for (const patientKey in dbJson) {
    const frontCase = {}
    const patient = dbJson[patientKey]
    for (const k in patient) {
      switch (k) {
        case 'cctas': { // cctas
          // ////////////
          const cctasJson = []
          for (const cctaKey in patient[k]) {
            const cctaJson = {}
            const ccta = patient[k][cctaKey] // ccta 是每次ccta检查结果
            for (const term in ccta) {
              if (ccta[term] === null) { // 如果为null则直接去掉这一项了
                continue
              }

              switch (term) { // ccta中的每一项
                case '冠状动脉CT是否异常': {
                  if (ccta[term] === true) {
                    cctaJson['冠状动脉CT'] = '异常'
                  } else {
                    cctaJson['冠状动脉CT'] = '正常'
                  }
                  break }
                case '病变位置': {
                  if (ccta[term] > 0 && ccta[term] <= locationOptions.length) {
                    cctaJson['病变位置'] = locationOptions[ccta[term] - 1].label
                  } else {
                    cctaJson['病变位置'] = '未知'
                  }
                  break }
                case '病变长度': {
                  if (ccta[term] > 0 && ccta[term] <= lengthOptions.length) {
                    cctaJson['病变长度'] = lengthOptions[ccta[term] - 1].label
                  } else {
                    cctaJson['病变长度'] = '未知'
                  }
                  break }
                case '斑块特征': {
                  if (ccta[term] > 0 && ccta[term] <= featureOptions.length) {
                    cctaJson['斑块特征'] = featureOptions[ccta[term] - 1].label
                  } else {
                    cctaJson['斑块特征'] = '未知'
                  }
                  break }
                case '狭窄度': {
                  cctaJson['狭窄度'] = ccta[term] + 'mm'
                  break }
                default: {
                  cctaJson[term] = ccta[term] }
              }
            }
            cctasJson.push(cctaJson)
          }
          // ////////////
          frontCase[k] = cctasJson
          break }

        case 'bdts': { // bdts
          // ////////////
          const bdtsJson = []
          for (const bdtKey in patient[k]) {
            const bdtJson = {}
            const bdt = patient[k][bdtKey] // bdt
            for (const term in bdt) {
              switch (term) {
                default:
                  bdtJson[term] = bdt[term]
              }
            }
            bdtsJson.push(bdtJson)
          }
          // ////////////
          frontCase[k] = bdtsJson
          break
        }
        default: {
          frontCase[k] = patient[k]
        }
      }
    }

    frontJson.push(frontCase)
  }
  return frontJson
}

