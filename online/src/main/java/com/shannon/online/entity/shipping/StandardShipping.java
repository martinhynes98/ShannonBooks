package com.shannon.online.entity.shipping;

import org.springframework.stereotype.Component;

@Component
public class StandardShipping extends Shipping{
    public int processShipping(int supplierId){
        return 0;
    }
}
