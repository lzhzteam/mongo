package com.achd.mongo.Service;

import com.achd.mongo.Entity.CCTA.CCTA;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CCTA_Repository extends MongoRepository<CCTA, String> {
    CCTA findCCTABy编号(String num);
}
