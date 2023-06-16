package com.avdhoot.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestModel {

	private int id;
	private String userName;
	private String email;
	private long phoneNumber;
	private CustomUserPersonal userPersonal;

}
