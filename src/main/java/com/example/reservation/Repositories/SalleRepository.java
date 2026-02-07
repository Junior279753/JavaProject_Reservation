package com.example.reservation.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.Entities.Salle;

public interface SalleRepository extends JpaRepository <Salle, Long> {
	List<Salle> findByDisponibleTrue();

}
