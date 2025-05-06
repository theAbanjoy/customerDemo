package com.example.demo.CustomerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CustomerDTO.CustomerDTO;
import com.example.demo.CustomerService.CustomerService;

@RestController
@RequestMapping("/demo/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) {
		
		Long id =customerService.addCustomer(customerDTO);
		
		if(id != null ) {
			return ResponseEntity.ok("Customer is added Successfully with id "+ id);
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Customer is not added");
	}
	
//	@PostMapping("/addAll")
//	public ResponseEntity<?> addCustomer(@RequestBody List<CustomerDTO> customerDTOs) {
//		try {
//		
//			List<Long> id =customerService.addCustomer(customerDTOs);
//			return ResponseEntity.ok("Customer is added Successfully with id "+ id);
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Customer is not added");
//		}
//	}
	
	@GetMapping("/get/{id}")
	public CustomerDTO getCustomer(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}
	
	@GetMapping("/getSome")
	public List<CustomerDTO> getCustomer(@RequestBody List<Long> idList) {
		return customerService.getAllCustomer(idList);
	}
	
	@GetMapping("/getAll")
	public List<CustomerDTO> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addCustomers(@RequestBody List<CustomerDTO> customerDTOs) {
		
		try {
			List<Long> ids =customerService.addAllCustomers(customerDTOs);
			return ResponseEntity.ok("Customer is added Successfully with id "+ ids);
		} catch (Exception e) {
			// TODO: handle exception
			
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Customers is not added - an error occured");
	
		}
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody CustomerDTO customerDTO) {
		try {
			Long id =customerService.updateCustomer(customerDTO);
			return ResponseEntity.ok("Customer is updated Successfully with id "+ id);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Customers is not updated - an error occured");
		}
	}
	
	@PostMapping("/delete/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") Long customerId) {
		try {
			Long id =customerService.deleteCustomer(customerId);
			return ResponseEntity.ok("Customer is Delete Successfully with id "+ id);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Customers is not Deleted - an error occured");
		}
	}
	
}
