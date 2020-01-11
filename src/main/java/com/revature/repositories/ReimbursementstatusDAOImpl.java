//package com.revature.repositories;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.revature.models.Reimbursementstatus;
//import com.revature.util.ConnectionUtil;
//
//public class ReimbursementstatusDAOImpl implements ReimbursementstatusDAO{
//	
//	private static Logger logger = Logger.getLogger(ReimbursementDAOImpl.class);
//
//		@Override
//		public List<Reimbursementstatus> getReimbursementstatus() {
//			List<Reimbursementstatus> list = new ArrayList<>();
//
//			try (Connection conn = ConnectionUtil.getConnection()) {
//				String sql = "SELECT * FROM project1.reimbursement_status;";
//
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(sql);
//
//				while (rs.next()) {
//					int status_id = rs.getInt("status_id");
//					 String status  = rs.getString("status");
//
//					Reimbursementstatus reimb= new Reimbursementstatus(status_id,status);
//					list.add(reimb);
//				}
//
//				rs.close();
//			} catch (SQLException e) {
//				logger.warn("Unable to retrieve all reimbursments", e);
//			}
//		return list;
//	}
//
//	@Override
//	public boolean add(Reimbursementstatus rs) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//
//			String sql = "INSERT INTO project1.reimbursement_status (status)"
//					+ "VALUES (?);";
//
//			PreparedStatement stm = conn.prepareStatement(sql);
//			stm.setString(1, rs.getStatus());
//			if (!stm.execute()) {
//				return false;
//			}
//		} catch (SQLException e) {
//			logger.warn("Unable to add user", e);
//			return false;
//		}
//
//		return true;
//	}
//
//	@Override
//	public boolean update(Reimbursementstatus rs) {
//		
//		int status_id = rs.getStatus_id();
//		String status = rs.getStatus();
//
//		try (Connection conn = ConnectionUtil.getConnection()) {
//
//			String sql = "UPDATE project1.Reimbursementstatus SET status = ? WHERE status_id = ?;";
//
//			PreparedStatement stm = conn.prepareStatement(sql);
//			stm.setInt(1, status_id );
//			stm.setString(2, status);
//		
//
//			if (!stm.execute()) {
//				return false;
//			}
//		} catch (SQLException ex) {
//			logger.warn("Unable to update the user", ex);
//			return false;
//		}
//
//		return true;
//	}
//
//	@Override
//	public boolean delete(Reimbursementstatus rs) {
//	
//		return false;
//	}
//
//	@Override
//	public boolean getById(Reimbursementstatus rs) {
//
//		return false;
//	}
//	
//
//}
