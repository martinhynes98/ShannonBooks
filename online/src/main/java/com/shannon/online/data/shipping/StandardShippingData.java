package com.shannon.online.data.shipping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="standard_shipping")
public class StandardShippingData extends ShippingData {
    
    protected StandardShippingData() {}

    public StandardShippingData(Integer supplierId){
        super(supplierId);
    }
}
