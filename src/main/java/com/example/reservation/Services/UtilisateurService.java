package com.example.reservation.Services;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservation.Entities.Utilisateur;
import com.example.reservation.Repositories.UtilisateurRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

	@Autowired
	private final PasswordEncoder passwordEncoder;

	@Autowired
	private final UtilisateurRepository utilisateurRepo;
	

	public List <Utilisateur> getAllUsers(){
		try {
			return utilisateurRepo.findAll();
		}
		catch(Exception e){
			throw new RuntimeException("Une erreur est survenue, veuillez réessayer");
		}	
	}
	
	public Utilisateur getById(Long id) {
		
		try {
			Optional<Utilisateur> user = utilisateurRepo.findById(id);
			if(user.isPresent()) {
				return user.get();
			}
			throw new RuntimeException("Une erreur est survenue, veuillez réessayer");
		}
		catch(Exception e) {
			throw new RuntimeException("Une erreur est survenue, veuillez réessayer");
		}
	}

	public Utilisateur add(Utilisateur user) {
		if(utilisateurRepo.existsByEmail(user.getEmail())) {
			throw new RuntimeException("L'email est déjà utilisé pour un compte utilisateur, veuillez en choisir un autre");
		}else{
			try {
				return utilisateurRepo.save(user);

			}catch(Exception e) {
				throw new RuntimeException("Une erreur est survenue lors de la création de l'utilisateur, veuillez réessayer");
			}
		}
	}
	

	public Utilisateur update(Utilisateur user, Long id) {
		try {
			if(utilisateurRepo.existsByEmailAndIdNot(user.getEmail(), id)) {
				throw new RuntimeException("L'email existe déjà");
			}
			user.setId(id);
			return utilisateurRepo.save(user);
		}
		catch (RuntimeException e) {
	        throw e;
	    }
		catch(Exception e) {
			throw new RuntimeException("Une erreur est survenue lors de la mise a jour  de l'utilisateur, veuillez réessayer");
		}
	}
	
	
	public void delete(Long id) {
		try {
			if(utilisateurRepo.existsById(id)) {
				utilisateurRepo.deleteById(id);
			}
			else {
				throw new RuntimeException("L'utilisateur que voue essayer de supprimer n'existe pas");
			}
			
		}
		catch(Exception e) {
			throw new RuntimeException("Une erreur est survenue lors de la supression de l'utilisateur, veuillez réessayer");
		}
	}

	public List<Utilisateur> getByRole(String role){
		try {
			 return utilisateurRepo.findAllByRole(role);
		}catch (Exception e){
			throw new RuntimeException("Une erreur est survenue, veuillez réessayer");
		}
	}
	
}
