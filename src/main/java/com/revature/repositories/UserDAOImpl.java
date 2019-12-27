package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public List<User> getUser() {
		List<User> list = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.user  WHERE id = ?;";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				int role_id = rs.getInt("role_id");

				User u = new User(id, username, password, firstname, lastname, email, role_id);

				list.add(u);
			}

			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve all users", e);

		}
		return list;
	}

	@Override
	public boolean add(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO  project1.user (username,password,firstname, lastname,email,role_id) "
					+ "VALUES (?, ?, ?, ?, ?,?);";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, u.getUsername());
			stm.setString(2, u.getPassword());
			stm.setString(3, u.getFirstname());
			stm.setString(4, u.getLastname());
			stm.setString(5, u.getEmail());
			stm.setInt(5, u.getRole_id());

			if (!stm.execute()) {
				return false;
			}
		} catch (SQLException e) {
			logger.warn("Unable to add user", e);
			return false;
		}

		return true;
	}

	@Override
	public boolean update(User u) {
		int id = u.getId();
		String username = u.getUsername();
		String password = u.getPassword();
		String firstname = u.getFirstname();
		String lastname = u.getEmail();
		String email = u.getEmail();
		int role_id = u.getRole_id();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE project1.user SET username = ?, password = ?,firstname = ?,lastname = ?,email = ?, role_id = ? WHERE id = ?;";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, firstname);
			stm.setString(2, lastname);
			stm.setString(3, username);
			stm.setString(4, email);
			stm.setString(5, password);
			stm.setInt(6, role_id);
			stm.setInt(7, id);

			if (!stm.execute()) {
				return false;
			}
		} catch (SQLException ex) {
			logger.warn("Unable to update the user", ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
