package com.example.demo.CustomerDTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	
	private Long customerId;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String gender;
	private Long mobile;
	private String isDelete;
	private String createdBy;
	private Date createdTime;
	private String modifiedBy;
    private Date modifyTime;

}
