package com.radiumone.datasciservices.arte.app.enqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * Created by broy on 4/19/16.
 */
@Controller
@RequestMapping("/arte/app/enqueue")
public class EnqueueService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnqueueService.class);

    @Autowired
    private EnqueueRepository enqueueRepository;

    @RequestMapping( method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Enqueue create(@RequestBody Enqueue enqueue) throws HttpStatusCodeException{

        LOGGER.info("Request received. Payload={}", enqueue);

        enqueue.populateDefaultValues();
        Enqueue savedEnqueueRequest = enqueueRepository.save(enqueue);

        LOGGER.info("Saved Enqueue request ={}", savedEnqueueRequest);

        return savedEnqueueRequest;
    }

}