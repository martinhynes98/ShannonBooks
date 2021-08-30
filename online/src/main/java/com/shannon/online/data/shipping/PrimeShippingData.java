package com.shannon.online.data.shipping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prime_shipping")
public class PrimeShippingData extends ShippingData {
    
    protected PrimeShippingData() {}

    public PrimeShippingData(Integer supplierId){
        super(supplierId);
    }
}
