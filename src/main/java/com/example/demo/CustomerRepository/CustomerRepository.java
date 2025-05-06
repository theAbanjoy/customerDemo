package com.example.demo.CustomerRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.CustomerDTO.CustomerDTO;
import com.example.demo.CustomerEntity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByCustomerIdIn(List<Long> ids);

}
