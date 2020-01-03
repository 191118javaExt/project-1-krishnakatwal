package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
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

	public boolean update(Reimbursement r) {
		return new ReimbursementDAOImpl().update(r);
	}

	public boolean getById(int id) {
		return new ReimbursementDAOImpl().getById(id);

	}

	public boolean updater(Reimbursement r) {
		return new ReimbursementDAOImpl().update(r);
	}
}
