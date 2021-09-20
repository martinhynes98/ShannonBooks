package com.shannon.online.entity.supplier;

import com.shannon.online.data.supplier.PrimeSupplierData;
import com.shannon.online.data.supplier.PrimeSupplierRepository;
import com.shannon.online.data.supplier.SupplierData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class PrimeSupplier extends Supplier{

    @Autowired
    PrimeSupplierRepository primeSupplierRepository;

    @Override
    public SupplierData createSupplier(int orderId){
        SupplierData supplierData = primeSupplierRepository.save(new PrimeSupplierData(orderId));
        return supplierData;
    }

    @Override
    public SupplierData getSupplier(int supplierId){
        SupplierData supplierData = primeSupplierRepository.findById(supplierId).get();
        return supplierData;
    }

    @Override
    public List<SupplierData> getSuppliers(){
        Iterable<PrimeSupplierData> supplier = primeSupplierRepository.findAll();
        List<SupplierData> supplierData = new ArrayList<SupplierData>();
        supplier.forEach(supplierData::add);
        return supplierData;
    }
}
