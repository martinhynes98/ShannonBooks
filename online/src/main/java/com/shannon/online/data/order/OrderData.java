package com.shannon.online.data.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class OrderData {
    
    private Integer customerId;
    private Integer productId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    protected OrderData() {}

    public OrderData(Integer customerId, Integer productId){
        this.customerId = customerId;
        this.productId = productId;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getCustomerId(){
        return this.customerId;
    }
    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
    }

    public Integer getProductId(){
        return this.productId;
    }
    public void setProductId(Integer productId){
        this.productId = productId;
    }

    
}
