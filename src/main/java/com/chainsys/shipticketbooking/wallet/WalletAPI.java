package com.chainsys.shipticketbooking.wallet;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class WalletAPI {
	public Map paywallet(long mobileNo, String merchantId, float amount) {
		try {
			String url = "https://apiwalletappin.cfapps.io";
			String apiUrl = url + "/api/walletPayment?mobilenumber=" + mobileNo + "&merchantId=" + merchantId + "&amount="
					+ amount;
			System.out.println(apiUrl);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Map> responseEntity = restTemplate.getForEntity(apiUrl, Map.class);
			Map body = responseEntity.getBody();
			System.out.println(body);
			return body;
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public HttpHeaders getHeaders() {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			return headers;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
