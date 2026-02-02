package com.example.reservation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservation.Entities.Utilisateur;
import com.example.reservation.Repositories.UtilisateurRepository;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
	
	@Autowired
	public UtilisateurRepository utilisateurRepo;
	
	@GetMapping
	public List <Utilisateur> getAllUsers(){
		return utilisateurRepo.findAll();
	}
	
	@PostMapping("/add")
	public Utilisateur addUser(@RequestBody Utilisateur user) {
		return utilisateurRepo.save(user);
	}
	
	@PutMapping("/update/{id}")
	public Utilisateur updateUser(@RequestBody Utilisateur user , @PathVariable Long id) {
		user.setId(id);
		return utilisateurRepo.save(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable long id) {
		utilisateurRepo.deleteById(id);
	}

}
