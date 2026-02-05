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

import com.example.reservation.Entities.Reservation;
import com.example.reservation.Repositories.ReservationRepository;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@GetMapping
	public List <Reservation> getAllReservation(){
		return reservationRepo.findAll();
	}
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return reservationRepo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping("/add")
	public Reservation addReservation(@RequestBody Reservation reservation) {
		return reservationRepo.save(reservation);
	}

	@PutMapping("/update/{id}")
	public Reservation updateRservation(@PathVariable long id, @RequestBody Reservation reservation) {
		reservation.setId(id);
		return reservationRepo.save(reservation);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable long id) {
		reservationRepo.deleteById(id);
	}
}
