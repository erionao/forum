package com.logisticsplus.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {

    @RequestMapping(value = "/kategori", method = RequestMethod.GET)

    public String  index (Model model) {

        model.addAttribute("id", "1524");
        model.addAttribute("name", "RiolaLama");

        return "index";
    }


}
