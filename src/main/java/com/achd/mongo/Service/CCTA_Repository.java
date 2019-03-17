package com.achd.mongo.Service;

import com.achd.mongo.Entity.CCTA.CCTA;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CCTA_Repository extends MongoRepository<CCTA, String> {
    CCTA findCCTABy编号(String num);

    List<CCTA> findBy编号ContainsOr姓名ContainsAllIgnoreCase(String num, String name);

}
