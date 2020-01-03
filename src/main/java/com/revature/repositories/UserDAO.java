package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {
	List<User> getAllUser();

	boolean add(User u);

	boolean update(User u);

	boolean delete(User u);

	public User getByemailAndPassword(String email, String password);

	public User getById(int id);



}
