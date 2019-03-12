package com.antonromanov.firstcrud.firstcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {



    @RequestMapping("/")
    public ModelAndView doHome() {

        ModelAndView mv = new ModelAndView("index");
    //    mv.addObject("lists3", employeeservice.failedInSub());

        return mv;

    }



}
