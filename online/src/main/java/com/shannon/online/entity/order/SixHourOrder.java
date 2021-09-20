package com.shannon.online.entity.order;

import com.shannon.online.data.order.OrderData;
import com.shannon.online.data.order.SixHourOrderData;
import com.shannon.online.data.order.SixHourOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class SixHourOrder extends Order{

    @Autowired
    SixHourOrderRepository sixHourOrderRepository;

    @Override
    public OrderData createOrder(int customerId, int productId){
        OrderData orderData = sixHourOrderRepository.save(new SixHourOrderData(customerId, productId));
        return orderData;
    }

    @Override
    public OrderData getOrder(int orderId){
        OrderData orderData = sixHourOrderRepository.findById(orderId).get();
        return orderData;
    }

    @Override
    public List<OrderData> getOrders(){
        Iterable<SixHourOrderData> orders = sixHourOrderRepository.findAll();
        List<OrderData> orderData = new ArrayList<OrderData>();
        orders.forEach(orderData::add);
        return orderData;
    }
}
