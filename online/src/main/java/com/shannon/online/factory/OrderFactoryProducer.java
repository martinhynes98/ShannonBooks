package com.shannon.online.factory;

public class OrderFactoryProducer {
    public AbstractOrderFactory getOrderFactory(String orderType){
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
