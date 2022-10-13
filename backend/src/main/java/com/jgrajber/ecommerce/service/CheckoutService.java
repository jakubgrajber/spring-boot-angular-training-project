package com.jgrajber.ecommerce.service;

import com.jgrajber.ecommerce.dto.PaymentInfo;
import com.jgrajber.ecommerce.dto.Purchase;
import com.jgrajber.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
