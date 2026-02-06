package com.example.reservation.controllers;

import com.example.reservation.Entities.Salle;
import com.example.reservation.Services.SalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/salles")
@RequiredArgsConstructor
public class SalleController {

    private final SalleService salleService;


    @RequestMapping
    public String getAll(ModelMap modelMap) {
        try {
            List<Salle> salles = salleService.getAll();
            modelMap.addAttribute("salles_liste",salles);
        }catch (Exception e){
            modelMap.addAttribute("error",e.getMessage());
        }
        return "salles";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Salle salle, RedirectAttributes redirectAttributes){
        try {
            salle.setDisponible(true);
            salleService.add(salle);
            redirectAttributes.addFlashAttribute("success","Salle créé avec succès");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return "redirect:/salles";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Salle salle, RedirectAttributes redirectAttributes){
        try {
            salleService.update(id,salle);
            redirectAttributes.addFlashAttribute("success","Salle mis à jour avec succès");
        }catch (Exception e ){
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return "redirect:/salles";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            salleService.delete(id);
            redirectAttributes.addFlashAttribute("success", "Salle supprimée avec succès");
        }catch (Exception e ){
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return "redirect:/salles";
    }
}
