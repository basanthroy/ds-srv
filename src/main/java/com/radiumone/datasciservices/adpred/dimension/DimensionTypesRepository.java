package com.radiumone.datasciservices.adpred.dimension;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by broy on 4/14/16.
 */
@Repository
public interface DimensionTypesRepository extends CrudRepository<DimensionTypes, Integer>{
}