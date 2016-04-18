package com.radiumone.datasciservices.adpred.algorithm;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by broy on 4/15/16.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Algorithm already exists")
public class AlgorithmExistsException extends RuntimeException {
}
