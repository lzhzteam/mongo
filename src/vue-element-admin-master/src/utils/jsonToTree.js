// 转json到element-tree所需要的格式
export function jsonToTree(dataObject, count = 0, name = 'undef', idProp = 'id', labelProp = 'label', childrenProp = 'children') {
  if (typeof dataObject === 'object') {
    const resultObject = []
    for (const prop in dataObject) {
      resultObject.push(jsonToTree(dataObject[prop], count, prop, idProp, labelProp, childrenProp))
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
