package com.shannon.online.factory;

import com.shannon.online.entity.order.Order;
import com.shannon.online.entity.order.StandardOrder;
import com.shannon.online.entity.shipping.Shipping;
import com.shannon.online.entity.shipping.StandardShipping;
import com.shannon.online.entity.supplier.StandardSupplier;
import com.shannon.online.entity.supplier.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StandardOrderFactory implements AbstractOrderFactory {

    @Autowired
    private StandardOrder order;
    @Autowired
    private StandardSupplier supplier;
    @Autowired
    private StandardShipping shipping;

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
