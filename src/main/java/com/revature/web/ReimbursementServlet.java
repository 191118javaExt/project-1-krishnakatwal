package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementServlet extends HttpServlet{ 
	
	private static final long serialVersionUID = 1L;
	 private static ObjectMapper om = new ObjectMapper();
	 
	 protected void doGet(HttpServletRequest req, HttpServletResponse res)
		 throws ServletException, IOException {
		 res.setContentType("application/json");
		 List<Reimbursement> all = ReimbursementService.getAllReimbursement();
		 
		 for(Reimbursement r : all) {
			 r.getId();
			 r.getAmount();
			 r.getResolved();	
			 r.getDescription();	
			 r.getReceipt(); 
			 r.getAuthor();	
			 r.getResolved();	
			 r.getStatus_id();
			 r.getType_id();
		 }
		 String json = om.writeValueAsString(all);
			 
		 PrintWriter out = res.getWriter();
		 out.print(json);
		 }
}
	 
