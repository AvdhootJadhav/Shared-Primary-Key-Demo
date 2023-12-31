package com.avdhoot.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomUserPersonal {
	private String firstName;
	private String middleName;
	private String lastName;
	private String fullName;
	private String gender;
	
	@Override
	public String toString() {
		return "CustomUserPersonal [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", fullName=" + fullName + ", gender=" + gender + "]";
	}
	
	
}
