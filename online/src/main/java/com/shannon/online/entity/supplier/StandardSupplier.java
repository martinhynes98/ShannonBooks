package com.shannon.online.entity.supplier;

import com.shannon.online.data.supplier.StandardSupplierData;
import com.shannon.online.data.supplier.StandardSupplierRepository;
import com.shannon.online.data.supplier.SupplierData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
        List<SupplierData> supplierData = (List<SupplierData>) (List<? extends SupplierData>)standardSupplierRepository.findAll();
        return supplierData;
    }
}
