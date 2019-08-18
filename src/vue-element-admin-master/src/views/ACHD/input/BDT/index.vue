<template>
  <div>
    <h1 align="center">冠心病患者基线资料表</h1>
    <el-form ref="bdt" :model="bdt" :rules="rules" label-width="100px" label-position="left" class="input">
      <!-- 基本信息 -->
      <div class="block">
        <el-row>
          <el-form-item label="编号" prop="编号">
            <el-input v-model="bdt.编号" />
          </el-form-item>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="姓名" prop="姓名">
              <el-input v-model="bdt.姓名" />
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="性别" prop="性别" label-width="50px" style="margin-left: 20px;">
              <el-radio-group v-model="bdt.性别">
                <el-radio label="男">男</el-radio>
                <el-radio label="女">女</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="年龄" prop="BDTs[0].年龄" label-width="50px" style="margin-left: 20px;">
              <el-input v-model.number="bdt.BDTs[0].年龄" />
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="检查时间" prop="BDTs[0].检查时间" style="padding-left: 20px;">
              <el-date-picker
                v-model="bdt.BDTs[0].检查时间"
                align="center"
                type="date"
                placeholder="选择日期"
                :picker-options="pickerOptions"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="心率" prop="BDTs[0].心率">
              <el-input v-model.number="bdt.BDTs[0].心率" />
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="血压" prop="BDTs[0].血压" label-width="50px" style="margin-left: 20px;">
              <el-input v-model="bdt.BDTs[0].血压">
                <template slot="suffix">mmHg</template>
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="身高" prop="BDTs[0].身高" label-width="50px" style="margin-left: 20px;">
              <el-input v-model.number="bdt.BDTs[0].身高">
                <template slot="suffix">cm</template>
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="体重" prop="BDTs[0].体重" label-width="50px" style="margin-left: 20px;">
              <el-input v-model.number="bdt.BDTs[0].体重">
                <template slot="suffix">kg</template>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </div>

      <!-- 检查目的 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item />
          </el-col>
          <el-col :span="6">
            <el-form-item label="典型心绞痛" prop="BDTs[0].检查目的.典型心绞痛">
              <el-radio-group v-model="bdt.BDTs[0].检查目的.典型心绞痛">
                <el-radio label="true">是</el-radio>
                <el-radio label="false">否</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="非典型性胸部不适" prop="BDTs[0].检查目的.非典型性胸部不适" label-width="130px">
              <el-radio-group v-model="bdt.BDTs[0].检查目的.非典型性胸部不适">
                <el-radio label="true">是</el-radio>
                <el-radio label="false">否</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="3">
            <el-form-item label="检查目的" />
          </el-col>
          <el-col :span="6">
            <el-form-item label="非胸痛症状" prop="BDTs[0].检查目的.非胸痛症状">
              <el-radio-group v-model="bdt.BDTs[0].检查目的.非胸痛症状">
                <el-radio label="true">是</el-radio>
                <el-radio label="false">否</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="心电图异常" prop="BDTs[0].检查目的.心电图异常" label-width="130px">
              <el-radio-group v-model="bdt.BDTs[0].检查目的.心电图异常">
                <el-radio label="true">是</el-radio>
                <el-radio label="false">否</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="3">
            <el-form-item />
          </el-col>
          <el-col :span="6">
            <el-form-item label="心脏超声异常" prop="BDTs[0].检查目的.心脏超声异常">
              <el-radio-group v-model="bdt.BDTs[0].检查目的.心脏超声异常">
                <el-radio label="true">是</el-radio>
                <el-radio label="false">否</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="其它" prop="BDTs[0].检查目的.其它" label-width="130px">
              <el-input v-model="bdt.BDTs[0].检查目的.其它" />
            </el-form-item>
          </el-col>
        </el-row>
      </div>

      <!-- 高血压病 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item v-if="bdt.BDTs[0].高血压病.有无 === '3'" />
            <el-form-item v-else label="高血压病" />
          </el-col>
          <el-col :span="21">
            <el-form-item prop="BDTs[0].高血压病.有无" label-width="0">
              <el-radio-group v-model="bdt.BDTs[0].高血压病.有无">
                <el-radio label="1">不详</el-radio>
                <el-radio label="2">无</el-radio>
                <el-radio label="3">有</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <span v-if="bdt.BDTs[0].高血压病.有无 === '3'">
          <el-row>
            <el-col :span="3">
              <el-form-item label="高血压病" />
            </el-col>
            <el-col :span="21">
              <el-form-item label="目前用药" prop="BDTs[0].高血压病.目前用药" label-width="120px">
                <el-radio-group v-model="bdt.BDTs[0].高血压病.目前用药">
                  <el-radio label="1">ACEI 或 ARB</el-radio>
                  <el-radio label="2">钙离子拮抗剂</el-radio>
                  <el-radio label="3">利尿剂</el-radio>
                  <el-radio label="4">受体阻滞剂</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="3">
              <el-form-item />
            </el-col>
            <el-col :span="21">
              <el-form-item label="用药后达标情况" prop="BDTs[0].高血压病.用药后达标情况" label-width="120px">
                <el-radio-group v-model="bdt.BDTs[0].高血压病.用药后达标情况">
                  <el-radio label="1">达标</el-radio>
                  <el-radio label="2">不达标</el-radio>
                  <el-radio label="3">不稳定</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
        </span>
      </div>

      <!-- 血脂异常 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item v-if="bdt.BDTs[0].血脂异常.有无 === '3'" />
            <el-form-item v-else label="血脂异常" />
          </el-col>
          <el-col :span="21">
            <el-form-item prop="BDTs[0].血脂异常.有无" label-width="0">
              <el-radio-group v-model="bdt.BDTs[0].血脂异常.有无">
                <el-radio label="1">不详</el-radio>
                <el-radio label="2">无</el-radio>
                <el-radio label="3">有</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <span v-if="bdt.BDTs[0].血脂异常.有无 === '3'">
          <el-row>
            <el-col :span="3">
              <el-form-item label="血脂异常" />
            </el-col>
            <el-col :span="21">
              <el-form-item label="目前用药" prop="BDTs[0].血脂异常.目前用药" label-width="120px">
                <el-radio-group v-model="bdt.BDTs[0].血脂异常.目前用药">
                  <el-radio label="1">他汀类药物</el-radio>
                  <el-radio label="2">贝特类药物</el-radio>
                  <el-radio label="3">依折麦布</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="3">
              <el-form-item />
            </el-col>
            <el-col :span="21">
              <el-form-item label="用药后控制情况" prop="BDTs[0].血脂异常.用药后控制情况" label-width="120px">
                <el-radio-group v-model="bdt.BDTs[0].血脂异常.用药后控制情况">
                  <el-radio label="1">正常</el-radio>
                  <el-radio label="2">仍不正常</el-radio>
                  <el-radio label="3">部分正常</el-radio>
                  <el-radio label="4">不稳定</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
        </span>
      </div>

      <!-- 糖尿病史 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item v-if="bdt.BDTs[0].糖尿病史.有无 === '3'" />
            <el-form-item v-else label="糖尿病史" />
          </el-col>
          <el-col :span="6">
            <el-form-item prop="BDTs[0].糖尿病史.有无" label-width="0">
              <el-radio-group v-model="bdt.BDTs[0].糖尿病史.有无">
                <el-radio label="1">不详</el-radio>
                <el-radio label="2">无</el-radio>
                <el-radio label="3">有</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col v-if="bdt.BDTs[0].糖尿病史.有无 === '3'" :span="15">
            <el-form-item label="分型" prop="BDTs[0].糖尿病史.分型">
              <el-radio-group v-model="bdt.BDTs[0].糖尿病史.分型">
                <el-radio label="1">1型</el-radio>
                <el-radio label="2">2型</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <span v-if="bdt.BDTs[0].糖尿病史.有无 === '3'">
          <el-row>
            <el-col :span="3">
              <el-form-item label="糖尿病史" />
            </el-col>
            <el-col :span="21">
              <el-form-item label="目前用药" prop="BDTs[0].糖尿病史.目前用药" label-width="120px">
                <el-radio-group v-model="bdt.BDTs[0].糖尿病史.目前用药">
                  <el-radio label="1">胰岛素</el-radio>
                  <el-radio label="2">二甲双胍</el-radio>
                  <el-radio label="3">磺脲类药物</el-radio>
                  <el-radio label="4">GLP-1 类似物</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="3">
              <el-form-item />
            </el-col>
            <el-col :span="21">
              <el-form-item label="用药后控制情况" prop="BDTs[0].糖尿病史.用药后控制情况" label-width="120px">
                <el-radio-group v-model="bdt.BDTs[0].糖尿病史.用药后控制情况">
                  <el-radio label="1">正常</el-radio>
                  <el-radio label="2">不正常</el-radio>
                  <el-radio label="3">不稳定</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
        </span>
      </div>

      <!-- 脑卒中病史 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item v-if="bdt.BDTs[0].脑卒中病史.有无 === '3'" />
            <el-form-item v-else label="脑卒中病史" />
          </el-col>
          <el-col :span="6">
            <el-form-item prop="BDTs[0].脑卒中病史.有无" label-width="0">
              <el-radio-group v-model="bdt.BDTs[0].脑卒中病史.有无">
                <el-radio label="1">不详</el-radio>
                <el-radio label="2">无</el-radio>
                <el-radio label="3">有</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <span v-if="bdt.BDTs[0].脑卒中病史.有无 === '3'">
          <el-row>
            <el-col :span="3">
              <el-form-item label="糖尿病史" />
            </el-col>
            <el-col :span="9">
              <el-form-item label="发生时间" prop="BDTs[0].脑卒中病史.发生时间">
                <el-date-picker v-model="bdt.BDTs[0].脑卒中病史.发生时间" type="month" />
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="发生部位" prop="BDTs[0].脑卒中病史.发生部位">
                <el-input v-model="bdt.BDTs[0].脑卒中病史.发生部位" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="3">
              <el-form-item />
            </el-col>
            <el-col :span="21">
              <el-form-item prop="BDTs[0].脑卒中病史.类型" label-width="0">
                <el-radio-group v-model="bdt.BDTs[0].脑卒中病史.类型">
                  <el-radio label="1">缺血性卒中</el-radio>
                  <el-radio label="2">出血性卒中</el-radio>
                  <el-radio label="3">TIA 发作</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
        </span>
      </div>

      <!-- 外周血管病 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item v-if="bdt.BDTs[0].外周血管病.有无 === '3'" />
            <el-form-item v-else label="外周血管病" />
          </el-col>
          <el-col :span="6">
            <el-form-item prop="BDTs[0].外周血管病.有无" label-width="0">
              <el-radio-group v-model="bdt.BDTs[0].外周血管病.有无">
                <el-radio label="1">不详</el-radio>
                <el-radio label="2">无</el-radio>
                <el-radio label="3">有</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <span v-if="bdt.BDTs[0].外周血管病.有无 === '3'">
          <el-row>
            <el-col :span="3">
              <el-form-item label="外周血管病" />
            </el-col>
            <el-col :span="21">
              <el-form-item label="发生时间" prop="BDTs[0].外周血管病.发生时间">
                <el-date-picker v-model="bdt.BDTs[0].外周血管病.发生时间" type="month" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="3">
              <el-form-item />
            </el-col>
            <el-col :span="6">
              <el-form-item label="发生部位" prop="BDTs[0].外周血管病.发生部位">
                <el-input v-model="bdt.BDTs[0].外周血管病.发生部位" />
              </el-form-item>
            </el-col>
            <el-col :span="15">
              <el-form-item prop="BDTs[0].外周血管病.类型" label-width="20px">
                <el-radio-group v-model="bdt.BDTs[0].外周血管病.类型">
                  <el-radio label="1">静脉</el-radio>
                  <el-radio label="2">动脉</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
        </span>
      </div>

      <!-- 吸烟史 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item />
          </el-col>
          <el-col :span="2">
            <el-form-item label-width="0">
              <el-radio v-model="bdt.BDTs[0].吸烟史.频率" label="1">经常吸</el-radio>
            </el-form-item>
          </el-col>
          <el-col v-if="bdt.BDTs[0].吸烟史.频率 === '1'" :span="19">
              <el-form-item label-width="0">
                <span>（每日</span>
                <el-input v-model="bdt.BDTs[0].吸烟史.经常吸支数" style="width: 100px;" />
                <span>支，共</span>
                <el-input v-model="bdt.BDTs[0].吸烟史.经常吸年" style="width: 100px;"/>
                <span>年）</span>
              </el-form-item>
            </el-col>
        </el-row>
        <el-row>
          <el-col :span="3">
            <el-form-item label="吸烟史" />
          </el-col>
          <el-col :span="3">
            <el-form-item label-width="0">
              <el-radio v-model="bdt.BDTs[0].吸烟史.频率" label="3">过去吸，现已戒烟</el-radio>
            </el-form-item>
          </el-col>
          <el-col v-if="bdt.BDTs[0].吸烟史.频率 === '3'" :span="18">
              <el-form-item label-width="0">
                <span>（戒烟</span>
                <el-input v-model="bdt.BDTs[0].吸烟史.过去吸年" style="width: 100px" />
                <span>年</span>
                <span v-if="bdt.BDTs[0].吸烟史.过去吸年 === null || bdt.BDTs[0].吸烟史.过去吸年 === ''">
                  <span>，如不满一年</span>
                  <el-input v-model="bdt.BDTs[0].吸烟史.过去吸月" style="width: 100px" />
                  <span>月）</span>
                </span>
                <span v-else>）</span>
              </el-form-item>
            </el-col>

        </el-row>
        <el-row>
          <el-col :span="3">
            <el-form-item />
          </el-col>
          <el-col :span="4">
            <el-form-item label-width="0">
              <el-radio v-model="bdt.BDTs[0].吸烟史.频率" label="2">偶吸（平均每天不足1支）</el-radio>
            </el-form-item>
          </el-col>
          <el-col :span="3">
            <el-form-item label-width="0">
              <el-radio v-model="bdt.BDTs[0].吸烟史.频率" label="4">从不吸</el-radio>
            </el-form-item>
          </el-col>
        </el-row>
      </div>

      <!-- 饮酒史 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item />
          </el-col>
          <el-col :span="3">
            <el-form-item label-width="0">
              <el-radio v-model="bdt.BDTs[0].饮酒史.频率" label="1">经常饮</el-radio>
            </el-form-item>
          </el-col>
            <el-col v-if="bdt.BDTs[0].饮酒史.频率 === '1'" :span="18">
              <el-form-item label-width="0">
                <span>白酒</span>
                <el-input v-model="bdt.BDTs[0].饮酒史.经常饮.白酒.毫升" style="width: 100px;" />
                <span>mL/次，度数</span>
                <el-input v-model="bdt.BDTs[0].饮酒史.经常饮.白酒.度数" style="width: 100px;" />
                <span>度</span>
              </el-form-item>
            </el-col>
        </el-row>
        <span v-if="bdt.BDTs[0].饮酒史.频率 === '1'">
          <el-row>
            <el-col :span="6">
              <el-form-item />
            </el-col>
            <el-col v-if="bdt.BDTs[0].饮酒史.频率 === '1'" :span="18">
              <el-form-item label-width="0">
                <span>红酒</span>
                <el-input v-model="bdt.BDTs[0].饮酒史.经常饮.红酒" style="width: 100px;" />
                <span>mL/次</span>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item />
            </el-col>
            <el-col v-if="bdt.BDTs[0].饮酒史.频率 === '1'" :span="18">
              <el-form-item label-width="0">
                <span>啤酒</span>
                <el-input v-model="bdt.BDTs[0].饮酒史.经常饮.啤酒" style="width: 100px;" />
                <span>mL/次</span>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item />
            </el-col>
            <el-col v-if="bdt.BDTs[0].饮酒史.频率 === '1'" :span="18">
              <el-form-item label-width="0">
                <span>黄酒</span>
                <el-input v-model="bdt.BDTs[0].饮酒史.经常饮.黄酒" style="width: 100px;" />
                <span>mL/次</span>
              </el-form-item>
            </el-col>
          </el-row>
        </span>
        <el-row>
          <el-col :span="3">
            <el-form-item label="饮酒史" />
          </el-col>
          <el-col :span="1.5">
            <el-form-item label-width="0">
              <el-radio v-model="bdt.BDTs[0].饮酒史.频率" label="3">过去饮</el-radio>
            </el-form-item>
          </el-col>
            <el-col v-if="bdt.BDTs[0].饮酒史.频率 === '3'" :span="18">
              <el-form-item label-width="0">
                <span>（戒酒</span>
                <el-input v-model="bdt.BDTs[0].吸烟史.过去饮年" style="width: 100px;"/>
                <spa>年）</spa>
              </el-form-item>
            </el-col>
        </el-row>
        <el-row>
          <el-col :span="3">
            <el-form-item />
          </el-col>
          <el-col :span="4">
            <el-form-item label-width="0">
              <el-radio v-model="bdt.BDTs[0].饮酒史.频率" label="2">偶饮（<1次/周）</el-radio>
            </el-form-item>
          </el-col>
          <el-col :span="3">
            <el-form-item label-width="0">
              <el-radio v-model="bdt.BDTs[0].饮酒史.频率" label="4">从不饮</el-radio>
            </el-form-item>
          </el-col>
        </el-row>

      </div>

      <!-- 体育锻炼史 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item label="体育锻炼史" />
          </el-col>
          <el-col :span="9">
            <el-form-item label-width="0">
              <el-radio-group v-model="bdt.BDTs[0].体育锻炼史.频率">
                <el-radio label="1">基本不锻炼</el-radio>
                <el-radio label="2"><3次/周</el-radio>
                <el-radio label="3">>=3次/周</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col v-if="bdt.BDTs[0].体育锻炼史.频率 === '2' || bdt.BDTs[0].体育锻炼史.频率 === '3'" :span="6">
            <el-form-item label="每次锻炼时间">
              <el-radio-group v-model="bdt.BDTs[0].体育锻炼史.时长">
                <el-radio label="1"><1小时/次</el-radio>
                <el-radio label="2">>=1小时/次</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
      </div>

      <!-- 心肌梗死 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item label="心肌梗死" />
          </el-col>
          <el-col :span="6">
            <el-form-item label-width="0">
              <el-radio-group v-model="bdt.BDTs[0].心肌梗死.有无">
                <el-radio label="1">无</el-radio>
                <el-radio label="2">有</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col v-if="bdt.BDTs[0].心肌梗死.有无 === '2'" :span="6">
            <el-form-item label="最近一次心梗时间" label-width="150px">
              <el-date-picker v-model="bdt.BDTs[0].心肌梗死.年月" type="month" />
            </el-form-item>
          </el-col>
        </el-row>
      </div>

      <!-- 目前服药 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item label="目前服药" />
          </el-col>
          <el-col :span="21">
            <el-form-item label-width="0">
              <el-checkbox v-model="bdt.BDTs[0].目前服药.阿司匹林">阿司匹林</el-checkbox>
              <el-checkbox v-model="bdt.BDTs[0].目前服药.硫酸氢氯吡格雷">硫酸氢氯吡格雷</el-checkbox>
              <el-checkbox v-model="bdt.BDTs[0].目前服药.硝酸酯类药物">硝酸酯类药物</el-checkbox>
              <el-checkbox v-model="bdt.BDTs[0].目前服药.华法林等抗凝药">华法林等抗凝药</el-checkbox>
            </el-form-item>
          </el-col>
        </el-row>
      </div>

      <!-- 其他疾病史 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item label="其他疾病史" />
          </el-col>
          <el-col :span="6">
            <el-form-item label-width="0">
              <el-checkbox v-model="bdt.BDTs[0].目前服药.肝功能不全">肝功能不全</el-checkbox>
              <el-checkbox v-model="bdt.BDTs[0].目前服药.肾功能不全">肾功能不全</el-checkbox>
              <el-checkbox v-model="bdt.BDTs[0].目前服药.肿瘤">肿瘤</el-checkbox>
            </el-form-item>
          </el-col>
          <el-col :span="15">
            <el-form-item>
              <span>其它</span>
              <el-input v-model="bdt.BDTs[0].目前服药.其它" style="width: 300px;"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </div>

      <!-- 家族史 -->
      <div class="block">
        <el-row>
          <el-col :span="3">
            <el-form-item />
          </el-col>
          <el-col :span="6">
            <el-form-item label="冠心病家族史" label-width="150px">
              <el-radio-group v-model="bdt.BDTs[0].家族史.冠心病家族史.有无">
                <el-radio label="1">是</el-radio>
                <el-radio label="2">否</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <span v-if="bdt.BDTs[0].家族史.冠心病家族史.有无 === '1'">
            <el-col :span="1">
            <el-form-item label-width="0px">
              <el-checkbox v-model="checkbox.father">父有</el-checkbox>
            </el-form-item>
          </el-col>
            <el-col v-if="checkbox.father" :span="6">
            <el-form-item label-width="0px">
              <span>(发病年龄</span>
              <el-input v-model="bdt.BDTs[0].家族史.冠心病家族史.谁.父亲" style="width: 100px" />
              <span>岁)</span>
            </el-form-item>
          </el-col>
          </span>
        </el-row>
        <span v-if="bdt.BDTs[0].家族史.冠心病家族史.有无 === '1'">
          <el-row>
            <el-col :span="9">
              <el-form-item />
            </el-col>
            <el-col :span="1">
              <el-form-item label-width="0px">
                <el-checkbox v-model="checkbox.mother">母有</el-checkbox>
              </el-form-item>
            </el-col>
            <el-col v-if="checkbox.mother" :span="6">
              <el-form-item label-width="0px">
                <span>(发病年龄</span>
                <el-input v-model="bdt.BDTs[0].家族史.冠心病家族史.谁.母亲" style="width: 100px" />
                <span>岁)</span>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="9">
              <el-form-item />
            </el-col>
            <el-col :span="2">
              <el-form-item label-width="0px">
                <el-checkbox v-model="checkbox.brother">兄弟姐妹有</el-checkbox>
              </el-form-item>
            </el-col>
            <el-col v-if="checkbox.brother" :span="6">
              <el-form-item label-width="0px">
                <span>(最小发病年龄</span>
                <el-input v-model="bdt.BDTs[0].家族史.冠心病家族史.谁.兄弟姐妹" style="width: 100px" />
                <span>岁)</span>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="9">
              <el-form-item />
            </el-col>
            <el-col :span="1.5">
              <el-form-item label-width="0px">
                <el-checkbox v-model="checkbox.child">子女有</el-checkbox>
              </el-form-item>
            </el-col>
            <el-col v-if="checkbox.child" :span="6">
              <el-form-item label-width="0px">
                <span>(最小发病年龄</span>
                <el-input v-model="bdt.BDTs[0].家族史.冠心病家族史.谁.子女" style="width: 100px" />
                <span>岁)</span>
              </el-form-item>
            </el-col>
          </el-row>
        </span>
        <el-row>
          <el-col :span="3">
            <el-form-item label="家族史" />
          </el-col>
          <el-col :span="6">
            <el-form-item label="高脂血症家族史" label-width="150px">
              <el-radio-group v-model="bdt.BDTs[0].家族史.高脂血症家族史">
                <el-radio label="1">是</el-radio>
                <el-radio label="2">否</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="3">
            <el-form-item />
          </el-col>
          <el-col :span="6">
            <el-form-item label="其它" label-width="150px">
              <el-input v-model="bdt.BDTs[0].家族史.其它" />
            </el-form-item>
          </el-col>
        </el-row>
      </div>
    </el-form>
    <div align="center" style="margin: 20px">
      <el-button type="primary" :loading="loading" @click="submit">提交</el-button>
      <el-button type="primary" @click="reset">重置</el-button>
    </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      loading: false,
      bdt: {
        编号: null,
        姓名: null,
        性别: '男',
        BDTs: [{
          年龄: null,
          检查时间: new Date(),
          心率: null,
          血压: null,
          身高: null,
          体重: null,
          检查目的: {
            典型心绞痛: 'false',
            非典型性胸部不适: 'false',
            非胸痛症状: 'false',
            心电图异常: 'false',
            心脏超声异常: 'false',
            其它: null
          },
          高血压病: {
            有无: null,
            目前用药: null,
            用药后达标情况: null
          },
          血脂异常: {
            有无: null,
            目前用药: null,
            用药后控制情况: null
          },
          糖尿病史: {
            有无: null,
            分型: null,
            目前用药: null,
            用药后控制情况: null
          },
          脑卒中病史: {
            有无: null,
            发生时间: null,
            发生部位: null,
            类型: null
          },
          外周血管病: {
            有无: null,
            发生时间: null,
            发生部位: null,
            类型: null
          },
          吸烟史: {
            频率: null,
            经常吸支数: null,
            经常吸年: null,
            过去吸年: null,
            过去吸月: null
          },
          饮酒史: {
            频率: null,
            经常饮: {
              白酒: {
                毫升: null,
                度数: null
              },
              红酒: null,
              啤酒: null,
              黄酒: null
            },
            过去饮年: null
          },
          体育锻炼史: {
            频率: null,
            时长: null
          },
          心肌梗死: {
            有无: null,
            年月: null
          },
          目前服药: {
            阿司匹林: false,
            硫酸氢氯吡格雷: false,
            硝酸酯类药物: false,
            华法林等抗凝药: false
          },
          其他疾病史: {
            肝功能不全: 'false',
            肾功能不全: 'false',
            肿瘤: 'false',
            其它: null
          },
          家族史: {
            冠心病家族史: {
              有无: null,
              谁: {
                父亲: null,
                母亲: null,
                兄弟姐妹: null,
                子女: null
              }
            },
            高脂血症家族史: null,
            其它: null
          }
        }]
      },
      checkbox: {
        father: false,
        mother: false,
        brother: false,
        child: false
      },
      rules: {
        编号: [{ required: true, message: '编号不能为空' }],
        姓名: [{ required: true, message: '姓名不能为空' }],
        'BDTs[0].年龄': [
          { required: true, message: '年龄不能为空' },
          { type: 'number', message: '年龄必须为数字' }
        ],
        'BDTs[0].心率': [
          { required: true, message: '心率不能为空' },
          { type: 'number', message: '心率必须为数字' }
        ],
        'BDTs[0].血压': [{ required: true, message: '血压不能为空' }],
        'BDTs[0].身高': [
          { required: true, message: '身高不能为空' },
          { type: 'number', message: '身高必须为数字' }
        ],
        'BDTs[0].体重': [
          { required: true, message: '体重不能为空' },
          { type: 'number', message: '体重必须为数字' }
        ]
      }
    }
  },
  mounted() {

  },
  methods: {
    submit() {
      console.info(this.bdt.BDTs[0].血压)
    }
  }
}
</script>

<style lang="scss" scoped>
  .block {
    border-bottom: 1px solid #d2d6de;
    padding-top: 15px;
    padding-left: 30px;
    padding-right: 30px;
  }

  .input /deep/ {
    .el-input__inner {
      padding-right: 40px;
      resize: none;
      border: none;
      border-radius: 0px;
      border-bottom: 1px solid #bfcbd9;
    }

    .el-input__inner:focus {
      padding-right: 40px;
      resize: none;
      border: none;
      border-radius: 0px;
      border-bottom: 1px solid #0011ff;
    }
  }
</style>
