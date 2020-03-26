package com.chainsys.shipticketbooking.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.shipticketbooking.dto.Message;
import com.chainsys.shipticketbooking.exception.ServiceException;
import com.chainsys.shipticketbooking.model.ShipDetail;
import com.chainsys.shipticketbooking.model.User;
import com.chainsys.shipticketbooking.service.ServiceShipTicket;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class ProductController {

	ServiceShipTicket user = new ServiceShipTicket();

	@PostMapping("/addUser")
	public void addUser(@RequestParam("name") String name, @RequestParam("userId") int userId,
			@RequestParam("dob") String dob, @RequestParam("contactnumber") long contactnumber,
			@RequestParam("gender") String gender, @RequestParam("pass") String password,
			@RequestParam("email") String email) {

		try {
			User u1 = new User();
			u1.setUserName(name);
			u1.setUserId(userId);
			LocalDate date = LocalDate.parse(dob);
			u1.setDateOfBirth(date);
			u1.setContactNumber(contactnumber);
			u1.setGender(gender);
			u1.setPassword(password);
			u1.setEmail(email);

			user.addUser(u1);
		} catch (ServiceException e) {
			// e.printStackTrace();
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			throw new ServiceException("serviceException", e);
		}

	}

	@GetMapping("/getShip")
	public ArrayList<ShipDetail> getShip(@RequestParam("source") String sourceplace,
			@RequestParam("destination") String destinationplace) {
		try {
			ShipDetail ship = new ShipDetail();
			ship.setSourcePlace(sourceplace);
			ship.setDestinationPlace(destinationplace);
			return user.getShip(ship);
		} catch (ServiceException e) {
			//e.printStackTrace();
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			throw new ServiceException("ServiceException",e);
		}
	}

	@PostMapping("/addinguser")
	public void addinguser(@RequestBody User a) {

		try {
			user.addUser(a);
		} catch (ServiceException e) {
//			e.printStackTrace();
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			throw new ServiceException("ServiceException",e);
		}

	}

	@GetMapping("/routeShip")
	public ArrayList<ShipDetail> routeShip() {
		try {
			ShipDetail ship = new ShipDetail();

			return user.routeShip();
		} catch (ServiceException e) {
//			e.printStackTrace();
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			throw new ServiceException("ServiceException",e);
		}
	}
}