package com.avdhoot.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "user_personal")
public class UserPersonal {
	@Id
	@Column(name = "id")
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fullName;
	private String gender;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="id")
	private User user;
	
	public UserPersonal(String firstName, String middleName, String lastName, String gender) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.fullName = firstName+" "+middleName+" "+lastName;
	}
}
