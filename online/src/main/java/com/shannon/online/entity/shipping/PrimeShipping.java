package com.shannon.online.entity.shipping;

import org.springframework.stereotype.Component;

@Component
public class PrimeShipping extends Shipping{
    public int processShipping(int supplierId){
        return 0;
    }
}
