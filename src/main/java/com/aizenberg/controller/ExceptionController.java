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
//ileSizeLimitExceededException
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleThrowables(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        String message = exception.getMessage();
        modelAndView.addObject("error", Utils.isEmpty(message) ? "Unknown error" : message);
        return modelAndView;
    }

    @ExceptionHandler(value = {FileUploadBase.FileSizeLimitExceededException.class, org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException.class})
    public ModelAndView handleFileSizeLimit(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", "Check your file size. Maximum - 1Mb");
        return modelAndView;
    }

}
