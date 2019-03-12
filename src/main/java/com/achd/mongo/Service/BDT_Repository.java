package com.achd.mongo.Service;

import com.achd.mongo.Entity.BDT.BDT;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BDT_Repository extends MongoRepository<BDT, String> {
    List<BDT> findByNumContainsOrNameContains(String num, String name);

}
