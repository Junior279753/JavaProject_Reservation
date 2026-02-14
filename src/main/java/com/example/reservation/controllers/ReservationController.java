package com.example.reservation.controllers;

import com.example.reservation.Entities.Reservation;
import com.example.reservation.Entities.Salle;
import com.example.reservation.Entities.Utilisateur;
import com.example.reservation.Services.ReservationService;
import com.example.reservation.Services.SalleService;
import com.example.reservation.Services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final SalleService salleService;
    private final UtilisateurService utilisateurService;

    @RequestMapping
    public String getAll(ModelMap modelMap){
        try {
            List<Reservation> reservations = reservationService.getAllReservation();
            modelMap.addAttribute("reservations_liste",reservations);
            List<Salle> salles = salleService.availableSalle();
            modelMap.addAttribute("salles_liste",salles);
            List<Utilisateur> utilisateurs = utilisateurService.getByRole("user");
            modelMap.addAttribute("users_liste",utilisateurs);
        } catch (Exception e) {
            modelMap.addAttribute("error",e.getMessage());
        }
        modelMap.addAttribute("pageTitle","Réservations - App de réservation");
        return "reservations";
    }

    @RequestMapping("/create")
    public String create(@ModelAttribute Reservation reservation, RedirectAttributes redirectAttributes){
        try {
            reservationService.createReservation(reservation);
            redirectAttributes.addFlashAttribute("success","Réservation créer avec succès");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return "redirect:/reservations";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Reservation reservation, RedirectAttributes redirectAttributes){
        try {
            reservationService.updateReservation(reservation,id);
            redirectAttributes.addFlashAttribute("success","Réservation mis à jour avec succès");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return "redirect:/reservations";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            reservationService.deleteReservation(id);
            redirectAttributes.addFlashAttribute("success","Reservation supprimer avec succès");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/reservations";
    }
}
