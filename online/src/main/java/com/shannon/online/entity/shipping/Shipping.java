package com.shannon.online.entity.shipping;

import org.springframework.stereotype.Component;

@Component
public abstract class Shipping {
    public abstract int processShipping(int supplierId);
}
