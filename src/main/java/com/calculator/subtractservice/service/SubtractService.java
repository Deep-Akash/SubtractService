package com.calculator.subtractservice.service;

import com.calculator.subtractservice.model.request.OperationRequest;
import com.calculator.subtractservice.model.response.OperationResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by akashdeepnew on 20/12/18.
 */
@Service
public class SubtractService {

    @Autowired
    private PropertyProviderService propertyProviderService;

    public OperationResultResponse subtract(OperationRequest request) {
        BigDecimal result = add(request.getFirstNumber(),request.getSecondNumber());
        return new OperationResultResponse(result,getCreditCost());
    }

    private BigDecimal add(BigDecimal first, BigDecimal second) {
        return first.subtract(second);
    }

    public Double getCreditCost() {
        return propertyProviderService.getCreditCost();
    }

}
