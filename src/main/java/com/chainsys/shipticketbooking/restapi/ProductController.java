package com.chainsys.shipticketbooking.restapi;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.shipdetails.ShipDetail;
import com.chainsys.user.User;
import com.chainsys.util.ServiceShipTicket;

@RestController
@RequestMapping("api")
public class ProductController {

	ServiceShipTicket user = new ServiceShipTicket();

	@PostMapping("/addUser")
	public  void addUser(@RequestParam("name")String name,
			@RequestParam("userId")int userId,
			@RequestParam("dob") String dob,
			@RequestParam("contactnumber") long contactnumber,
			@RequestParam("gender") String gender,
			@RequestParam("pass") String password,
			@RequestParam("email")String email)
	{
		

		User u1=new User();
		u1.setUserName(name);
		u1.setUserId(userId);
		LocalDate date=LocalDate.parse(dob);
		u1.setDateOfBirth(date);
		u1.setContactNumber(contactnumber);
		u1.setGender(gender);
		u1.setPassword(password);
		u1.setEmail(email);
		
		user.addUser(u1);
		
		
	}
	@GetMapping("/getShip")
	public ArrayList<ShipDetail> getShip(@RequestParam("source")String sourceplace,@RequestParam("destination")String destinationplace )
	{
ShipDetail ship=new ShipDetail();
ship.setSourcePlace(sourceplace);
ship.setDestinationPlace(destinationplace);
return user.getShip(ship);
}
}