package com.example.demo.CustomerEntity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customerId")
	private Long customerId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="userName")
	private String userName;
	@Column(name="email")
	private String email;
	@Column(name="gender")
	private String gender;
	@Column(name="mobile")
	private Long mobile;
	@Column(name="isDelete")
	private String isDelete;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="createdTime")
	private Date createdTime;
	@Column(name="modifiedBy")
	private String modifiedBy;
	@Column(name="modifyTime")
    private Date modifyTime;
	
	
	
	
	
	
	

}
