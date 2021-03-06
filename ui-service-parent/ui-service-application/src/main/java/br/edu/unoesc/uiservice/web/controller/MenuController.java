package br.edu.unoesc.uiservice.web.controller;

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

    @GetMapping("/acesso")
    public ModelAndView acesso(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/acesso");
        return modelAndView;
    }

    @GetMapping("/pessoa")
    public ModelAndView pessoa(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/pessoa");
        return modelAndView;
    }
}
