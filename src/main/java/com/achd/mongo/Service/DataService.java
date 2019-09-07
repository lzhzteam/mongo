package com.achd.mongo.Service;

import com.achd.mongo.Entity.BaseEntity;
import com.achd.mongo.Entity.WebResponse;
import com.achd.mongo.Utilities.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private BaseEntity_Repository baseEntity_repository;

    public WebResponse insert(BaseEntity baseEntity) {
        try {
            BaseEntity hadBaseEntity = baseEntity_repository.findBaseEntitiyBy编号(baseEntity.get编号());
            if (hadBaseEntity == null) {
                baseEntity_repository.save(baseEntity);
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
                    searchCondition,searchCondition);
        } catch (Exception e) {
            return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.SERVER_FAIL);
        }

        return ResponseUtils.getResponse(ResponseUtils.ResponseMessage.SUCCESS, result);
    }
}
