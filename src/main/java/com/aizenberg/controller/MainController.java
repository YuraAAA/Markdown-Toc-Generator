package com.aizenberg.controller;

import com.aizenberg.core.Modifier;
import com.aizenberg.model.ModifyModel;
import com.aizenberg.model.RequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy Aizenberg
 */
@Controller(value = "/")
public class MainController {


    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "hello";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/parse")
    public ModelAndView parse(@ModelAttribute("model") RequestModel file, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("hello");
        file.init();
        if (file.getFile() == null || file.getFile().getSize() == 0) {
            modelAndView.addObject("error", "File is empty");
            return modelAndView;
        } else if (file.getDepth() < 1 || file.getDepth() > 6) {
            modelAndView.addObject("error", "Depth must be between 1-6");
            return modelAndView;
        }
        List<ModifyModel> data;
        try {
            data = new Modifier().start(file);
        } catch (IOException e) {
            modelAndView.addObject("error", "Something goes wrong " + e.getMessage());
            return modelAndView;
        }
        modelAndView = new ModelAndView("ok");
        List<String> converted = new ArrayList<>();
        for (ModifyModel modifyModel : data) {
            converted.add(modifyModel.create());
        }
        modelAndView.addObject("data", converted);
        return modelAndView;
    }

}
