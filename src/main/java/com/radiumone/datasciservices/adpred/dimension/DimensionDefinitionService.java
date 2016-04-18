package com.radiumone.datasciservices.adpred.dimension;

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
 * Created by broy on 4/13/16.
 */
@Controller
@RequestMapping("/dimension")
public class DimensionDefinitionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DimensionDefinitionService.class);

    @Autowired
    private DimensionTypesRepository dimensionTypesRepository;

    @RequestMapping( method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody DimensionTypes create(@RequestBody DimensionTypes dimensionTypes) throws HttpStatusCodeException{

        LOGGER.info("Request received. Payload={}", dimensionTypes);

        if (dimensionTypesRepository.exists(dimensionTypes.getDimensionId())) {
            throw new DimensionExistsException();
        }

        DimensionTypes savedDimensionTypes = dimensionTypesRepository.save(dimensionTypes);

        LOGGER.info("Saved Dimension Type ={}", savedDimensionTypes);

        return savedDimensionTypes;
    }

}