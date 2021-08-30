package com.shannon.online.entity.shipping;

import com.shannon.online.data.shipping.ShippingData;

import org.springframework.stereotype.Component;

@Component
public abstract class Shipping {
    public abstract ShippingData createShipping(int supplierId);
    public abstract ShippingData getShipping(int shippingId);
}
