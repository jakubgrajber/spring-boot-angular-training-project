package com.jgrajber.ecommerce.controller;

import com.jgrajber.ecommerce.dto.Purchase;
import com.jgrajber.ecommerce.dto.PurchaseResponse;
import com.jgrajber.ecommerce.service.CheckoutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@AllArgsConstructor
public class CheckoutController {

    private CheckoutService checkoutService;

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
