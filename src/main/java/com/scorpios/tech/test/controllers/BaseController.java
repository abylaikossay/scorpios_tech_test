package com.scorpios.tech.test.controllers;


import com.scorpios.tech.test.models.responses.error.ErrorResponse;
import com.scorpios.tech.test.models.responses.error.ServiceException;
import com.scorpios.tech.test.models.responses.success.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
    protected ResponseEntity<?> buildResponse(Object data, HttpStatus httpStatus){
        return new ResponseEntity<>(data , httpStatus);
    }


    protected ErrorResponse buildErrorResponse(ServiceException serviceException){
        return ErrorResponse.builder()
                .code(serviceException.getErrorCode())
                .message(serviceException.getMessage())
                .build();
    }


    protected ResponseEntity<?> buildSuccess(String message, Object data) {
        return new ResponseEntity<>(SuccessResponse.builder().message(message)
                .data(data)
                .build(), HttpStatus.OK);
    }


}
