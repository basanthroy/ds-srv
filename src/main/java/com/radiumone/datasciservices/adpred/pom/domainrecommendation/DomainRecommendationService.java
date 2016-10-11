package com.radiumone.datasciservices.adpred.pom.domainrecommendation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;

import javax.validation.Valid;

/**
 * Created by broy on 10/10/16.
 */
@Controller
@RequestMapping("/pom/domrec")
public class DomainRecommendationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DomainRecommendationService.class);

    @Autowired
    private DomainRecommendationQueueRepository domainRecommendationQueueRepository;

    @Autowired
    private DomainRecommendationResultsRepository domainRecommendationResultsRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<DomRecQueueEnvelope>
    read(@PathVariable("id") long id) throws HttpStatusCodeException{

        LOGGER.info("Request received. id={}", id);

        DomRecQueue savedDomRecQueue = domainRecommendationQueueRepository.findOne(id);

        LOGGER.info("Retrieved Domain recommendation queue entry ={}", savedDomRecQueue);

        if (savedDomRecQueue == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new DomRecQueueEnvelope(savedDomRecQueue), HttpStatus.OK) ;
    }

    @RequestMapping( method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity
    create(@Valid @RequestBody DomRecQueueEnvelope domRecQueueEnvelope,
           BindingResult result) throws HttpStatusCodeException{

        LOGGER.info("Request received. Payload={}", domRecQueueEnvelope);

        if (result.hasErrors()) {
            LOGGER.error("Validation errors generated. Errors = {}", result.getAllErrors());
            StringBuilder sb = new StringBuilder();
            result.getAllErrors().forEach(e -> sb.append(e));
            return ResponseEntity.badRequest().body(sb.toString());
        }

        DomRecQueue savedDomRecQueue = domainRecommendationQueueRepository.save(domRecQueueEnvelope.getDomRecQueue());

        LOGGER.info("Saved Domain recommendation queue entry ={}", savedDomRecQueue);

        return new ResponseEntity<>(new DomRecQueueEnvelope(savedDomRecQueue), HttpStatus.OK);
    }

    @RequestMapping(value = "/results/{domRecResultId}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity
    getResults(@PathVariable Long domRecResultId) throws HttpStatusCodeException{

        LOGGER.info("Request received. domRecResultId={}", domRecResultId);

        DomRecResults domRecResults = domainRecommendationResultsRepository.findOne(domRecResultId);

        LOGGER.info("Domain recommendation results ={}", domRecResults);

        if (domRecResults == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(domRecResults, HttpStatus.OK);
    }

}