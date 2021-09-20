package com.shannon.online.data.order;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sixhour_orders")
public class SixHourOrderData extends OrderData {
    
    public SixHourOrderData() {}

    public SixHourOrderData(Integer customerId, Integer productId){
        super(customerId, productId);
    }
}
