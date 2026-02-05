package com.example.reservation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.reservation.Entities.Utilisateur;
import com.example.reservation.Repositories.UtilisateurRepository;
import org.springframework.security.crypto.password.PasswordEncoder;


public class UtilisateurController {
	
	@Autowired
	private final PasswordEncoder passwordEncoder;

	public UtilisateurController(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	public UtilisateurRepository utilisateurRepo;
	

	public List <Utilisateur> getAllUsers(){
		return utilisateurRepo.findAll();
	}
	

	public ResponseEntity<?> addUser(@RequestBody Utilisateur user) {
		if(utilisateurRepo.findByEmail(user.getEmail()).isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Email already exist");
		}
		else {
			String hashedPass = passwordEncoder.encode(user.getPassword());
			user.setPassword(hashedPass);
			Utilisateur savedUser = utilisateurRepo.save(user);
			return ResponseEntity.ok(savedUser);
		}

	}
	

	public ResponseEntity<?> updateUser(@RequestBody Utilisateur user , @PathVariable Long id) {
		if(utilisateurRepo.findById(id).isPresent()){
			user.setId(id);
			Utilisateur userUpdated = utilisateurRepo.save(user);
			return ResponseEntity.ok(userUpdated);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("The user you are trying to update doesn't exist");
		}
	}
	

	public ResponseEntity<?> deleteUser(@PathVariable long id) {
		if(utilisateurRepo.existsById(id)) {
			utilisateurRepo.deleteById(id);
			return ResponseEntity.ok()
			.body("user deleted");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("The user u are trying to detete doesn't exist");
		}
		
		
		
	}
	
	
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	    // Find user by email  findByEmail
	    Utilisateur user = utilisateurRepo.findByEmail(loginRequest.getEmail())
	        .orElseThrow(() -> new RuntimeException("User not found"));
	    
	    // Check if password matches
	    if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
	        return ResponseEntity.ok("Login successful!");
	    } else {
	        // Password is wrong
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong password");
	    }
	}
	
	

}
