package com.shannon.online;

public abstract class Order {
    protected abstract int processOrder(int customerId, int productId);
}
