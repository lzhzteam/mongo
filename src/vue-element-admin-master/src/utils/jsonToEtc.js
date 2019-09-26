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
      [labelProp]: dataObject != null ? name + ' : ' + dataObject : name
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
                  break
                }
                case '病变位置': {
                  if (ccta[term] > 0 && ccta[term] <= locationOptions.length) {
                    cctaJson['病变位置'] = locationOptions[ccta[term] - 1].label
                  } else {
                    cctaJson['病变位置'] = '未知'
                  }
                  break
                }
                case '病变长度': {
                  if (ccta[term] > 0 && ccta[term] <= lengthOptions.length) {
                    cctaJson['病变长度'] = lengthOptions[ccta[term] - 1].label
                  } else {
                    cctaJson['病变长度'] = '未知'
                  }
                  break
                }
                case '斑块特征': {
                  if (ccta[term] > 0 && ccta[term] <= featureOptions.length) {
                    cctaJson['斑块特征'] = featureOptions[ccta[term] - 1].label
                  } else {
                    cctaJson['斑块特征'] = '未知'
                  }
                  break
                }
                case '狭窄度': {
                  cctaJson['狭窄度'] = ccta[term] + 'mm'
                  break
                }
                default: {
                  cctaJson[term] = ccta[term]
                }
              }
            }
            cctasJson.push(cctaJson)
          }
          // ////////////
          frontCase[k] = cctasJson
          break
        }

        case 'bdts': { // bdts
          // ////////////
          const bdtsJson = []
          for (const bdtKey in patient[k]) {
            const bdtJson = {}
            const bdt = patient[k][bdtKey] // bdt
            for (const term in bdt) {
              if (bdt[term] === null) { // 如果为null则直接去掉这一项了
                continue
              }
              switch (term) {
                case '血压': {
                  bdtJson['血压'] = bdt[term] + ' mmHg'
                  break
                }

                case '身高': {
                  bdtJson['身高'] = bdt[term] + ' cm'
                  break
                }

                case '体重': {
                  bdtJson['体重'] = bdt[term] + ' kg'
                  break
                }

                case '检查目的': { // 有true就加入这一项 value置为null 使其显示为XXX 而不是XXX : null
                  const purpose = bdt[term]
                  bdtJson['检查目的'] = {}
                  for (const purposeKey in purpose) {
                    if (purpose[purposeKey] === true) {
                      bdtJson['检查目的'][purposeKey] = null
                    } else if (
                      purposeKey === '其它' &&
                      purpose[purposeKey] != null &&
                      purpose[purposeKey] !== ''
                    ) { // 当其它不为空
                      bdtJson['检查目的'][purpose[purposeKey]] = null
                    }
                  }
                  if (Object.keys(bdtJson['检查目的']).length === 0) {
                    bdtJson['检查目的'] = '无'
                  }
                  break
                }

                case '高血压病': {
                  const highPressure = bdt[term]
                  bdtJson['高血压病'] = {}
                  for (const highPressureKey in highPressure) {
                    if (highPressureKey === '有无') {
                      if (highPressure[highPressureKey] === 1) {
                        bdtJson['高血压病'] = '不详'
                        break
                      }
                      if (highPressure[highPressureKey] === 2) {
                        delete bdtJson['高血压病']
                        break
                      }
                    }
                    switch (highPressureKey) {
                      case '目前用药': {
                        const medicine = [
                          'ACEI 或 ARB',
                          '钙离子抑制剂',
                          '利尿剂',
                          '受体阻滞剂'
                        ]
                        bdtJson['高血压病']['目前用药'] = medicine[highPressure['目前用药'] - 1]
                        break
                      }
                      case '用药后达标情况' : {
                        const reach = [
                          '达标',
                          '不达标',
                          '不稳定'
                        ]
                        bdtJson['高血压病']['用药后达标情况'] = reach[highPressure['用药后达标情况'] - 1]
                        break
                      }
                      default: {
                        break
                      }
                    }
                  }
                  break
                }

                case '血脂异常': {
                  const bloodFat = bdt[term]
                  bdtJson['血脂异常'] = {}
                  for (const bloodFatKey in bloodFat) {
                    if (bloodFatKey === '有无') {
                      if (bloodFat[bloodFatKey] === 1) {
                        bdtJson['血脂异常'] = '不详'
                        break
                      }
                      if (bloodFat[bloodFatKey] === 2) {
                        delete bdtJson['血脂异常']
                        break
                      }
                    }
                    switch (bloodFatKey) {
                      case '目前用药': {
                        const medicine = [
                          '他汀类药物',
                          '贝特类药物',
                          '依折麦布'
                        ]
                        bdtJson['血脂异常']['目前用药'] = medicine[bloodFat['目前用药'] - 1]
                        break
                      }
                      case '用药后控制情况': {
                        const reach = [
                          '正常',
                          '仍不正常',
                          '部分正常',
                          '不稳定'
                        ]
                        bdtJson['血脂异常']['用药后控制情况'] = reach[bloodFat['用药后控制情况'] - 1]
                        break
                      }
                      default : {
                        break
                      }
                    }
                  }
                  break
                }

                case '糖尿病史': {
                  const suger = bdt[term]
                  bdtJson['糖尿病史'] = {}
                  for (const sugerKey in suger) {
                    if (sugerKey === '有无') {
                      if (suger[sugerKey] === 1) {
                        bdtJson['糖尿病史'] = '不详'
                        break
                      }
                      if (suger[sugerKey] === 2) {
                        delete bdtJson['糖尿病史']
                        break
                      }
                    }
                    switch (sugerKey) {
                      case '分型': {
                        const type = ['1型', '2型']
                        bdtJson['糖尿病史']['分型'] = type[suger['分型'] - 1]
                        break
                      }
                      case '目前用药': {
                        const medicine = [
                          '胰岛素',
                          '二甲双胍',
                          '磺脲类药物',
                          'GLP-1类似物'
                        ]
                        bdtJson['糖尿病史']['目前用药'] = medicine[suger['目前用药'] - 1]
                        break
                      }
                      case '用药后控制情况': {
                        const reach = [
                          '正常',
                          '不正常',
                          '不稳定'
                        ]
                        bdtJson['糖尿病史']['用药后控制情况'] = reach[suger['用药后控制情况'] - 1]
                        break
                      }
                      default: {
                        break
                      }
                    }
                  }
                  break
                }

                case '脑卒中病史': {
                  const brainDie = bdt[term]
                  bdtJson['脑卒中病史'] = {}
                  for (const brainDieKey in brainDie) {
                    if (brainDieKey === '有无') {
                      if (brainDie[brainDieKey] === 1) {
                        bdtJson['脑卒中病史'] = '不详'
                        break
                      }
                      if (brainDie[brainDieKey] === 2) {
                        delete bdtJson['脑卒中病史']
                        break
                      }
                    }

                    switch (brainDieKey) {
                      case '发生时间':
                      case '发生部位': {
                        bdtJson['脑卒中病史'][brainDieKey] = brainDie[brainDieKey]
                        break
                      }
                      case '类型': {
                        const type = ['缺血性卒中', '出血性卒中', 'TIA发作']
                        bdtJson['脑卒中病史'][brainDieKey] = type[brainDie[brainDieKey] - 1]
                        break
                      }
                      default: {
                        break
                      }
                    }
                  }
                  break
                }

                case '外周血管病': {
                  const vein = bdt[term]
                  bdtJson['外周血管病'] = {}
                  for (const veinKey in vein) {
                    if (veinKey === '有无') {
                      if (vein[veinKey] === 1) {
                        bdtJson['外周血管病'] = '不详'
                        break
                      }
                      if (vein[veinKey] === 2) {
                        delete bdtJson['外周血管病']
                        break
                      }
                    }

                    switch (veinKey) {
                      case '发生时间':
                      case '发生部位': {
                        bdtJson['外周血管病'][veinKey] = vein[veinKey]
                        break
                      }
                      case '类型': {
                        const type = ['静脉', '动脉']
                        if (typeof vein[veinKey] === 'number' && !isNaN(vein[veinKey])) {
                          bdtJson['外周血管病']['发生部位'] = type[vein[veinKey] - 1]
                        } else {
                          bdtJson['外周血管病']['发生部位'] = vein[veinKey]
                        }
                        break
                      }
                      default: {
                        break
                      }
                    }
                  }
                  break
                }

                case '吸烟史': {
                  const smoke = bdt[term]
                  bdtJson['吸烟史'] = {}
                  for (const smokeKey in smoke) {
                    if (smokeKey === '频率') {
                      if (smoke[smokeKey] === 4) {
                        delete bdtJson['吸烟史']
                        break
                      }
                      switch (smoke[smokeKey]) {
                        case 1: {
                          bdtJson['吸烟史']['经常吸'] = '每日 ' + smoke['经常吸支数'] + ' 支，共 ' + smoke['经常吸年'] + ' 年'
                          break
                        }
                        case 2: {
                          let quitTime = '已戒烟 '
                          if (smoke['过去吸年'] === null || smoke['过去吸年'] === 0) {
                            quitTime = quitTime + smoke['过去吸月'] + ' 月'
                          } else {
                            quitTime = quitTime + smoke['过去吸年'] + ' 年 ' + smoke['过去吸月'] + ' 月'
                          }

                          bdtJson['吸烟史']['过去吸，现已戒烟'] = quitTime
                          break
                        }
                        case 3: {
                          bdtJson['吸烟史']['频率'] = '偶吸（平均每天不足1支）'
                          break
                        }
                        default: {
                          break
                        }
                      }
                    }
                  }

                  break
                }

                case '饮酒史': {
                  const drink = bdt[term]
                  bdtJson[term] = {}
                  for (const drinkKey in drink) {
                    if (drinkKey === '频率') {
                      if (drink[drinkKey] === 4) {
                        delete bdtJson[term]
                        break
                      }
                      switch (drink[drinkKey]) {
                        case 1: {
                          let oftenDrink = ''
                          for (const oftenDrinkKey in drink['经常饮']) {
                            switch (oftenDrinkKey) {
                              case '白酒': {
                                if (drink['经常饮']['白酒']['毫升'] > 0) {
                                  oftenDrink += (drink['经常饮']['白酒']['度数'] + '度白酒' + drink['经常饮']['白酒']['毫升'] + 'ml ')
                                }
                                break
                              }
                              case '红酒': {
                                if (drink['经常饮']['红酒'] > 0) {
                                  oftenDrink += ('红酒' + drink['经常饮']['红酒'] + 'ml ')
                                }
                                break
                              }
                              case '啤酒': {
                                if (drink['经常饮']['啤酒'] > 0) {
                                  oftenDrink += ('啤酒' + drink['经常饮']['啤酒'] + 'ml ')
                                }
                                break
                              }
                              case '黄酒': {
                                if (drink['经常饮']['黄酒'] > 0) {
                                  oftenDrink += ('黄酒' + drink['经常饮']['黄酒'] + 'ml ')
                                }
                                break
                              }
                              default: {
                                break
                              }
                            }
                          }
                          bdtJson[term]['经常饮'] = oftenDrink
                          break
                        }
                        case 2: {
                          bdtJson[term]['已戒酒'] = drink['过去饮年'] + ' 年'
                          break
                        }
                        case 3: {
                          bdtJson[term]['偶饮（<1次/周）'] = null
                          break
                        }
                        default: {
                          break
                        }
                      }
                    }
                  }
                  break
                }

                case '体育锻炼史': {
                  const workout = bdt[term]
                  bdtJson[term] = {}
                  for (const workoutKey in workout) {
                    if (workout[workoutKey] === null) {
                      break
                    }

                    if (workoutKey === '频率') {
                      if (workout[workoutKey] === 1) {
                        bdtJson[term]['基本不锻炼'] = null
                        break
                      }

                      const length = ['每次1小时以内', '每次1小时以上']
                      switch (workout[workoutKey]) {
                        case 2: {
                          bdtJson[term]['小于3次/周'] = length[workout['时长']]
                          break
                        }
                        case 3: {
                          bdtJson[term]['大于3次/周'] = length[workout['时长']]
                          break
                        }
                        default: {
                          break
                        }
                      }
                    }
                  }
                  break
                }

                case '心肌梗死': {
                  if (bdt[term]['有无'] === 2) {
                    bdtJson[term] = {}
                    bdtJson[term]['最近发生时间'] = bdt[term]['年月']
                  }
                  break
                }

                case '目前服药': {
                  bdtJson[term] = {}
                  for (const medicineKey in bdt[term]) {
                    if (bdt[term][medicineKey] === true) {
                      bdtJson[term][medicineKey] = null
                    }
                  }
                  if (Object.keys(bdtJson[term]).length === 0) {
                    delete bdtJson[term]
                  }
                  break
                }

                case '其他疾病史': {
                  bdtJson[term] = {}

                  for (const dieaseKey in bdt[term]) {
                    if (dieaseKey === '其它' && bdt[term][dieaseKey] != null && bdt[term][dieaseKey].length > 0) {
                      bdtJson[term][bdt[term][dieaseKey]] = null
                    } else if (bdt[term][dieaseKey] === true) {
                      bdtJson[term][dieaseKey] = null
                    }
                  }

                  if (Object.keys(bdtJson[term]).length === 0) {
                    delete bdtJson[term]
                  }

                  break
                }

                case '家族史': {
                  const family = bdt[term]
                  bdtJson[term] = {}

                  for (const familyKey in family) {
                    switch (familyKey) {
                      case '冠心病家族史': {
                        if (family[familyKey] === null || family[familyKey]['有无'] === 2) {
                          break
                        } else {
                          bdtJson[term]['冠心病家族史'] = {}
                          const famis = family[familyKey]['谁']
                          for (const fami in famis) {
                            if (famis[fami] != null || famis[fami] !== false) {
                              bdtJson[term]['冠心病家族史'][fami] = null
                            }
                          }
                        }
                        break
                      }

                      case '高脂血症家族史': {
                        if (family[familyKey] === 1) {
                          bdtJson[term]['高脂血症家族史'] = null
                        }
                        break
                      }

                      case '其它': {
                        if (family[familyKey] != null && family[familyKey] !== '') {
                          bdtJson[term][family[familyKey]] = null
                        }
                        break
                      }

                      default: {
                        break
                      }
                    }
                  }

                  if (Object.keys(bdtJson[term]).length === 0) {
                    delete bdtJson[term]
                  }

                  break
                }

                default: {
                  bdtJson[term] = bdt[term]
                }
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

