package com.shannon.online.entity.supplier;

import com.shannon.online.data.supplier.SupplierData;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class Supplier {
    public abstract SupplierData createSupplier(int orderId);
    public abstract SupplierData getSupplier(int supplierId);
    public abstract List<SupplierData> getSuppliers();
}
