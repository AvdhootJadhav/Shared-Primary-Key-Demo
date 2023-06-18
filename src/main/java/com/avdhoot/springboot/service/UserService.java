package com.avdhoot.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avdhoot.springboot.entity.User;
import com.avdhoot.springboot.entity.UserPersonal;
import com.avdhoot.springboot.model.CustomUserPersonal;
import com.avdhoot.springboot.model.RequestModel;
import com.avdhoot.springboot.model.ResponseModel;
import com.avdhoot.springboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public ResponseModel addUsers(RequestModel model) {
		User user = new User(model.getEmail(), model.getPhoneNumber(), model.getUserName());
		CustomUserPersonal userPersonal = model.getUserPersonal();

		UserPersonal personal = new UserPersonal(userPersonal.getFirstName(), userPersonal.getMiddleName(),
				userPersonal.getLastName(), userPersonal.getGender());
		personal.setUser(user);

		System.out.println(userPersonal);

		user.setUserPersonal(personal);

		repository.save(user);

		return new ResponseModel(true, "User added successfully");
	}

	public List<RequestModel> getUsers() {
		List<User> users = repository.findAll();

		List<RequestModel> result = users.stream()
				.map(x -> new RequestModel(x.getId(), x.getUserName(), x.getEmail(), x.getPhoneNumber(),
						new CustomUserPersonal(x.getUserPersonal().getFirstName(), x.getUserPersonal().getMiddleName(),
								x.getUserPersonal().getLastName(), x.getUserPersonal().getFullName(),
								x.getUserPersonal().getGender())))
				.collect(Collectors.toList());

		System.out.println(result);

		return result;
	}

	public RequestModel getUserById(int id) {
		User user = repository.findById(id).get();

		RequestModel model = new RequestModel(id, user.getUserName(), user.getEmail(), user.getPhoneNumber(),
				new CustomUserPersonal(user.getUserPersonal().getFirstName(), user.getUserPersonal().getMiddleName(),
						user.getUserPersonal().getLastName(), user.getUserPersonal().getFullName(),
						user.getUserPersonal().getGender()));

		return model;
	}

	public ResponseModel deleteUserById(int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			return new ResponseModel(false, e.getLocalizedMessage());
		}

		return new ResponseModel(true, "User deleted successfully");
	}

	@Transactional
	public ResponseModel updateUserById(int id, RequestModel model) {

		try {
			repository.saveUser(id, model.getUserName(), model.getEmail(), model.getPhoneNumber());
			CustomUserPersonal personal = model.getUserPersonal();
			personal.setFullName(
					personal.getFirstName() + " " + personal.getMiddleName() + " " + personal.getLastName());
			System.out.println(personal.toString());
			repository.saveUserPersonal(id, personal.getFirstName(), personal.getMiddleName(), personal.getLastName(),
					personal.getGender(), personal.getFullName());
			return new ResponseModel(true, "User updated");
		} catch (Exception e) {
			return new ResponseModel(false, e.getLocalizedMessage());
		}

	}
}
