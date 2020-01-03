package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;

public class UserService {
	static UserDAO repository = new UserDAOImpl();

	public static List<User> getAllUser() {
		return  new UserDAOImpl().getAllUser();

	}

	public boolean add(User u) {
		return new UserDAOImpl().add(u);
	}

	public boolean update(User u) {
		return new UserDAOImpl().update(u);
	}

	public static User EmailAndPassword(String email, String password) {

		return new  UserDAOImpl().getByemailAndPassword(email, password);
	}

	public User getById(int id) {

		return new UserDAOImpl().getById(id);
	}
}
