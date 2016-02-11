package com.logisticsplus.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShfrytezuesController {

    @RequestMapping(value = "/shfrytezues", method = RequestMethod.GET)

    public String index(Model model) {
        model.addAttribute("id", "1524");
        model.addAttribute("name", "Riola");
        model.addAttribute("surname", "Lama");
        model.addAttribute("email", "riolalama@hotmail.com");
        model.addAttribute("username", "Riola");
        model.addAttribute("password", "1234");

        return "index";

    }


}
