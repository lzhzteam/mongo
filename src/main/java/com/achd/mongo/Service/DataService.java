package com.achd.mongo.Service;

import com.achd.mongo.Entity.AnalyzeEntity;
import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Entity.BaseEntityCurrent;
import com.achd.mongo.Entity.CCTA.CCTA_Sub.CCTA;
import com.achd.mongo.Entity.WebResponse;
import com.achd.mongo.Utilities.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

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
        // 病因 且 冠状动脉CT异常
        Query query = new Query(Criteria.where(String.format("BDTs.%s", key)).is(value)
                .and("CCTAs.冠状动脉CT是否异常").is(true));
        List<BaseEntity> testData = query_repository.select(query);
        Long testTrue = query_repository.count(query);

        // 病因 且 非冠状动脉CT异常
        query = new Query(Criteria.where(String.format("BDTs.%s", key)).is(value)
                .and("CCTAs.冠状动脉CT是否异常").is(false));
        Long testFalse = query_repository.count(query);

        // 非病因 且 冠状动脉CT异常
        query = new Query(Criteria.where(String.format("BDTs.%s", key)).ne(value)
                .and("CCTAs.冠状动脉CT是否异常").is(true));
        Long controlTrue = query_repository.count(query);

        // 非病因 且 冠状动脉CT异常
        query = new Query(Criteria.where(String.format("BDTs.%s", key)).ne(value)
                .and("CCTAs.冠状动脉CT是否异常").is(false));
        Long controlFalse = query_repository.count(query);

        Long[] position = new Long[18];
        Long[] length = new Long[3];
        Long[] feature = new Long[3];

        for (BaseEntity baseEntity : testData) {
            if (baseEntity.getCCTAs() == null || baseEntity.getCCTAs().isEmpty()) {
                continue;
            }

            CCTA ccta = baseEntity.getCCTAs().get(baseEntity.getCCTAs().size() - 1);
            position[ccta.get病变位置() - 1]++;
            length[ccta.get病变长度() - 1]++;
            feature[ccta.get斑块特征() - 1]++;
        }

        return new AnalyzeEntity(testTrue, testFalse, controlTrue, controlFalse, position, length, feature);
    }
}
