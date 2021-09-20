package com.shannon.online.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.shannon.online.data.order.OrderData;
import com.shannon.online.data.order.PrimeOrderData;
//import com.shannon.online.data.shipping.ShippingData;
import com.shannon.online.data.supplier.SupplierData;
import com.shannon.online.entity.order.Order;
import com.shannon.online.entity.shipping.Shipping;
import com.shannon.online.entity.supplier.Supplier;
import com.shannon.online.factory.AbstractOrderFactory;
import com.shannon.online.factory.OrderFactoryProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class OrderController {
    
    @Autowired
    private OrderFactoryProducer orderFactoryProducer;

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/v1/orders/{id}")
    public ResponseEntity<OrderData> getOrder(@PathVariable Integer id, @RequestParam String orderType){
        logger.info("begind getOrder id {}",id);
        AbstractOrderFactory orderFactory = orderFactoryProducer.getOrderFactory(orderType);
        Order order = orderFactory.createOrder();
        try{
            return new ResponseEntity<OrderData>(order.getOrder(id),HttpStatus.OK);
        }catch(NoSuchElementException e){
            logger.warn("Could not find order with id {}",id);
        }finally {
            logger.info("end getOrder id {}", id);
        }
        return new ResponseEntity<OrderData>(new PrimeOrderData(),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/v1/orders")
    public ResponseEntity<List<OrderData>> getOrders(@RequestParam String orderType){
        AbstractOrderFactory orderFactory = orderFactoryProducer.getOrderFactory(orderType);
        Order order = orderFactory.createOrder();
        return new ResponseEntity<List<OrderData>>(order.getOrders(), HttpStatus.OK);
    }

    @PostMapping("/v1/orders")
    @ResponseBody
    public ResponseEntity<OrderData> createOrder(@RequestBody Map<String,Object> body){
        AbstractOrderFactory orderFactory = orderFactoryProducer.getOrderFactory(body.get("orderType").toString());
        Order order = orderFactory.createOrder();
        Supplier supplier = orderFactory.createSupplier();
        Shipping shipping = orderFactory.createShipping();
        OrderData orderData = order.createOrder(Integer.parseInt(body.get("customerId").toString()), Integer.parseInt(body.get("productId").toString()));
        SupplierData supplierData = supplier.createSupplier(orderData.getId());
        shipping.createShipping(supplierData.getId());

        return new ResponseEntity<OrderData>(orderData, HttpStatus.CREATED);
    }
}
