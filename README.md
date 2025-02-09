Spring Boot Shopping Cart Solution
Project Overview
This is a simple Java-based shopping cart implemented using Spring Boot. The cart retrieves product prices from an external Price API, calculates totals, and maintains cart state. It includes:

Adding products to the cart (with quantity)
Fetching product prices from an external API (http://localhost:3001/products/{product})
Calculating:
Subtotal (sum of product prices)
Tax (12.5% of subtotal)
Total Payable (subtotal + tax)
Unit tests for business logic.
