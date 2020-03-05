package com.chainsys.shipticketbooking.dao.implementation;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import com.chainsys.shipticketbooking.logger.Logger;

class SeatDAOImplementationTest {

	@Test @Ignore
	void testTotalcost() {
		Logger logger=Logger.getInstance();
		int journeyId = 10202;
		int shipId = 112233;
		SeatDAOImplementation seat=new SeatDAOImplementation();
		int expected=5000;
		int actual;
		actual = seat.Totalcost(journeyId, shipId);
		logger.info("cost:" +actual);
		assertEquals(expected,actual);
	
	}

}
