package com.example.reservation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.reservation.Entities.Salle;
import com.example.reservation.Repositories.SalleRepository;

@Service
public class SalleController {
	
	@Autowired
	SalleRepository salleRepo;
	

	public List <Salle> getAllSalle(){
		List<Salle> salles = salleRepo.findAll();
	    
	    if (salles.isEmpty()) {
	        throw new RuntimeException("No salles found");
	    }
	    
	    return salles;
	}
	
	

	public Salle addSalle(@RequestBody Salle salle) {
		return salleRepo.save(salle);
	}
	

	public Salle updateSalle(@PathVariable Long id, @RequestBody Salle salle) {
		salle.setId(id);
		return salleRepo.save(salle);
	}
	

	public void deleteSalle(@PathVariable long id) {
		salleRepo.deleteById(id);
	}
	

}
