package com.shannon.online.data.shipping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sixhour_shipping")
public class SixHourShippingData extends ShippingData {
    
    protected SixHourShippingData() {}

    public SixHourShippingData(Integer supplierId){
        super(supplierId);
    }
}
