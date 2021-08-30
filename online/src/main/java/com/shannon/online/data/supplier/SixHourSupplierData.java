package com.shannon.online.data.supplier;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sixhour_supplier")
public class SixHourSupplierData extends SupplierData {
    
    protected SixHourSupplierData() {}

    public SixHourSupplierData(Integer orderId){
        super(orderId);
    }
}
