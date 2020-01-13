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
	public List<Reimbursement> getAllReimbursement() {
		List<Reimbursement> list = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM project1.reimbursement;";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				double amount = rs.getDouble("amount");
				int resolver = rs.getInt("resolver");
				String description = rs.getString("description");
				byte[] receipt = rs.getBytes("receipt");
				int author= rs.getInt("author");
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
		System.out.println(r.getAmount()+ "amount");
		System.out.println(r.getAuthor()+ "author");
		System.out.println(r.getDescription()+ "des");
		System.out.println(r.getType_id()+ "type");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO project1.reimbursement(amount, description, author,resolver,status_id, type_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?);";
			
			PreparedStatement stm = conn.prepareStatement(sql);
					
			stm.setDouble(1, r.getAmount());
			stm.setString(2, r.getDescription());
			stm.setInt(3,r.getAuthor());
			stm.setInt(4, 9);
			stm.setInt(5, 3);
			stm.setInt(6, r.getType_id());

			if (!stm.execute()) {
				return false;
			}
		} catch (SQLException e) {
			logger.warn("Unable to add reimbursement", e);
			return false;
		}

		return true;
		
	}

	@Override
	public boolean update(Reimbursement r) {
		int id = r.getId();
		//double amount = r.getAmount();
		//Timestamp resolved = r.getResolved();
		//String description = r.getDescription();
		//byte[] receipt = r.getReceipt();
		//int author = r.getAuthor();
		//int resolverId = r.getResolver();
		int statusId = r.getStatus_id();
		//int typeId = r.getType_id();
		
try (Connection conn = ConnectionUtil.getConnection()) {
			
			
			String sql = "UPDATE project1.reimbursement SET status_id = ? WHERE id = ?;"; 
					
			
			PreparedStatement stm = conn.prepareStatement(sql);
			//stm.setDouble(1, amount);
			//stm.setTimestamp(2, resolved);
			//stm.setString(3, description);
			//stm.setBytes(4, receipt);
			//stm.setInt(5, author);
			//stm.setInt(6, resolverId);
			stm.setInt(1, statusId);
			//stm.setInt(8, typeId);
			stm.setInt(2, id);
			
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
	public boolean getById(int id) {
		
		return false;
	}
	
	@Override
	public List<Reimbursement> getAllReimByUserid(int id) {
		List<Reimbursement> list = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM project1.reimbursement WHERE author = "+ id+";";

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id1 = rs.getInt("id");
				double amount = rs.getDouble("amount");
				int resolver = rs.getInt("resolver");
				String description = rs.getString("description");
				byte[] receipt = rs.getBytes("receipt");
				int author= rs.getInt("author");
				Timestamp resolved = rs.getTimestamp("resolved");
				int status_id = rs.getInt("status_id");
				int type_id = rs.getInt("type_id");

				Reimbursement reimb = new Reimbursement(amount, description, author, type_id);
				list.add(reimb);
			}

			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve reimbursments", e);
		}

		return list;
	}
	
}
