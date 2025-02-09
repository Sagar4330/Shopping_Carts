package com.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.Module.CartState;
import com.Service.CartService;
import com.Service.PriceService;

public class CartServiceTest {
	
	private final PriceService priceService = Mockito.mock(PriceService.class);
    private final CartService cartService = new CartService(priceService);

    @Test
    void testCartCalculations() {
        Mockito.when(priceService.getProductPrice("cornflakes")).thenReturn(2.52);
        Mockito.when(priceService.getProductPrice("weetabix")).thenReturn(9.98);

        cartService.addProduct("cornflakes", 2);
        cartService.addProduct("weetabix", 1);

        CartState cartState = cartService.getCartState();

        assertEquals(15.02, cartState.getSubtotal());
        assertEquals(1.88, cartState.getTax());
        assertEquals(16.90, cartState.getTotal());
    }
	
	

}
