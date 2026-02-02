package com.example.reservation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.Entities.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation, Long> {

}
