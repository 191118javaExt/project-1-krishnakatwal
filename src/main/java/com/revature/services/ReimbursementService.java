package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.ReimbursementDAOImpl;

public class ReimbursementService {
	ReimbursementDAO repository = new ReimbursementDAOImpl();

	public static List<Reimbursement> getAllReimbursement() {
		return new ReimbursementDAOImpl().getAllReimbursement();

	}

	public boolean add(Reimbursement r) {
		return new ReimbursementDAOImpl().add(r);

	}

	public static boolean update(Reimbursement r) {
		return new ReimbursementDAOImpl().update(r);
	}

	public boolean getById(int id) {
		return new ReimbursementDAOImpl().getById(id);

	}

	

	public static ReimbursementDTO convertToDTO(Reimbursement r) {
		
		return new ReimbursementDTO(r.getAuthor(),
				r.getAmount(),
				r.getId(),
				r.getDescription(),
				r.getReceipt(),
				r.getAuthor(),
				r.getResolved(),
				r.getStatus_id(),
				r.getType_id()
			
				);
	}
       public static List<Reimbursement> getAllReimByUserid(int id) {
		return new ReimbursementDAOImpl().getAllReimByUserid(id);
	}

	
}
