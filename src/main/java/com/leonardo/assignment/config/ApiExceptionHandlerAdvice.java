package com.leonardo.assignment.config;

import com.google.common.base.Throwables;
import com.leonardo.assignment.utils.ResultJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandlerAdvice {
    Logger logger = LoggerFactory.getLogger(ApiExceptionHandlerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResultJson exception(Exception exception, WebRequest request) {
        ResultJson errorResult = new ResultJson();
        errorResult.setCode(-1);
        errorResult.setMessage(Throwables.getRootCause(exception).getMessage());
        logger.error("Global Exception: " , exception);
        return errorResult;
    }
}
