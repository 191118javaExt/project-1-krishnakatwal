package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.ReimbursementDAOImpl;

public class ReimbursementService {
	ReimbursementDAO repository = new ReimbursementDAOImpl();

	public List<Reimbursement> getAllReimbursement() {
		return repository.getAllReimbursement();

	}

	public boolean add(Reimbursement r) {
		return repository.add(r);

	}

	public boolean update(Reimbursement r) {
		return repository.update(r);
	}

	public boolean getById(int id) {
		return repository.getById(id);

	}

	public boolean updater(Reimbursement r) {
		return repository.update(r);
	}
}
