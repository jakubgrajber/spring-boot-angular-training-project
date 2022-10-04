package com.jgrajber.ecommerce.service;

import com.jgrajber.ecommerce.dto.Purchase;
import com.jgrajber.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
