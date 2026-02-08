package com.example.reservation_system;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservationById(
            @PathVariable("id") Long id
    ) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationService.getReservationById(id));
    }
    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.findAllReservations());
    }
    @PostMapping("/reservation")
    public ResponseEntity<Reservation> createReservation(
            @RequestBody Reservation reservationToCreate)
    {
        return ResponseEntity.status(201).header("test-header","123").body(reservationService.createReservation(reservationToCreate));

    }
}
