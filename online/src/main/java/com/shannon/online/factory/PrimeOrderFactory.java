package com.shannon.online.factory;

import com.shannon.online.entity.order.Order;
import com.shannon.online.entity.order.PrimeOrder;
import com.shannon.online.entity.shipping.PrimeShipping;
import com.shannon.online.entity.shipping.Shipping;
import com.shannon.online.entity.supplier.PrimeSupplier;
import com.shannon.online.entity.supplier.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrimeOrderFactory implements AbstractOrderFactory {

    @Autowired
    private PrimeOrder order;
    @Autowired
    private PrimeSupplier supplier;
    @Autowired
    private PrimeShipping shipping;
    

    public Order createOrder(){
        return order;
    }
    public Supplier createSupplier(){
        return supplier;
    }
    public Shipping createShipping(){
        return shipping;
    }
}
