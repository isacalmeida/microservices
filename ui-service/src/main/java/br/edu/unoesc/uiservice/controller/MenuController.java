package br.edu.unoesc.uiservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/index");
        return modelAndView;
    }

    @GetMapping("/pessoa")
    public ModelAndView pessoa(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/pessoa");
        return modelAndView;
    }
}
