package com.shannon.online.data.shipping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prime_shipping")
public class PrimeShippingData extends ShippingData {
    
    public PrimeShippingData() {}

    public PrimeShippingData(Integer supplierId){
        super(supplierId);
    }
}
