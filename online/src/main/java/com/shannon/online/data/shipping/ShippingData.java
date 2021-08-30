package com.shannon.online.data.shipping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ShippingData {
    private Integer supplierId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    protected ShippingData() {}

    public ShippingData(Integer supplierId){
        this.supplierId = supplierId;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getSupplierId(){
        return this.supplierId;
    }
    public void setSupplierId(Integer supplierId){
        this.supplierId = supplierId;
    }
}
