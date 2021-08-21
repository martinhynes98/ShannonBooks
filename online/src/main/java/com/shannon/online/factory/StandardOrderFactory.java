package com.shannon.online.factory;

import com.shannon.online.entity.order.Order;
import com.shannon.online.entity.order.StandardOrder;
import com.shannon.online.entity.shipping.Shipping;
import com.shannon.online.entity.shipping.StandardShipping;
import com.shannon.online.entity.supplier.StandardSupplier;
import com.shannon.online.entity.supplier.Supplier;

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
