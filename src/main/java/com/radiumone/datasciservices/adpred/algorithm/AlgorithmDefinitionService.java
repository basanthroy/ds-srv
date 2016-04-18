package com.radiumone.datasciservices.adpred.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by broy on 4/13/16.
 */
@Controller
@RequestMapping("/algorithm")
public class AlgorithmDefinitionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlgorithmDefinitionService.class);

    @Autowired
    private AlgorithmRepository algorithmRepository;

    @Autowired
    private AlgorithmDetailsRepository algorithmDetailsRepository;

    @Autowired
    private AlgorithmDimensionsRepository algorithmDimensionsRepository;

    @RequestMapping( method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody AlgorithmDetails create(@RequestBody AlgorithmDetails algorithmDetails) throws HttpStatusCodeException{

        LOGGER.info("Request received. Payload={}", algorithmDetails);

        if (algorithmDetailsRepository.exists(algorithmDetails.getAlgoId())) {
            throw new AlgorithmExistsException();
        }

        AlgorithmDetails savedAlgoDetails = algorithmDetailsRepository.save(algorithmDetails);
        algorithmRepository.save(convertAlgorithmDetailsToAlgorithm.apply(algorithmDetails));

        List<AlgorithmDimensions> algorithmDimensionsList = new ArrayList<>();
        algorithmDetails
                .getDimensionTypeIds()
                .forEach(algoDim -> algorithmDimensionsList.add(new AlgorithmDimensions(algorithmDetails.getAlgoId(), algoDim.toString())));
        algorithmDimensionsRepository.save(algorithmDimensionsList);

        LOGGER.info("Saved Algorithm ={}", savedAlgoDetails);

        return savedAlgoDetails;
    }

    private Function<AlgorithmDetails, Algorithm> convertAlgorithmDetailsToAlgorithm
            = algorithmDetails -> new Algorithm(algorithmDetails.getAlgoId(), algorithmDetails.getAlgoName());

}