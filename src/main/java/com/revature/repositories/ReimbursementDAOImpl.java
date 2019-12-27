package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private static Logger logger = Logger.getLogger(ReimbursementDAOImpl.class);

	@Override
	public List<Reimbursement> getReimbursement() {
		List<Reimbursement> list = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM project1.reimburesement;";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				double amount = rs.getDouble("amount");
				int resolver = rs.getInt("resolver");
				String description = rs.getString("description");
				byte[] receipt = rs.getBytes("receipt");
				int author = rs.getInt("author");
				Timestamp resolved = rs.getTimestamp("resolved");
				int status_id = rs.getInt("status_id");
				int type_id = rs.getInt("type_id");

				Reimbursement reimb = new Reimbursement(id, amount, resolver, description, receipt, author, resolved,
						status_id, type_id);
				list.add(reimb);
			}

			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve all reimbursments", e);
		}

		return list;
	}

	@Override
	public boolean add(Reimbursement r) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO project1.reimburesement(amount, resolved, description, receipt, author, resolver, status_id, type_id) "
					+ "VALUES (?, ?, ?, ?, ?,?,?,?);";
			
			PreparedStatement stm = conn.prepareStatement(sql);
					
			stm.setDouble(1, r.getAmount());
			stm.setTimestamp(2, r.getResolved());
			stm.setString(3, r.getDescription());
			stm.setBytes(4, r.getReceipt());
			stm.setInt(5,r.getAuthor());
			stm.setInt(6, r.getResolver());
			stm.setInt(7, r.getStatus_id());
			stm.setInt(8, r.getType_id());

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
	public boolean update(Reimbursement r) {
		int id = r.getId();
		double amount = r.getAmount();
		Timestamp resolved = r.getResolved();
		String description = r.getDescription();
		byte[] receipt = r.getReceipt();
		int author = r.getAuthor();
		int resolverId = r.getResolver();
		int statusId = r.getStatus_id();
		int typeId = r.getType_id();
		
try (Connection conn = ConnectionUtil.getConnection()) {
			
			
			String sql = "UPDATE project1.reimbursements SET amount = ?,resolved = ?, description = ?, receipt = ?, author = ?, resolver = ?, status_id = ?, type_id = ? WHERE id = ?;"; 
					
			
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setDouble(1, amount);
			stm.setTimestamp(2, resolved);
			stm.setString(3, description);
			stm.setBytes(4, receipt);
			stm.setInt(5, author);
			stm.setInt(6, resolverId);
			stm.setInt(7, statusId);
			stm.setInt(8, typeId);
			stm.setInt(9, id);
			
			if(!stm.execute()) {
				return false;
			}
		} catch(SQLException ex) {
			logger.warn("Unable to update the reimbursment", ex);
			return false;
		}
		

		return true;
	}

	@Override
	public boolean delete(Reimbursement r) {
		
		return false;
	}

	@Override
	public boolean getById(Reimbursement r) {
		
		return false;
	}
}
