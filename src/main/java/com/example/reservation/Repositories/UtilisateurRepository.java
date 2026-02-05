package com.example.reservation.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.Entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Long>{
	Optional<Utilisateur> findByEmail(String email);

}
