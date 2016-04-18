package com.radiumone.datasciservices.adpred.algorithm;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by broy on 4/14/16.
 */
@Repository
public interface AlgorithmRepository extends CrudRepository<Algorithm, Integer>{
}