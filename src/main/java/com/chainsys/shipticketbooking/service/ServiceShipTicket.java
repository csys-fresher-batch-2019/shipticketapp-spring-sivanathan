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
import com.chainsys.shipticketbooking.logger.Logger;
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
	Logger logger = Logger.getInstance();

	// static Jdbi jdbi=TestConnection.getJdbi();
	// static UserDAO user=jdbi.onDemand(UserDAO.class);
	public void findamount(SeatAvailability b) throws ServiceException {
		try {
			seat.findTicketStatusAndCost(b);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public int Totalcost(int a, int b) throws ServiceException {
		try {
			return seat.findTotalcost(a, b);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.CONNECTION_FAILURE, e);
		}
	}

	public boolean AdminLogin(int adminId, String pass) throws ServiceException {
		boolean adminLogin = false;
		try {
			validSearch(adminId, pass);
			adminLogin = admin.adminExist(adminId, pass);
		} catch (ValidatorException e) {
			// throw new ServiceException(ErrorMessages.ADMIN_LOGIN_FAILED);
			// logger.error(ErrorMessages.ADMIN_LOGIN_FAILED);
			throw new ServiceException(ErrorMessages.ADMIN_LOGIN_FAILED, e);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}

		return adminLogin;

	}

	public boolean User(int userId, String password) throws ServiceException {
		boolean userLogin = false;
		try {
			validSearch1(userId, password);
			userLogin = user.userExist(userId, password);
		} catch (ValidatorException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.USER_LOGIN_FAILED);
			// logger.error(ErrorMessages.USER_LOGIN_FAILED + "" + e);
			throw new ServiceException(ErrorMessages.USER_LOGIN_FAILED, e);

		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}

		return userLogin;

	}

	public int book(Booking b) throws ServiceException {
		try {
			return book.findCostOfBooking(b);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);

		}
	}

	public void add(SeatAvailability a) throws ServiceException {
		try {
			seat.addSeatAvailability(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void update(SeatAvailability a) throws ServiceException {
		try {
			seat.updateSeatAvailability(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void delete(SeatAvailability a) throws ServiceException {
		try {
			seat.deleteSeatAvailability(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void procedure(SeatAvailability b) throws ServiceException {
		try {
			seat.procedure(b);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public int costOfBooking(String b) throws ServiceException {
		try {
			return seat.costOfBooking(b);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void addBooking(Booking a) throws ServiceException {
		try {
			book.saveBooking(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void updateBooking(Booking a) throws ServiceException {
		try {
			book.updateBooking(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void deleteBooking(Booking a) throws ServiceException {
		try {
			book.deleteBooking(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public int count() throws ServiceException {
		try {
			return book.countOfBooking();
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void addJourney(Journey a) throws ServiceException {
		try {
			journey.saveJourney(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void updateJourney(Journey a) throws ServiceException {
		try {
			journey.updateJourney(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void deleteJourney(Journey a) throws ServiceException {
		try {
			journey.deleteJourney(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public ArrayList<Journey> getJourney(int a) throws ServiceException {
		try {
			return journey.findAllJourney(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void addShip(ShipDetail s) throws ServiceException {
		try {
			ship.saveShipDetail(s);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void updateShip(ShipDetail s) throws ServiceException {
		try {
			ship.updateShipDetail(s);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void deleteShip(ShipDetail s) throws ServiceException {
		try {
			ship.deleteShipDetail(s);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public ArrayList<ShipDetail> getShip(ShipDetail s) throws ServiceException {
		try {
			return ship.findAllShipDetailWithSourceAndDestination(s);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public ArrayList<ShipDetail> Ship() throws ServiceException {
		try {
			return ship.findAllShip();
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public ArrayList<ShipDetail> routeShip() throws ServiceException {
		try {
			return ship.routeShip();
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void distinctShip(String s) throws ServiceException {
		try {
			ship.distinctShip(s);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void addUser(User a) throws ServiceException {
		try {
			user.saveUser(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void updateUser(User a) throws ServiceException {
		try {
			user.updateUser(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void deleteUser(User a) throws ServiceException {
		try {
			user.deleteUser(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void resetUser(User a) throws ServiceException {
		try {
			user.passwordResetUser(a);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public int seat(SeatAvailability b) throws ServiceException {
		try {
			return seat.findAvailableSeats(b);
		} catch (DBException e) {
			e.printStackTrace();
			// throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION);
			// logger.error(ErrorMessages.INVALID_DB_EXCEPTION + "" + e);
			throw new ServiceException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}

	public void validSearch(int adminId, String pass) throws ValidatorException {
		if (adminId == 0) {
			// throw new ValidatorException("Invalid admin");
			logger.error(ErrorMessages.INVALID_VALIDATE_USER);

		} else if (pass == null || pass.equals("") || pass.trim().equals("")) {
			// throw new ValidatorException("Invalid password");
			logger.error(ErrorMessages.INVALID_VALIDATE_PASSWORD);
		}
	}

	public void validSearch1(int userId, String password) throws ValidatorException {
		if (userId == 0) {
			// throw new ValidatorException("Invalid userid");
			logger.error(ErrorMessages.INVALID_VALIDATE_USER);

		} else if (password == null || password.equals("") || password.trim().equals("")) {
			// throw new ValidatorException("Invalid password");
			logger.error(ErrorMessages.INVALID_VALIDATE_PASSWORD);
		}
	}

}
