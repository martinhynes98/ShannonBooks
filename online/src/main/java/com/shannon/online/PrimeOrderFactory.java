package com.shannon.online;

public class PrimeOrderFactory implements AbstractOrderFactory {
    public Order createOrder(){
        return new PrimeOrder();
    }
    public Supplier createSupplier(){
        return new PrimeSupplier();
    }
    public Shipping createShipping(){
        return new PrimeShipping();
    }
}
