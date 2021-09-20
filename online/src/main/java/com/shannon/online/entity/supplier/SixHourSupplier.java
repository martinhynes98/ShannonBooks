package com.shannon.online.entity.supplier;

import com.shannon.online.data.supplier.SixHourSupplierData;
import com.shannon.online.data.supplier.SixHourSupplierRepository;
import com.shannon.online.data.supplier.SupplierData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;

@Component
public class SixHourSupplier extends Supplier{

    @Autowired
    SixHourSupplierRepository sixHourSupplierRepository;

    @Override
    public SupplierData createSupplier(int orderId){
        SupplierData supplierData = sixHourSupplierRepository.save(new SixHourSupplierData(orderId));
        return supplierData;
    }

    @Override
    public SupplierData getSupplier(int supplierId){
        SupplierData supplierData = sixHourSupplierRepository.findById(supplierId).get();
        return supplierData;
    }

    @Override
    public List<SupplierData> getSuppliers(){
        Iterable<SixHourSupplierData> supplier = sixHourSupplierRepository.findAll();
        List<SupplierData> supplierData = new ArrayList<SupplierData>();
        supplier.forEach(supplierData::add);
        return supplierData;
    }
}
