package com.shannon.online.data.supplier;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prime_supplier")
public class PrimeSupplierData extends SupplierData {
    
    public PrimeSupplierData() {}

    public PrimeSupplierData(Integer orderId){
        super(orderId);
    }
}
