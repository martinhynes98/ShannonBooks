package com.shannon.online.factory;

import com.shannon.online.entity.order.Order;
import com.shannon.online.entity.order.SixHourOrder;
import com.shannon.online.entity.shipping.Shipping;
import com.shannon.online.entity.shipping.SixHourShipping;
import com.shannon.online.entity.supplier.SixHourSupplier;
import com.shannon.online.entity.supplier.Supplier;

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
