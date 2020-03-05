package com.chainsys.shipticketbooking.wallet;

import org.springframework.http.MediaType;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

public class WalletAPI {
	public Map paywallet(long mobileNo, String merchantId, float amount) {
		String url = "https://apiwalletappin.cfapps.io";
		String apiUrl = url + "/api/walletPayment?mobilenumber=" + mobileNo + "&merchantId=" + merchantId + "&amount="
				+ amount;
		System.out.println(apiUrl);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> responseEntity = restTemplate.getForEntity(apiUrl, Map.class);
		Map body = responseEntity.getBody();
		System.out.println(body);
		return body;
	}

	public HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
