package com.lsq.springboot.springboottest.handler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsq.springboot.springboottest.pojo.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.DataBindingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean handlerException(BindException e) throws JsonProcessingException {

        BindingResult bindingResult = e.getBindingResult();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            Map<String, String> resultMap = new HashMap<String, String>();

            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();

                //log.error("[{}]:[{}]",field,defaultMessage);
                resultMap.put(field, defaultMessage);

            }
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(resultMap);
            return new ResultBean("400", json);
    }
}
