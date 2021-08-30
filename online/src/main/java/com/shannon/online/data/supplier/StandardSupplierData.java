package com.shannon.online.data.supplier;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="standard_supplier")
public class StandardSupplierData extends SupplierData {
    
    protected StandardSupplierData() {}

    public StandardSupplierData(Integer orderId){
        super(orderId);
    }
}
