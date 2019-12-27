package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursementtype;

public interface ReimbursementtypeDAO {
	List<Reimbursementtype> getReimbursementtype();

	boolean add(Reimbursementtype rt);

	boolean update(Reimbursementtype rt);

	boolean delete(Reimbursementtype rt);
}
