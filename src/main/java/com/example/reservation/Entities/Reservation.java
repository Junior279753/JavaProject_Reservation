package com.example.reservation.Entities;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;
	private LocalDate dateReservation;
	private LocalTime heureDebut;
	private LocalTime heureFin;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateurs;
	
	@ManyToOne
	@JoinColumn(name = "salle_id")
	private Salle salles;
	
	
	//getters ant setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}
	public LocalTime getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}
	public LocalTime getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}
	public Utilisateur getUtilisateur() {
		return utilisateurs;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateurs = utilisateur;
	}
	public Salle getSalle() {
		return salles;
	}
	public void setSalle(Salle salle) {
		this.salles = salle;
	}
	

}
