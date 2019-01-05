package com.calculator.subtractservice.controller;

import com.calculator.subtractservice.enums.APIResponseCodeENUM;
import com.calculator.subtractservice.exceptions.APIBaseException;
import com.calculator.subtractservice.model.request.OperationRequest;
import com.calculator.subtractservice.model.response.APIResponse;
import com.calculator.subtractservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created by akashdeepnew on 20/12/18.
 */
@RestController
@RefreshScope
@RequestMapping(value = "/subtract")
public class SubtractOperationController {

    @Autowired
    private SubtractService subtractService;

    @Autowired
    private ValidationService validateService;


    @PostMapping("/calculate")
    @ResponseBody
    public APIResponse calculate(@RequestBody OperationRequest operationRequest) throws Exception {
        validateService.validateServiceRequest(operationRequest);
        return APIResponse.buildSuccess(subtractService.subtract(operationRequest));
    }

    @GetMapping("/cost")
    @ResponseBody
    public APIResponse creditCost() throws Exception {
        return APIResponse.buildSuccess(subtractService.getCreditCost());
    }


    @ExceptionHandler
    @ResponseBody
    public APIResponse handleException(Exception ex) {
        if (ex instanceof APIBaseException){
            return APIResponse.buildFailure(((APIBaseException) ex).getApiResponseCodeENUM());
        }
        return APIResponse.buildFailure(APIResponseCodeENUM.GENERAL_FAILURE);
    }
}
