package com.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Module.CartState;
import com.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	
	    private final CartService cartService;

	    public CartController(CartService cartService) {
	        this.cartService = cartService;
	    }

	    @PostMapping("/add")
	    public String addProduct(@RequestParam String name, @RequestParam int quantity) {
	        cartService.addProduct(name, quantity);
	        return "Added " + quantity + " x " + name + " to cart.";
	    }

	    @GetMapping("/state")
	    public CartState getCartState() {
	        return cartService.getCartState();
	    }
	

}
