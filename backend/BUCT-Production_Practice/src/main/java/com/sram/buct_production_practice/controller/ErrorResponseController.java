package com.sram.buct_production_practice.controller;


import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice(annotations=Controller.class)
public class ErrorResponseController{
    static Logger log = Logger.getLogger(ErrorResponseController.class);
    /**
     * 处理所有抛出来的异常
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handlerAll(Exception ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        request.setAttribute("errorTips", ex.getMessage());
        request.setAttribute("ex", ex);
        return "error/sysError";
    }
    /**
     * 处理 NoHandlerFoundException 类型的异常
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handlerNoFound(NoHandlerFoundException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        request.setAttribute("errorTips", ex.getMessage());
        return "error/404";
    }


}
