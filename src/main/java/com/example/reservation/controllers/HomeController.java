package com.example.reservation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String get(ModelMap modelMap){
        modelMap.addAttribute("pageTitle","Page d'accueil - App de Réservvation");
        return "home";
    }
}
