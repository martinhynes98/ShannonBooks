package com.shannon.online;

public class StandardOrderFactory implements AbstractOrderFactory {
    public Order createOrder(){
        return new StandardOrder();
    }
    public Supplier createSupplier(){
        return new StandardSupplier();
    }
    public Shipping createShipping(){
        return new StandardShipping();
    }
}
