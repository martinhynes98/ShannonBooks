package com.shannon.online.entity.order;

import org.springframework.stereotype.Component;

@Component
public abstract class Order {
    public abstract int processOrder(int customerId, int productId);
}
