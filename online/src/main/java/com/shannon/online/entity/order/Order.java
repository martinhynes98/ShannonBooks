package com.shannon.online.entity.order;

public abstract class Order {
    protected abstract int processOrder(int customerId, int productId);
}
