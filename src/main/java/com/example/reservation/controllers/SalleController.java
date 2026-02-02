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

import com.example.reservation.Entities.Salle;
import com.example.reservation.Repositories.SalleRepository;

@RestController
@RequestMapping("/api/salles")
public class SalleController {
	
	@Autowired
	SalleRepository salleRepo;
	
	@GetMapping
	public List <Salle> getAllSalle(){
		return salleRepo.findAll();
	}
	
	@PostMapping("/add")
	public Salle createaddSalle(@RequestBody Salle salle) {
		return salleRepo.save(salle);
	}
	
	@PutMapping("/update/{id}")
	public Salle updateSalle(@PathVariable Long id, @RequestBody Salle salle) {
		salle.setId(id);
		return salleRepo.save(salle);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSalle(@PathVariable long id) {
		salleRepo.deleteById(id);
	}
	

}
