package com.example.reservation.Services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservation.Entities.Reservation;
import com.example.reservation.Entities.Salle;
import com.example.reservation.Entities.Utilisateur;
import com.example.reservation.Repositories.ReservationRepository;
import com.example.reservation.Repositories.SalleRepository;
import com.example.reservation.Repositories.UtilisateurRepository;

@RestController
@RequestMapping("/api/reservation")
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	public UtilisateurRepository utilisateurRepo;
	
	@Autowired
	SalleRepository salleRepo;
	
	

    public Reservation createReservation(Long utilisateurId, Long salleId, 
                                        LocalDate date, LocalTime debut, LocalTime fin) {
        

        Utilisateur utilisateur = utilisateurRepo.findById(utilisateurId)
            .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
        

        Salle salle = salleRepo.findById(salleId)
            .orElseThrow(() -> new RuntimeException("Salle introuvable"));
        

        Reservation reservation = new Reservation();
        reservation.setUtilisateur(utilisateur);
        reservation.setSalle(salle);   
        reservation.setDateReservation(date);
        reservation.setHeureDebut(debut);
        reservation.setHeureFin(fin);
        

        return reservationRepo.save(reservation);
    }
	
	
	
    
	public List <Reservation> getAllReservation(){
		return reservationRepo.findAll();
	}
	
	
    public Reservation getreservationById( Long id) {
    	
	    	return reservationRepo.findById(id)
	    			.orElseThrow(() -> new RuntimeException("Cette réservation n'existe pas"));

    }
    
    public List<Reservation> getReservationsByUtilisateur(Long utilisateurId) {
    	try {
	        return reservationRepo.findByUtilisateurId(utilisateurId);
    	}catch (Exception e){
			throw new RuntimeException("Une erreur est survenue, veuillez réessayer");
		}

    }
    
    
    public List<Reservation> getReservationsBySalle(Long salleId) {
    	try {
	        return reservationRepo.findBySalleId(salleId);
    	}catch (Exception e){
			throw new RuntimeException("Une erreur est survenue, veuillez réessayer");
		}

    }

	public Reservation updateRservation(Long ReservationId,Long utilisateurId, Long salleId, 
            							LocalDate date, LocalTime debut, LocalTime fin) {
		try {
			
	        Utilisateur utilisateur = utilisateurRepo.findById(utilisateurId)
	                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
	            

	            Salle salle = salleRepo.findById(salleId)
	                .orElseThrow(() -> new RuntimeException("Salle introuvable"));
	            

	            Reservation reservation = new Reservation();
	            reservation.setId(ReservationId);
	            reservation.setUtilisateur(utilisateur);
	            reservation.setSalle(salle);   
	            reservation.setDateReservation(date);
	            reservation.setHeureDebut(debut);
	            reservation.setHeureFin(fin);
	            
	            return reservationRepo.save(reservation);
			
		}catch (Exception e){
			throw new RuntimeException("Une erreur est survenue, veuillez réessayer");
		}
		
	}
	
	
    public void deleteReservation(Long id) {
        if (!reservationRepo.existsById(id)) {
            throw new RuntimeException("Réservation introuvable");
        }
        reservationRepo.deleteById(id);
    }
}
