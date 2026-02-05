package com.example.reservation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	

	public List <Salle> getAllSalle(){
		return salleRepo.findAll();
	}
	

	public ResponseEntity<?> addSalle(@RequestBody Salle salle) {
		
		try {
			return ResponseEntity.ok(salleRepo.save(salle));
		}catch (Exception e) {
	        return ResponseEntity.badRequest().body("Error : La salle n'a pas pu être créer ");
	    }
	}
	

	public Salle updateSalle(@PathVariable Long id, @RequestBody Salle salle) {
		salle.setId(id);
		return salleRepo.save(salle);
	}
	

	public void deleteSalle(@PathVariable long id) {
		salleRepo.deleteById(id);
	}
	

}
