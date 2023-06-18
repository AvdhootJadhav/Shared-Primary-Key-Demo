package com.avdhoot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avdhoot.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Modifying
	@Query(value="UPDATE user SET user.email = :email, user.phone_number = :phoneNumber, user.user_name = :userName WHERE user.id = :id",nativeQuery = true)
	void saveUser(int id, String userName, String email, long phoneNumber);

	@Modifying
	@Query(value = "UPDATE user_personal u SET u.first_name = :firstName, u.last_name = :lastName, u.middle_name = :middleName, u.full_name = :fullName, u.gender = :gender WHERE u.id = :id",nativeQuery = true)
	void saveUserPersonal(int id, String firstName, String middleName, String lastName, String gender, String fullName);
	
}
