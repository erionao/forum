package com.logisticsplus.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String index(Model model) {

        model.addAttribute("surname", "1111");
        model.addAttribute("id", "1524");
        model.addAttribute("name", "Riola");

        return "index";

    }


}
