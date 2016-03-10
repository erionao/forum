package com.logisticsplus.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("name", "Eriona Osmani");
        model.addAttribute("id", "54321");
        model.addAttribute("email", "eriona.osmanii@hotmail.com");
        model.addAttribute("password", "12345");
        return "index";
    }

}
