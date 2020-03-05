package com.chainsys.shipticketbooking.service;

import java.util.ArrayList;

import com.chainsys.shipticketbooking.dao.AdminDAO;
import com.chainsys.shipticketbooking.dao.BookingDAO;
import com.chainsys.shipticketbooking.dao.JourneyDAO;
import com.chainsys.shipticketbooking.dao.SeatDAO;
import com.chainsys.shipticketbooking.dao.ShipDetailDAO;
import com.chainsys.shipticketbooking.dao.UserDAO;
import com.chainsys.shipticketbooking.dao.implementation.AdminDAOImplementation;
import com.chainsys.shipticketbooking.dao.implementation.BookingDAOImplementation;
import com.chainsys.shipticketbooking.dao.implementation.JourneyDAOImplementation;
import com.chainsys.shipticketbooking.dao.implementation.SeatDAOImplementation;
import com.chainsys.shipticketbooking.dao.implementation.ShipDetailDAOImplementation;
import com.chainsys.shipticketbooking.dao.implementation.UserDAOImplementation;
import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.exception.ErrorMessages;
import com.chainsys.shipticketbooking.exception.ServiceException;
import com.chainsys.shipticketbooking.exception.ValidatorException;
import com.chainsys.shipticketbooking.model.Booking;
import com.chainsys.shipticketbooking.model.Journey;
import com.chainsys.shipticketbooking.model.SeatAvailability;
import com.chainsys.shipticketbooking.model.ShipDetail;
import com.chainsys.shipticketbooking.model.User;

//it is used when client is not necessary to call DAO directly instead we using one service class to call all the DAO .So that service will call the DAO and return the statement to client through servelet.
public class ServiceShipTicket {

	private AdminDAO admin = new AdminDAOImplementation();
	private SeatDAO seat = new SeatDAOImplementation();
	private BookingDAO book = new BookingDAOImplementation();
	private JourneyDAO journey = new JourneyDAOImplementation();
	private ShipDetailDAO ship = new ShipDetailDAOImplementation();
	private UserDAO user = new UserDAOImplementation();

	// static Jdbi jdbi=TestConnection.getJdbi();
	// static UserDAO user=jdbi.onDemand(UserDAO.class);
	public int Totalcost(int a, int b) throws ServiceException {
		try {
			return seat.Totalcost(a, b);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public boolean AdminLogin(int adminId, String pass) throws ServiceException {
		boolean adminLogin = false;
		try {
			validSearch(adminId, pass);
			adminLogin = admin.AdminLogin(adminId, pass);
		} catch (ValidatorException e) {
			throw new ServiceException(ErrorMessages.ADMIN_LOGIN_FAILED);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}

		return adminLogin;

	}

	public boolean User(int userId, String password) throws ServiceException {
		boolean userLogin = false;
		try {
			validSearch1(userId, password);
			userLogin = user.User(userId, password);
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.USER_LOGIN_FAILED);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}

		return userLogin;

	}

	public int book(Booking b) throws ServiceException {
		try {
			return book.book(b);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);

		}
	}

	public void add(SeatAvailability a) throws ServiceException {
		try {
			seat.add(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void update(SeatAvailability a) throws ServiceException {
		try {
			seat.update(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void delete(SeatAvailability a) throws ServiceException {
		try {
			seat.delete(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void procedure(SeatAvailability b) throws ServiceException {
		try {
			seat.procedure(b);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public int costOfBooking(String b) throws ServiceException {
		try {
			return seat.costOfBooking(b);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void addBooking(Booking a) throws ServiceException {
		try {
			book.addBooking(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void updateBooking(Booking a) throws ServiceException {
		try {
			book.updateBooking(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void deleteBooking(Booking a) throws ServiceException {
		try {
			book.deleteBooking(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public int count() throws ServiceException {
		try {
			return book.count();
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void addJourney(Journey a) throws ServiceException {
		try {
			journey.addJourney(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void updateJourney(Journey a) throws ServiceException {
		try {
			journey.updateJourney(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void deleteJourney(Journey a) throws ServiceException {
		try {
			journey.deleteJourney(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public ArrayList<Journey> getJourney(int a) throws ServiceException {
		try {
			return journey.getJourney(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void addShip(ShipDetail s) throws ServiceException {
		try {
			ship.addShip(s);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void updateShip(ShipDetail s) throws ServiceException {
		try {
			ship.updateShip(s);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void deleteShip(ShipDetail s) throws ServiceException {
		try {
			ship.deleteShip(s);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public ArrayList<ShipDetail> getShip(ShipDetail s) throws ServiceException {
		try {
			return ship.getShip(s);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public ArrayList<ShipDetail> Ship() throws ServiceException {
		try {
			return ship.Ship();
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}
	public ArrayList<ShipDetail> routeShip() throws ServiceException {
		try {
			return ship.routeShip();
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void distinctShip(String s) throws ServiceException {
		try {
			ship.distinctShip(s);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void addUser(User a) throws ServiceException {
		try {
			user.addUser(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void updateUser(User a) throws ServiceException {
		try {
			user.updateUser(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void deleteUser(User a) throws ServiceException {
		try {
			user.deleteUser(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void resetUser(User a) throws ServiceException {
		try {
			user.resetUser(a);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public int seat(SeatAvailability b) throws ServiceException {
		try {
			return seat.seat(b);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
		}
	}

	public void validSearch(int adminId, String pass) throws ValidatorException {
		if (adminId == 0) {
			throw new ValidatorException("Invalid admin");

		} else if (pass == null || pass.equals("") || pass.trim().equals("")) {
			throw new ValidatorException("Invalid password");
		}
	}

	public void validSearch1(int userId, String password) throws ValidatorException {
		if (userId == 0) {
			throw new ValidatorException("Invalid userid");

		} else if (password == null || password.equals("") || password.trim().equals("")) {
			throw new ValidatorException("Invalid password");
		}
	}

}
