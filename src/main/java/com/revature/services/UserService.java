package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;

public class UserService {
	UserDAO repository = new UserDAOImpl();

	public List<User> getAllUser() {
		return repository.getUser();

	}

	public boolean add(User u) {
		return repository.add(u);
	}

	public boolean update(User u) {
		return repository.update(u);
	}

	public User getByFnameAndPassword(String email, String password) {

		return repository.getByemailAndPassword(email, password);
	}

	public User getById(int id) {

		return repository.getById(id);
	}
}
