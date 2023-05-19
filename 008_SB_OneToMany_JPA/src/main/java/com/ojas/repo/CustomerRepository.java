package com.ojas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ojas.dto.OrderResponse;
import com.ojas.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   @Query("SELECT new com.ojas.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
