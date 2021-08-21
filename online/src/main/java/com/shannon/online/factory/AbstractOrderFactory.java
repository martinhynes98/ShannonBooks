package com.shannon.online.factory;

import com.shannon.online.entity.order.Order;
import com.shannon.online.entity.shipping.Shipping;
import com.shannon.online.entity.supplier.Supplier;

public interface AbstractOrderFactory {
    public abstract Order createOrder();
    public abstract Supplier createSupplier();
    public abstract Shipping createShipping();
}
