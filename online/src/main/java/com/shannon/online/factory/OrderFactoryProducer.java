package com.shannon.online.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFactoryProducer {

    @Autowired
    PrimeOrderFactory prime;
    @Autowired
    StandardOrderFactory standard;
    @Autowired
    SixHourOrderFactory sixHour;
    public AbstractOrderFactory getOrderFactory(String orderType){
        //Switch case allows for more order types to easily be added
        switch(orderType){
            case "prime":
                return prime;
            case "sixhour":
                return sixHour;
        }
        //Standard order is the default case
        return standard;
    }
}
