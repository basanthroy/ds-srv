package com.radiumone.datasciservices.adpred.pom.domainrecommendation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by broy on 10/10/16.
 */
@Repository
public interface DomainRecommendationResultsRepository extends CrudRepository<DomRecResults, Long>{
}