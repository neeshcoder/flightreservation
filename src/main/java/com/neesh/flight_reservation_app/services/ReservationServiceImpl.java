package com.neesh.flight_reservation_app.services;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neesh.flight_reservation_app.dto.ReservationRequest;
import com.neesh.flight_reservation_app.entity.Flight;
import com.neesh.flight_reservation_app.entity.Passenger;
import com.neesh.flight_reservation_app.entity.Reservation;
import com.neesh.flight_reservation_app.repositories.FlightRepository;
import com.neesh.flight_reservation_app.repositories.PassengerRepository;
import com.neesh.flight_reservation_app.repositories.ReservationRepository;
import com.neesh.flight_reservation_app.utilities.EmailUtil;
import com.neesh.flight_reservation_app.utilities.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private EmailUtil emailUtil;
		  
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		Passenger passenger =new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		Long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
			
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath = "B:\\STS OLDER VERSION\\Spring tool Projects\\flight_reservation_app\\Tickets\\reservation"+reservation.getId()+".pdf";
		reservationRepo.save(reservation);
		pdfGenerator.generateItinerary(reservation,filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath );
				return reservation;
	}
}
