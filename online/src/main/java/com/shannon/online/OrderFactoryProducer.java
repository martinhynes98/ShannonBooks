package com.shannon.online;

public class OrderFactoryProducer {
    protected AbstractOrderFactory getOrderFactory(String orderType){
        //Switch case allows for more order types to easily be added
        switch(orderType){
            case "prime":
                return new PrimeOrderFactory();
            case "sixhour":
                return new SixHourOrderFactory();
        }
        //Standard order is the default case
        return new StandardOrderFactory();
    }
}
