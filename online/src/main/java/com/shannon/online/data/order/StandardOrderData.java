package com.shannon.online.data.order;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="standard_orders")
public class StandardOrderData extends OrderData {
    
    protected StandardOrderData() {}

    public StandardOrderData(Integer customerId, Integer productId){
        super(customerId, productId);
    }
}
