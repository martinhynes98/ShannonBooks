package com.shannon.online;

public class SixHourOrderFactory implements AbstractOrderFactory {
    public Order createOrder(){
        return new SixHourOrder();
    }
    public Supplier createSupplier(){
        return new SixHourSupplier();
    }
    public Shipping createShipping(){
        return new SixHourShipping();
    }
}
