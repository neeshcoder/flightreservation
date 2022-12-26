package com.neesh.flight_reservation_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neesh.flight_reservation_app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

}
