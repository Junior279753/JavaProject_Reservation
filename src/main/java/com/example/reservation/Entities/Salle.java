package com.example.reservation.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "salles")
public class Salle {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private int capacite;
	private String localisation;
	private boolean disponible;
	
	@OneToMany(mappedBy = "salles", cascade = CascadeType.ALL)
	private List <Reservation> reservations;
	
	
	public Salle() {
		
	}
	
	
	public Salle(Long id, String nom, int capacite, String localisation, boolean disponible,
			List<Reservation> reservations) {
		super();
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
		this.localisation = localisation;
		this.disponible = disponible;
		this.reservations = reservations;
	}

	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public List<Reservation> getReservation() {
		return reservations;
	}

	public void setReservation(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	
	

}
