package com.chainsys.shipticketbooking.wallet;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.chainsys.shipticketbooking.errorMessage.ErrorMessages;
import com.chainsys.shipticketbooking.exception.DBException;
import com.chainsys.shipticketbooking.logger.Logger;

public class WalletAPI {
	public Map paywallet(long mobileNo, String merchantId, float amount) {
		Logger logger = Logger.getInstance();
		try {
			String url = "https://apiwalletappin.cfapps.io";
			String apiUrl = url + "/api/walletPayment?mobilenumber=" + mobileNo + "&merchantId=" + merchantId
					+ "&amount=" + amount;
			logger.info(apiUrl);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Map> responseEntity = restTemplate.getForEntity(apiUrl, Map.class);
			Map body = responseEntity.getBody();
			logger.debug(body);
			return body;
		} catch (RestClientException e) {
			e.printStackTrace();
			throw new RestClientException("INVALID API EXCEPTION", e);
		}
	}

	public HttpHeaders getHeaders() throws DBException {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			return headers;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorMessages.INVALID_DB_EXCEPTION, e);
		}
	}
}
