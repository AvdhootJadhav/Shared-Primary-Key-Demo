package com.avdhoot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avdhoot.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
