package com.shannon.online;

public interface AbstractOrderFactory {
    public abstract Order createOrder();
    public abstract Supplier createSupplier();
    public abstract Shipping createShipping();
}
