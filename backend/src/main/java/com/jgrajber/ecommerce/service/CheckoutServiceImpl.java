package com.jgrajber.ecommerce.service;

import com.jgrajber.ecommerce.dao.CustomerRepository;
import com.jgrajber.ecommerce.dto.Purchase;
import com.jgrajber.ecommerce.dto.PurchaseResponse;
import com.jgrajber.ecommerce.entity.Customer;
import com.jgrajber.ecommerce.entity.Order;
import com.jgrajber.ecommerce.entity.OrderItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(order::add);

        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        Customer customerFromDB = customerRepository.findByEmail(customer.getEmail());
        if (customerFromDB != null) {
            customer = customerFromDB;
        }
        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}
