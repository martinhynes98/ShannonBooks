package com.shannon.online.data.order;

import org.springframework.data.repository.CrudRepository;

public interface StandardOrderRepository extends CrudRepository<StandardOrderData, Integer> {
    
}