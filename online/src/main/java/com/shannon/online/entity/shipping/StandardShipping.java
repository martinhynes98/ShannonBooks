package com.shannon.online.entity.shipping;

import com.shannon.online.data.shipping.ShippingData;
import com.shannon.online.data.shipping.StandardShippingData;
import com.shannon.online.data.shipping.StandardShippingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class StandardShipping extends Shipping{

    @Autowired
    StandardShippingRepository standardShippingRepository;

    @Override
    public ShippingData createShipping(int supplierId){
        ShippingData shippingData = standardShippingRepository.save(new StandardShippingData(supplierId));
        return shippingData;
    }

    @Override
    public ShippingData getShipping(int shippingId){
        ShippingData shippingData = standardShippingRepository.findById(shippingId).get();
        return shippingData;
    }

    @Override
    public List<ShippingData> getShippings(){
        Iterable<StandardShippingData> shipping = standardShippingRepository.findAll();
        List<ShippingData> shippingData = new ArrayList<ShippingData>();
        shipping.forEach(shippingData::add);
        return shippingData;
    }
}
