package com.shannon.online.entity.order;

import com.shannon.online.data.order.OrderData;
import com.shannon.online.data.order.PrimeOrderData;
import com.shannon.online.data.order.PrimeOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrimeOrder extends Order{

    @Autowired
    PrimeOrderRepository primeOrderRepository;
    
    @Override
    public OrderData createOrder(int customerId, int productId){
        OrderData orderData = primeOrderRepository.save(new PrimeOrderData(customerId, productId));
        return orderData;
    }

    @Override
    public OrderData getOrder(int orderId){
        OrderData orderData = primeOrderRepository.findById(orderId).get();
        return orderData;
    }

    @Override
    public List<OrderData> getOrders(){
        List<OrderData> orderData = (List<OrderData>) (List<? extends OrderData>)primeOrderRepository.findAll();
        return orderData;
    }
}
