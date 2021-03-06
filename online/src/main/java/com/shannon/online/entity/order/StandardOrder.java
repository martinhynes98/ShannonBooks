package com.shannon.online.entity.order;

import com.shannon.online.data.order.OrderData;
import com.shannon.online.data.order.StandardOrderData;
import com.shannon.online.data.order.StandardOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class StandardOrder extends Order{

    @Autowired
    StandardOrderRepository standardOrderRepository;

    @Override
    public OrderData createOrder(int customerId, int productId){
        OrderData orderData = standardOrderRepository.save(new StandardOrderData(customerId, productId));
        return orderData;
    }

    @Override
    public OrderData getOrder(int orderId){
        OrderData orderData = standardOrderRepository.findById(orderId).get();
        return orderData;
    }

    @Override
    public List<OrderData> getOrders(){
        Iterable<StandardOrderData> orders = standardOrderRepository.findAll();
        List<OrderData> orderData = new ArrayList<OrderData>();
        orders.forEach(orderData::add);
        return orderData;
    }

}
