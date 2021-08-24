package com.shannon.online.factory;

import com.shannon.online.entity.order.Order;
import com.shannon.online.entity.order.SixHourOrder;
import com.shannon.online.entity.shipping.Shipping;
import com.shannon.online.entity.shipping.SixHourShipping;
import com.shannon.online.entity.supplier.SixHourSupplier;
import com.shannon.online.entity.supplier.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SixHourOrderFactory implements AbstractOrderFactory {

    @Autowired
    private SixHourOrder order;
    @Autowired
    private SixHourSupplier supplier;
    @Autowired
    private SixHourShipping shipping;

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
