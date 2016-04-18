package com.radiumone.datasciservices.arte.app.enqueue;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by broy on 4/19/16.
 */
@Repository
public interface EnqueueRepository extends CrudRepository<Enqueue, Integer>{
}