package com.example.reservation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservation.Entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, Long>{

}
