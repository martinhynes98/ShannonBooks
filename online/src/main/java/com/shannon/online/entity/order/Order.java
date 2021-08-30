package com.shannon.online.entity.order;

import org.springframework.stereotype.Component;
import com.shannon.online.data.order.OrderData;

@Component
public abstract class Order {
    public abstract OrderData createOrder(int customerId, int productId);
    public abstract OrderData getOrder(int orderId);
}
