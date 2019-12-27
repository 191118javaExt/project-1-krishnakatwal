package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursementstatus;

public interface ReimbursementstatusDAO {
	
	List<Reimbursementstatus> getReimbursementstatus();

	boolean add(Reimbursementstatus rs);

	boolean update(Reimbursementstatus rs);

	boolean delete(Reimbursementstatus rs);
	
	boolean getById(Reimbursementstatus rs);
}
