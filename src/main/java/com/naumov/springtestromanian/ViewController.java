package com.naumov.springtestromanian;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * This class is {@code @Controller} which means it will serve views to the browser
 */
@Controller
public class ViewController {

    /**
     * Simple controller method.
     * @return the name of a view (html file) from ./resources/templates. The output is processed by Thymeleaf using given {@Param model}.
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Kolyan Sucks");
        model.addAttribute("mode", "production");
        return "index";
    }
}
