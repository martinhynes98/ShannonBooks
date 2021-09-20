package com.shannon.online.data.supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class SupplierData {
    private Integer orderId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public SupplierData() {}

    public SupplierData(Integer orderId){
        this.orderId = orderId;
    }

    public Integer getOrderId(){
        return this.orderId;
    }
    public void setOrderId(Integer orderId){
        this.orderId = orderId;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
}
