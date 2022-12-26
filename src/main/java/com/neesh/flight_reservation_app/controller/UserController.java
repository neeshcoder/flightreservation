package com.neesh.flight_reservation_app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neesh.flight_reservation_app.entity.User;
import com.neesh.flight_reservation_app.repositories.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login/login";
			}
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
			}
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute ("user") User user) {
		userRepo.save(user);
		return "login/login";
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId ,@RequestParam("password") String password ,Model model) {
		User user = userRepo.findByEmail(emailId);  // in palace of find we can use get/read also but cannot use without get/find it will not run
	if(user != null) {
		if (user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
				return "findFlight";
	}else {
		model.addAttribute("error","invalid username / password ");
		return "login/login";
	}
	}else {
		model.addAttribute("error","invalid username / password ");
		return "login/login";
	}
	}
}
