package com.shannon.online.factory;

import com.shannon.online.entity.order.Order;
import com.shannon.online.entity.order.PrimeOrder;
import com.shannon.online.entity.shipping.PrimeShipping;
import com.shannon.online.entity.shipping.Shipping;
import com.shannon.online.entity.supplier.PrimeSupplier;
import com.shannon.online.entity.supplier.Supplier;

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
