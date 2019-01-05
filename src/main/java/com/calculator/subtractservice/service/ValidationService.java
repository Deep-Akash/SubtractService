package com.calculator.subtractservice.service;

import com.calculator.subtractservice.exceptions.FaultyRequestException;
import com.calculator.subtractservice.exceptions.NumberMissingException;
import com.calculator.subtractservice.model.request.OperationRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by akashdeepnew on 21/12/18.
 */
@Service
public class ValidationService {
    private static final Logger logger = LogManager.getLogger(ValidationService.class);

    public void validateServiceRequest(OperationRequest request) throws Exception {
        if (null == request) {
            throw new FaultyRequestException();
        }
        if (null == request.getFirstNumber()) {
            throw new NumberMissingException();
        }
        if (null == request.getSecondNumber()) {
            throw new NumberMissingException();
        }
    }
}
