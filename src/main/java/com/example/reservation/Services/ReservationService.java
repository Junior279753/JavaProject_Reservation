package com.example.reservation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservation.Entities.Reservation;
import com.example.reservation.Repositories.ReservationRepository;
import com.example.reservation.Repositories.SalleRepository;
import com.example.reservation.Repositories.UtilisateurRepository;

@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	public UtilisateurRepository utilisateurRepo;
	
	@Autowired
	SalleRepository salleRepo;
	
	

    public Reservation createReservation(Reservation reservation) {
		try {
			return reservationRepo.save(reservation);
		}catch (Exception e){
			throw new RuntimeException("Une erreur est survenue lors de la réservation, veuillez réessayer");
		}


    }
	
	
	
    
	public List <Reservation> getAllReservation(){
		return reservationRepo.findAll();
	}
	
	
    public Reservation getReservationById( Long id) {
    	
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

	public Reservation updateReservation(Reservation reservation, Long id) {
		try {
			reservation.setId(id);

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
