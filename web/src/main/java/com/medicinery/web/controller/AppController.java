package com.medicinery.web.controller;

import com.medicinery.core.service.MedicineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private MedicineryService medicineryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/popular", method = RequestMethod.GET)
    public String popular(ModelMap model) {
        model.put("toWidget", false);
        Map<String, String> items = new HashMap<>();
        items.put("Крокодил", "Дил-Дил");
        items.put("Бегемот", "Мот-Мот");
        model.put("items", items);
        return "templates/popular_items";
    }
}