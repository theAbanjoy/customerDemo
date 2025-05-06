package com.example.demo.CustomerService;

import java.util.Calendar;

import com.example.demo.CustomerDTO.CustomerDTO;
import com.example.demo.CustomerEntity.Customer;

public class CustomerMapper {
	
	public static Customer customerDTOTocustomer(CustomerDTO customerDTO) {
		
		Customer customer = new Customer();
		
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setUserName(customerDTO.getUserName());
		customer.setEmail(customerDTO.getEmail());
		customer.setMobile(customerDTO.getMobile());
		customer.setGender(customerDTO.getGender());
		customer.setCreatedTime(customerDTO.getCreatedTime());
		customer.setCreatedBy(customerDTO.getCreatedBy());
		customer.setModifiedBy(customerDTO.getModifiedBy());
		customer.setModifyTime(customerDTO.getModifyTime());
		customer.setIsDelete(customerDTO.getIsDelete());
		
		return customer;
		
	}
	
	public static CustomerDTO customerTocustomerDTO(Customer customer) {
			
			CustomerDTO customerDTO = new CustomerDTO();
			
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setFirstName(customer.getFirstName());
			customerDTO.setLastName(customer.getLastName());
			customerDTO.setUserName(customer.getUserName());
			customerDTO.setEmail(customer.getEmail());
			customerDTO.setMobile(customer.getMobile());
			customerDTO.setGender(customer.getGender());
			customerDTO.setCreatedTime(customer.getCreatedTime());
			customerDTO.setCreatedBy(customer.getCreatedBy());
			customerDTO.setModifiedBy(customer.getModifiedBy());
			customerDTO.setModifyTime(customer.getModifyTime());
			customerDTO.setIsDelete(customer.getIsDelete());
			
			return customerDTO;
			
		}

}
