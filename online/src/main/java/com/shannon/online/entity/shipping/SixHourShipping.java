package com.shannon.online.entity.shipping;

import com.shannon.online.data.shipping.ShippingData;
import com.shannon.online.data.shipping.SixHourShippingData;
import com.shannon.online.data.shipping.SixHourShippingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SixHourShipping extends Shipping{

    @Autowired
    SixHourShippingRepository sixHourShippingRepository;

    @Override
    public ShippingData createShipping(int supplierId){
        ShippingData shippingData = sixHourShippingRepository.save(new SixHourShippingData(supplierId));
        return shippingData;
    }

    @Override
    public ShippingData getShipping(int shippingId){
        ShippingData shippingData = sixHourShippingRepository.findById(shippingId).get();
        return shippingData;
    }

    @Override
    public List<ShippingData> getShippings(){
        List<ShippingData> shippingData = (List<ShippingData>) (List<? extends ShippingData>)sixHourShippingRepository.findAll();
        return shippingData;
    }
}
