package com.achd.mongo.Service;

import com.achd.mongo.Entity.AnalyzeEntity;
import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Entity.BaseEntityCurrent;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTA;
import com.achd.mongo.Entity.WebResponse;
import com.achd.mongo.Utilities.NumberUtils;
import com.achd.mongo.Utilities.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Random;

@Service
public class DataService {

    @Autowired
    private Query_Repository query_repository;

    @Autowired
    private BaseEntity_Repository baseEntity_repository;

    @Autowired
    private BaseEntityCurrent_Repository baseEntityCurrent_repository;

    public WebResponse insert(BaseEntity baseEntity) {
        try {
            BaseEntity hadBaseEntity = baseEntity_repository.findBaseEntitiyBy编号(baseEntity.get编号());
            if (hadBaseEntity == null) {
                baseEntity_repository.save(baseEntity);
                BaseEntityCurrent baseEntityCurrent = new BaseEntityCurrent(
                        baseEntity.get编号(), baseEntity.get姓名(), baseEntity.get性别(),
                        baseEntity.getBDTs() == null || baseEntity.getBDTs().isEmpty() ? null : baseEntity.getBDTs().get(baseEntity.getBDTs().size() - 1),
                        baseEntity.getCCTAs() == null || baseEntity.getCCTAs().isEmpty() ? null : baseEntity.getCCTAs().get(baseEntity.getCCTAs().size() - 1)
                );
                baseEntityCurrent_repository.save(baseEntityCurrent);
                return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.SUCCESS);
            }

            if (!hadBaseEntity.get姓名().equals(baseEntity.get姓名())) {
                String data = String.format("编号%s对应的人应为 %s(%s), 请核对信息",
                        hadBaseEntity.get编号(), hadBaseEntity.get姓名(), hadBaseEntity.get性别());
                return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.NAME_ERROR, data);
            }

