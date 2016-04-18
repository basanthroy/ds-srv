package com.radiumone.datasciservices.adpred.dimension;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by broy on 4/18/16.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Dimension already exists")
public class DimensionExistsException extends RuntimeException {
}
