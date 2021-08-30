package com.shannon.online.data.order;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="prime_orders")
public class PrimeOrderData extends OrderData {
    
    protected PrimeOrderData() {}

    public PrimeOrderData(Integer customerId, Integer productId){
        super(customerId, productId);
    }
}