            if (!hadBaseEntity.get性别().equals(baseEntity.get性别())) {
                String data = String.format("编号%s对应的人应为 %s(%s), 请核对信息",
                        hadBaseEntity.get编号(), hadBaseEntity.get姓名(), hadBaseEntity.get性别());
                return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.GENDER_ERROR, data);
            }

            hadBaseEntity.addCCTAs(baseEntity.getCCTAs());
            hadBaseEntity.addBDTs(baseEntity.getBDTs());
            baseEntity_repository.save(hadBaseEntity);

            BaseEntityCurrent original = baseEntityCurrent_repository.findBy编号(hadBaseEntity.get编号());
            original.setBdt(hadBaseEntity.getBDTs() == null || hadBaseEntity.getBDTs().isEmpty() ? null : hadBaseEntity.getBDTs().get(hadBaseEntity.getBDTs().size() - 1));
            original.setCcta(hadBaseEntity.getCCTAs() == null || hadBaseEntity.getCCTAs().isEmpty() ? null : hadBaseEntity.getCCTAs().get(hadBaseEntity.getCCTAs().size() - 1));
            baseEntityCurrent_repository.save(original);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.SERVER_FAIL);
        }

        return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.SUCCESS);
    }

    public WebResponse search(String searchCondition) {
        List<BaseEntity> result;
        try {
            result = baseEntity_repository.findBy编号ContainsOr姓名ContainsIgnoreCase(
                    searchCondition, searchCondition);
        } catch (Exception e) {
            return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.SERVER_FAIL);
        }

        return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.SUCCESS, result);
    }

    public AnalyzeEntity analyze(String key, Object value) {
        String bingyin = String.format("bdt.%s", key);
        String guanxinbing = "ccta.冠状动脉CT是否异常";

        // 病因 且 冠状动脉CT异常
        Query query = new Query(Criteria.where(bingyin).is(value)
                .and(guanxinbing).is(true));
        List<BaseEntityCurrent> testData = query_repository.select(query);
        Long testTrue = query_repository.count(query);

        // 病因 且 非冠状动脉CT异常
        query = new Query(Criteria.where(bingyin).is(value)
                .and(guanxinbing).is(false));
        Long testFalse = query_repository.count(query);

        Long testTotal = testTrue + testFalse;
        Double testRate = testTotal == 0 ? 0.0 : NumberUtils.getTwoDecimalPlace(((double)testTrue / (double)testTotal) * 100.0);

        // 非病因 且 冠状动脉CT异常
        query = new Query(Criteria.where(bingyin).ne(value)
                .and(guanxinbing).is(true));
        Long controlTrue = query_repository.count(query);

        // 非病因 且 冠状动脉CT异常
        query = new Query(Criteria.where(bingyin).ne(value)
                .and(guanxinbing).is(false));
        Long controlFalse = query_repository.count(query);

        Long controlTotal = controlTrue + controlFalse;
        Double controlRate = controlTotal == 0 ? 0.0 :NumberUtils.getTwoDecimalPlace( ((double)controlTrue / (double)controlTotal) * 100.0);

        String scale = NumberUtils.getScale(testTrue, controlTrue);
        Double RR = controlRate == 0 ? 0.0 : NumberUtils.getTwoDecimalPlace(testRate/controlRate);
        Double AR = testRate - controlRate;
        Double PAR = 0.0102 - controlRate;

        Long[] position = {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L};
        Long[] length = {0L, 0L, 0L};
        Long[] feature = {0L, 0L, 0L};

        for (BaseEntityCurrent baseEntityCurrent : testData) {
            CCTA ccta = baseEntityCurrent.getCcta();
            if (ccta == null || !ccta.get冠状动脉CT是否异常()) {
                continue;
            }
            position[ccta.get病变位置() - 1]++;
            length[ccta.get病变长度() - 1]++;
            feature[ccta.get斑块特征() - 1]++;
        }

        return new AnalyzeEntity(testTrue, testFalse, testTotal, testRate,
                controlTrue, controlFalse, controlTotal, controlRate,
                scale, RR, AR, PAR, position, length, feature);
    }

    public AnalyzeEntity analyze() {
        String guanxinbing = "ccta.冠状动脉CT是否异常";

        Query query = new Query(Criteria.where(guanxinbing).is(true));
        List<BaseEntityCurrent> datas = query_repository.select(query);

        Long[] position = {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L};
        Long[] length = {0L, 0L, 0L};
        Long[] feature = {0L, 0L, 0L};

        for (BaseEntityCurrent baseEntityCurrent : datas) {
            CCTA ccta = baseEntityCurrent.getCcta();
            if (ccta == null || !ccta.get冠状动脉CT是否异常()) {
                continue;
            }
            position[ccta.get病变位置() - 1]++;
            length[ccta.get病变长度() - 1]++;
            feature[ccta.get斑块特征() - 1]++;
        }

        return new AnalyzeEntity(0L, 0L, 0L, 0.0,
                0L, 0L, 0L, 0.0,
                "", 0.0, 0.0, 0.0,
                position, length, feature);

    }

    public AnalyzeEntity getTestData() {
        Random random = new Random();

        // 总人数 200000
        int total = 200000;

        // 实验组人数 100000-200000
        int testTotal = random.nextInt(100000) + 100000;
        int testTrue =random.nextInt(testTotal);
        int testFalse = testTotal - testTrue;
        double testRate = NumberUtils.getTwoDecimalPlace((double)testTrue/(double)testTotal);

        // 对照组人数
        int controlTotal = total - testTotal;
        int controlTrue = random.nextInt(controlTotal);
        int controlFalse = controlTotal - controlTrue;
        double controlRate = NumberUtils.getTwoDecimalPlace((double)controlTrue/(double)controlTotal);

        String scale = NumberUtils.getScale((long) testTrue, (long) controlTrue);
        double RR = controlRate == 0 ? 0.0 : NumberUtils.getTwoDecimalPlace(testRate/controlRate);
        double AR = testRate - controlRate;
        double PAR = 0.0102 - controlRate;

        Long[] position = {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L};
        Long positionTotal = (long) testTotal;
        for (int i = 0; i < 17; i++) {
            position[i] = (long) random.nextInt(Math.toIntExact(positionTotal));
            positionTotal -= position[i];
        }
        position[17] = positionTotal;

        Long[] length = {0L, 0L, 0L};
        Long[] feature = {0L, 0L, 0L};
        Long lengthTotal = (long) testTotal;
        Long featureTotal = (long) testTotal;
        for (int i = 0; i < 2; i++) {
            length[i] = (long) random.nextInt(Math.toIntExact(lengthTotal));
            lengthTotal -= length[i];
            feature[i] = (long) random.nextInt(Math.toIntExact(featureTotal));
            featureTotal -= feature[i];
        }
        length[2] = lengthTotal;
        feature[2] = featureTotal;

        return new AnalyzeEntity((long) testTrue, (long) testFalse, (long) testTotal, testRate,
                (long) controlTrue, (long) controlFalse, (long) controlTotal, controlRate,
                scale, RR, AR, PAR, position, length, feature);
    }
}
