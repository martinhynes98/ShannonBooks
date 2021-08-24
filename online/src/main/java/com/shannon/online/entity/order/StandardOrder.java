package com.shannon.online.entity.order;

import org.springframework.stereotype.Component;

@Component
public class StandardOrder extends Order{
    public int processOrder(int customerId, int productId){
        return 0;
    }
}
