package com.example.reservation.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String email;
	private String role;
	private String password;
	


	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List <Reservation> reservations;

	
	
	// constructors
	public Utilisateur() {
		
	}
	public Utilisateur(Long id, String nom, String email, String role, List<Reservation> reservation) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.role = role;
		this.reservations = reservation;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Reservation> getReservation() {
		return reservations;
	}

	public void setReservation(List<Reservation> reservations) {
		this.reservations= reservations;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	

}
