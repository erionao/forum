package com.logisticsplus.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostimeController {

    @RequestMapping(value = "/postime", method = RequestMethod.GET)

    public String  index (Model model) {

        model.addAttribute("id1", "1");
        model.addAttribute("titulli", "Titulli i postimit");
        model.addAttribute("pershkrimi", "Pershkrimi i postimit");

        return "index";
    }


}
