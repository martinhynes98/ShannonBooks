package com.shannon.online.entity.supplier;

import com.shannon.online.data.supplier.StandardSupplierData;
import com.shannon.online.data.supplier.StandardSupplierRepository;
import com.shannon.online.data.supplier.SupplierData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class StandardSupplier extends Supplier{

    @Autowired
    StandardSupplierRepository standardSupplierRepository;

    @Override
    public SupplierData createSupplier(int orderId){
        SupplierData supplierData = standardSupplierRepository.save(new StandardSupplierData(orderId));
        return supplierData;
    }

    @Override
    public SupplierData getSupplier(int supplierId){
        SupplierData supplierData = standardSupplierRepository.findById(supplierId).get();
        return supplierData;
    }

    @Override
    public List<SupplierData> getSuppliers(){
        Iterable<StandardSupplierData> supplier = standardSupplierRepository.findAll();
        List<SupplierData> supplierData = new ArrayList<SupplierData>();
        supplier.forEach(supplierData::add);
        return supplierData;
    }
}
