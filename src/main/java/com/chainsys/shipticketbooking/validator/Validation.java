package com.chainsys.shipticketbooking.validator;

import com.chainsys.shipticketbooking.errorMessage.ErrorMessages;
import com.chainsys.shipticketbooking.exception.ValidatorException;
import com.chainsys.shipticketbooking.logger.Logger;

public class Validation {
	Logger logger=Logger.getInstance();
	public void validatesearchforuser(int userId, String password) throws ValidatorException {
		if (userId == 0) {
			// throw new ValidatorException("Invalid userid");
			logger.error(ErrorMessages.INVALID_VALIDATE_USER);

		} else if (password == null || password.equals("") || password.trim().equals("")) {
			// throw new ValidatorException("Invalid password");
			logger.error(ErrorMessages.INVALID_VALIDATE_PASSWORD);
		}
	}
	public void validatesearchforadmin(int adminId, String pass) throws ValidatorException {
		if (adminId == 0) {
			// throw new ValidatorException("Invalid admin");
			logger.error(ErrorMessages.INVALID_VALIDATE_USER);

		} else if (pass == null || pass.equals("") || pass.trim().equals("")) {
			// throw new ValidatorException("Invalid password");
			logger.error(ErrorMessages.INVALID_VALIDATE_PASSWORD);
		}
	}


}
