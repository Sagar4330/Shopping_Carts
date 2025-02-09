package com.Module;

import java.util.List;

public class CartState {
	
	
	 private List<CartItem> items;
	    private double subtotal;
	    private double tax;
	    private double total;

	    public CartState(List<CartItem> items, double subtotal, double tax, double total) {
	        this.items = items;
	        this.subtotal = subtotal;
	        this.tax = tax;
	        this.total = total;
	    }

	    public List<CartItem> getItems() { return items; }
	    public double getSubtotal() { return subtotal; }
	    public double getTax() { return tax; }
	    public double getTotal() { return total; }
	

}
