package com.neesh.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.neesh.flight_reservation_app.dto.ReservationRequest;
import com.neesh.flight_reservation_app.entity.Reservation;
import com.neesh.flight_reservation_app.services.ReservationService;


@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest reservation,Model model) {
		Reservation reservationId = reservationService.bookFlight(reservation);
		model.addAttribute("reservationId", reservationId.getId());
		
		
		return "confirmReservation";
		}
}
