package com.example.reservation.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.Entities.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation, Long> {
    List<Reservation> findByUtilisateurId(Long utilisateurId);
    
    List<Reservation> findBySalleId(Long salleId);

}
