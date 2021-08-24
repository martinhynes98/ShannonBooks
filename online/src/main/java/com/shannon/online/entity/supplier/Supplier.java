package com.shannon.online.entity.supplier;

import org.springframework.stereotype.Component;

@Component
public abstract class Supplier {
    public abstract int processSupplier(int orderId);
}
