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
	public List<User> getAllUser() {
		List<User> list = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.users  WHERE id = ?;";

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

			String sql = "INSERT INTO  project1.users (username,password,firstname, lastname,email,role_id) "
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

			String sql = "UPDATE project1.users SET username = ?, password = ?,firstname = ?,lastname = ?,email = ?, role_id = ? WHERE id = ?;";

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
	public User getByemailAndPassword(String email, String password) {
		User user = null;

		try (Connection con = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.users WHERE email = ? AND password = ?;";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, email);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String Password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String Email = rs.getString("Email");
				int role_id = rs.getInt("role_id");
				user = new User(id, username, Password, firstname, lastname, Email, role_id);

			}

			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve the user by using first name and password", e);
		}
		return user;
	}

	@Override
	public User getById(int id) {
		User user = null;

		try (Connection con = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.users WHERE id = ? ;";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int user_id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String email = rs.getString("email");
				int role_id = rs.getInt("role_id");

				user = new User(user_id, username, password, fname, lname, email, role_id);

			}

			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve the user", e);
		}

		return user;
	}

	@Override
	public boolean delete(User u) {

		return false;
	}


}
