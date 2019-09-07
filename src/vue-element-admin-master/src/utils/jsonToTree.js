// 转json到element-tree所需要的格式
// idProp 到 childrenProp 都是那个位置的属性名 可以修改
// labelAvailables 是可以在条目上label位置展示的子内容里的条目属性名 从前到后优先级递增
export function jsonToTree(dataObject,
  count = 0,
  name = 'undef',
  idProp = 'id',
  labelProp = 'label',
  childrenProp = 'children',
  labelAvailables = ['姓名', '检查时间']
) {
  if (typeof dataObject === 'object') {
    const resultObject = []
    for (const prop in dataObject) {
      resultObject.push(jsonToTree(dataObject[prop], count, prop, idProp, labelProp, childrenProp, labelAvailables))
      if (labelAvailables.includes(prop)) {
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
