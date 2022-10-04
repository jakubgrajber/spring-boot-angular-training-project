package com.jgrajber.ecommerce.dto;

import com.jgrajber.ecommerce.entity.Address;
import com.jgrajber.ecommerce.entity.Customer;
import com.jgrajber.ecommerce.entity.Order;
import com.jgrajber.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
