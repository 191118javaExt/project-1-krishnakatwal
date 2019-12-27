package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursementtype;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementtypeDAOImpl implements ReimbursementtypeDAO {
	private static Logger logger = Logger.getLogger(ReimbursementtypeDAOImpl.class);
	@Override
	public List<Reimbursementtype> getReimbursementtype() {
		
		List<Reimbursementtype> list = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.reimbursement_type;";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int type_id  =  rs.getInt("type_id");
				String type  = rs.getString("type");

				Reimbursementtype  rt = new Reimbursementtype (type_id,type );

				list.add(rt);
			}

			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve all users", e);
		}

	
		return list;
	}

	@Override
	public boolean add(Reimbursementtype rt) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO project1.reimbursement_type(type) "
					+ "VALUES (?);";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, rt.getType());

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
	public boolean update(Reimbursementtype rt) {
		int type_id = rt.getType_id();
		String type = rt.getType();
		
		
		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			
			String sql = "UPDATE project1.reimbursement_type SET type = ? WHERE type_id = ?;"; 
					
			
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, type);
			stm.setInt(2, type_id);
			
			if(!stm.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to update the type", ex);
			return false;
		}
	
		return true;
	}

	@Override
	public boolean delete(Reimbursementtype rt) {
		
		return false;
	}
	

}
