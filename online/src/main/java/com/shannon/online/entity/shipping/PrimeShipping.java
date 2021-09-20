package com.shannon.online.entity.shipping;

import com.shannon.online.data.shipping.PrimeShippingData;
import com.shannon.online.data.shipping.PrimeShippingRepository;
import com.shannon.online.data.shipping.ShippingData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrimeShipping extends Shipping{

    @Autowired
    PrimeShippingRepository primeShippingRepository;

    @Override
    public ShippingData createShipping(int supplierId){
        ShippingData shippingData = primeShippingRepository.save(new PrimeShippingData(supplierId));
        return shippingData;
    }

    @Override
    public ShippingData getShipping(int shippingId){
        ShippingData shippingData = primeShippingRepository.findById(shippingId).get();
        return shippingData;
    }

    @Override
    public List<ShippingData> getShippings(){
        List<ShippingData> shippingData = (List<ShippingData>) (List<? extends ShippingData>)primeShippingRepository.findAll();
        return shippingData;
    }
}
