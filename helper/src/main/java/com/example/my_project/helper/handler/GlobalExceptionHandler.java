package com.example.my_project.helper.handler;


import com.example.my_project.helper.error.ApiException;
import com.example.my_project.model.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public @ResponseBody
    ApiResponse handlerException(ApiException ex){
        ApiResponse apiOutput = new ApiResponse();
        apiOutput.setSuccess(false);
        String errorCode=ex.getErrorCode();
        if(errorCode!=null){
            apiOutput.setErrorCode(ex.getErrorCode());
            apiOutput.setErrorMessage(ex.getErrorMessage());
        }
        return apiOutput;
    }


}