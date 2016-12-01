package com.medicinery.web.controller;

import com.medicinery.core.service.MedicineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private MedicineryService medicineryService;

    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.put("entity", medicineryService.findById(39041L));
        return "index";
    }
}