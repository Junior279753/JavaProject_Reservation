package com.example.reservation.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.reservation.Entities.Salle;
import com.example.reservation.Repositories.SalleRepository;

@Service
public class SalleService {
	
	@Autowired
	SalleRepository salleRepo;
	

	public List <Salle> getAll(){
		try {
            return salleRepo.findAll();
		}catch (Exception e){
			throw new RuntimeException("Une erreur est survenue, veuillez réessayer");
		}
	}

	public Salle getById(Long id){
		try {
			Optional<Salle> salle = salleRepo.findById(id);
			if (salle.isPresent()){
				return salle.get();
			}
			throw new RuntimeException("Une erreur est survenue, veuillez réessayer");
		}catch (Exception e){
			throw new  RuntimeException("Une erreur est survenue, veuillez réessayer");
		}
	}

	public Salle add(Salle salle) {
		try {
			return salleRepo.save(salle);
		}catch (Exception e){
			throw new RuntimeException("Une erreur est survenue lors de la création de la salle, veuillez réessayer");
		}

	}

	public Salle update(Long id, Salle salle) {
		try {
			salle.setId(id);
			return salleRepo.save(salle);
		}catch (Exception e){
			throw new RuntimeException("Une erreur est survenue lors de la mise à jour de la salle, veuillez réessayer");
		}

	}

	public void delete(@PathVariable long id) {
		try {
			salleRepo.deleteById(id);
		}catch (Exception e){
			throw new RuntimeException("Une erreur est survenue lors de la suppression de la salle, veuillez réessayer");
		}
	}
	

}
