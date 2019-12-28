package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> getAllReimbursement();

	boolean add(Reimbursement r);

	boolean update(Reimbursement r);

	boolean delete(Reimbursement r);
	
	boolean getById(int  id);
}
