package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.UpdateTemplate;
import com.revature.services.ReimbursementService;

public class UpdateServlet extends HttpServlet {


private static final long serialVersionUID = 1L;
private static ObjectMapper om = new ObjectMapper();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
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
		UpdateTemplate model = om.readValue(body, UpdateTemplate.class);
		int id = model.getId();
		int status_id = model.getStatus_id();
		
		Reimbursement r = new Reimbursement(id, status_id);
		boolean check = ReimbursementService.update(r);
		res.setStatus(200);
		
		}
}
