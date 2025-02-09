package com.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.Module.CartItem;
import com.Module.CartState;

public class CartService {

	private final PriceService priceService;
    private final List<CartItem> cartItems = new ArrayList<>();
    private static final double TAX_RATE = 0.125; // 12.5%

    public CartService(PriceService priceService) {
        this.priceService = priceService;
    }

    public void addProduct(String productName, int quantity) {
        double price = priceService.getProductPrice(productName);

        for (CartItem item : cartItems) {
            if (item.getName().equalsIgnoreCase(productName)) {
                item.addQuantity(quantity);
                return;
            }
        }

        cartItems.add(new CartItem(productName, quantity, price));
    }

    public CartState getCartState() {
        double subtotal = cartItems.stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();

        double tax = roundUp(subtotal * TAX_RATE);
        double total = roundUp(subtotal + tax);

        return new CartState(cartItems, subtotal, tax, total);
    }

    private double roundUp(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
	
}
