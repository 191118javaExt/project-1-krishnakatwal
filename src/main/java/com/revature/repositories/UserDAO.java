package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {
	List<User> getUser();

	boolean add(User u);

	boolean update(User u);

	boolean delete(User u);

}
