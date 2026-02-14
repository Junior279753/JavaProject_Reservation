package com.example.reservation.controllers;

import com.example.reservation.Entities.Utilisateur;
import com.example.reservation.Services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @RequestMapping
    public String getAll(ModelMap modelMap){
        try {
            List<Utilisateur> utilisateurs = utilisateurService.getAllUsers();
            modelMap.addAttribute("utilisateurs_liste",utilisateurs);
        } catch (Exception e) {
            modelMap.addAttribute("error",e.getMessage());
        }
        modelMap.addAttribute("pageTitle","Utilisateurs - App de réservation");
        return "utilisateurs";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Utilisateur utilisateur, RedirectAttributes redirectAttributes){
        try {
            utilisateurService.add(utilisateur);
            redirectAttributes.addFlashAttribute("success","Utilisateur crée avec succès");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return "redirect:/utilisateurs";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Utilisateur utilisateur, RedirectAttributes redirectAttributes){
        try {
            utilisateurService.update(utilisateur,id);
            redirectAttributes.addFlashAttribute("success","Utilisateur mis à jour avec succès");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return "redirect:/utilisateurs";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            utilisateurService.delete(id);
            redirectAttributes.addFlashAttribute("success","Utilisateur supprimer avec succès");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return "redirect:/utilisateurs";
    }
}
