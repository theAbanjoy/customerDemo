package com.example.demo.CustomerService;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.DemoApplication;
import org.springframework.stereotype.Service;

import com.example.demo.CustomerDTO.CustomerDTO;
import com.example.demo.CustomerEntity.Customer;
import com.example.demo.CustomerRepository.CustomerRepository;

@Service
public class CustomerService {

    private final DemoApplication demoApplication;
	
	private CustomerRepository customerRepo;
	
	public CustomerService(CustomerRepository customerRepo, DemoApplication demoApplication) {
		// TODO Auto-generated constructor stub
		this.customerRepo = customerRepo;
		// TODO Auto-generated constructor stub
		this.demoApplication = demoApplication;
	}

	public Long addCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Customer customer = CustomerMapper.customerDTOTocustomer(customerDTO);
		
		customer.setCreatedTime(Calendar.getInstance().getTime());
		customer.setModifyTime(Calendar.getInstance().getTime());
		customer.setModifiedBy(customerDTO.getCreatedBy());
		customer.setIsDelete("N");
		customer = customerRepo.save(customer);
		
		return customer.getCustomerId();
	}

	public CustomerDTO getCustomer(Long id) {
		// TODO Auto-generated method stub
		
		Customer customer = customerRepo.findById(id).get();
		
		System.out.println(customer);
		
		return CustomerMapper.customerTocustomerDTO(customer);
		
	}

	public List<CustomerDTO> getAllCustomer(List<Long> ids) {
		// TODO Auto-generated method stub
		
		List<Customer> customerList = customerRepo.findByCustomerIdIn(ids);
		
		return customerList.stream().map(CustomerMapper::customerTocustomerDTO).collect(Collectors.toList());
	}

	public List<Long> addAllCustomers(List<CustomerDTO> customerDTOs) {
		// TODO Auto-generated method stub
		List<Customer> customers = customerDTOs.stream().map(CustomerMapper :: customerDTOTocustomer).collect(Collectors.toList());
		customers = customerRepo.saveAll(customers);
	
		
		return customers.stream().map(Customer :: getCustomerId).collect(Collectors.toList());
		
	}

	public List<CustomerDTO> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepo.findAll();
		return customers.stream().map(CustomerMapper :: customerTocustomerDTO).collect(Collectors.toList());
	}

	public Long updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Customer customer = customerRepo.findById(customerDTO.getCustomerId()).get();
		System.out.println(customer);
		if(customer != null) {
			System.out.println(1);
			System.out.println(!customerDTO.getFirstName().isBlank());
			if(customerDTO.getFirstName() != null && !customerDTO.getFirstName().isBlank()) {
				customer.setFirstName(customerDTO.getFirstName());
				System.out.println(customerDTO.getFirstName());
			}
			if(customerDTO.getLastName() != null && !customerDTO.getLastName().isBlank()) {
				customer.setLastName(customerDTO.getLastName());
			}
			if(customerDTO.getUserName() != null && !customerDTO.getUserName().isBlank()) {
				customer.setUserName(customerDTO.getUserName());
			}
			System.out.println(2);
			if(customerDTO.getEmail() != null && !customerDTO.getEmail().isBlank()) {
				customer.setEmail(customerDTO.getEmail());
			}
			if(customerDTO.getGender() != null && !customerDTO.getGender().isBlank()) {
				customer.setGender(customerDTO.getGender());
			}
			System.out.println(3);
			if(customerDTO.getMobile() != null && customerDTO.getMobile() != null) {
				customer.setMobile(customerDTO.getMobile());
			}
			if(customerDTO.getModifiedBy() != null && !customerDTO.getModifiedBy().isBlank()) {
				customer.setModifiedBy(customerDTO.getModifiedBy());
			}
			System.out.println(4);
			customer.setModifyTime(Calendar.getInstance().getTime());
			
			customer = customerRepo.save(customer);
			return customer.getCustomerId();
		}
		throw new IllegalArgumentException("failed to update Customer");
	}

	public Long deleteCustomer(Long customerId) {
		// TODO Auto-generated method stub
		Customer c = customerRepo.findById(customerId).get();
		if(c != null) {
			c.setIsDelete("Y");
			c.setModifyTime(Calendar.getInstance().getTime());
			c = customerRepo.save(c);
			return c.getCustomerId();
		}
		throw new IllegalArgumentException("Failed to delete customer- error occure in finding customer from database");
	}

	public List<Long> addCustomer(List<CustomerDTO> customerDTOs) {
		// TODO Auto-generated method stub
		List<Customer> customers = customerDTOs.stream().map(CustomerMapper::customerDTOTocustomer).collect(Collectors.toList());
		customers = customerRepo.saveAll(customers);
		List<Long> ids = customers.stream().map(Customer::getCustomerId).collect(Collectors.toList());
		return ids;
	}
	

}
