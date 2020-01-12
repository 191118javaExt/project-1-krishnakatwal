package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
import com.revature.models.SubmitTemp;
import com.revature.repositories.ReimbursementDAOImpl;
import com.revature.services.ReimbursementService;

public class SubmitReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static ObjectMapper om = new ObjectMapper();
	private static Logger logger = Logger.getLogger(SubmitReimbursementServlet.class);
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		
//		printwriter here
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while(line != null) {
			s.append(line);
			line = reader.readLine();	
		}
		
		String body = s.toString();
		System.out.println(body);
		
		SubmitTemp submitreimb = om.readValue(body, SubmitTemp.class);
		int author_id= submitreimb.getAuthor_id();
//		System.out.println("in servlet");
//		System.out.println(author_id + "author");
		double amount = submitreimb.getAmount();
		String description = submitreimb.getDescription();
		String type = submitreimb.getType_id();
	
	// you have to change the the type to the number according to your database for now I just used 3 IMPORTANT
		
	
		int type_id = 0;
	    switch(type){
	    case "Lodging": 
	    type_id = 1;
	    break;
	    case "Travel":
	      type_id = 2;
	      break;
	    case "Food":
	      type_id = 3;
	      break;
	    case "Other":
	      type_id = 4;
	      break;
	     default: 
	    break;
	    }
	    
	   // Reimbursement(double amount, int resolver, String description, int author, int status_id, int type_id)
		Reimbursement reim = new Reimbursement(amount,9,description,author_id,3,type_id);
		logger.info("user attement to with author_id" + author_id);
		ReimbursementDAOImpl rd = new ReimbursementDAOImpl();
		boolean check = rd.add(reim);
		
		if(reim != null) {
			HttpSession session = req.getSession();
			session.setAttribute("author_id", author_id);
			
			PrintWriter out = resp.getWriter();
			logger.info("Reimbursement created");
			
			resp.setContentType("application/json");
			ReimbursementDTO  rdto = ReimbursementService.convertToDTO(reim);
			out.println(om.writeValueAsString(rdto));
			resp.setStatus(200);
			
		} else {
			resp.setContentType("application/json");
			resp.setStatus(400);
			
		}
		
		
    }
}

