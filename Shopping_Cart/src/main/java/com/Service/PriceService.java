package com.Service;

import org.springframework.web.client.RestTemplate;

public class PriceService {
	
	
	private static final String PRICE_API_URL = "http://localhost:3001/products/";
    private final RestTemplate restTemplate;

    // Constructor injection of RestTemplate
    public PriceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double getProductPrice(String productName) {
        return restTemplate.getForObject(PRICE_API_URL + productName, Double.class);
    }

}
