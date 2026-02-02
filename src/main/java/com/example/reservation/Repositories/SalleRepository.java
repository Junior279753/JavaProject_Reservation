package com.example.reservation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.Entities.Salle;

public interface SalleRepository extends JpaRepository <Salle, Long> {

}
