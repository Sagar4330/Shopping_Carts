package com.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import com.Service.PriceService;

public class PriceServiceTest {
	
	 private RestTemplate restTemplateMock;
	    private PriceService priceService;

	    @BeforeEach
	    void setUp() {
	        restTemplateMock = Mockito.mock(RestTemplate.class);
	        priceService = new PriceService(restTemplateMock);
	    }

	    @Test
	    void testGetProductPrice() {
	        // Mock API response
	        when(restTemplateMock.getForObject(anyString(), Mockito.eq(Double.class))).thenReturn(2.52);

	        // Simulate fetching price for "cornflakes"
	        double price = priceService.getProductPrice("cornflakes");

	        // Validate the expected price
	        assertEquals(2.52, price);
	    }
	

}
