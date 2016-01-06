package com.aizenberg.controller;

import com.aizenberg.utils.Utils;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Yuriy Aizenberg
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleThrowables(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        String message = exception.getMessage();
        modelAndView.addObject("error", Utils.isEmpty(message) ? "Unknown error" : message);
        return modelAndView;
    }

}
