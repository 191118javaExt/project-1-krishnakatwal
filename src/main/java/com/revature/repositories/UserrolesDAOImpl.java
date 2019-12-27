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
import com.revature.models.Userroles;
import com.revature.util.ConnectionUtil;

public class UserrolesDAOImpl implements  UserrolesDAO {
	private static Logger logger = Logger.getLogger(UserrolesDAOImpl.class);
	@Override
	public List<Userroles> getUserroles() {
		List<Userroles> list = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.user_roles;";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int role_id = rs.getInt("role_id");
				String role = rs.getString("role");

				Userroles ur = new Userroles(role_id,role);

				list.add(ur);
			}

			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve all users", e);
		}
		
		return list;
	}

	@Override
	public boolean add(Userroles ur) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO project1.user_roles(role) "
					+ "VALUES (?);";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, ur.getRole());

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
	public boolean update(Userroles ur) {
		int role_id = ur.getRole_id();
		String role = ur.getRole();
		

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE project1.user_roles SET role  WHERE role_id = ?;";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, ur.getRole());
			stm.setInt(2, ur.getRole_id());

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
	public boolean delete(Userroles ur) {
		// TODO Auto-generated method stub
		return false;
	}

}
