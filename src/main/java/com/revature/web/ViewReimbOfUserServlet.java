package com.revature.web;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.HelperTemplate;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
import com.revature.models.User;
import com.revature.services.ReimbursementService;

public class ViewReimbOfUserServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	 
	private static ObjectMapper om = new ObjectMapper();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String body = sb.toString();

		HelperTemplate model = om.readValue(body, HelperTemplate.class);
		int id = model.getId();
		
		List<Reimbursement> all = ReimbursementService.getAllReimByUserid(id);
		for( Reimbursement r: all) {
			System.out.println(r);
		}
		PrintWriter out =res.getWriter();
		List<ReimbursementDTO> allDTO = new ArrayList<>();
		res.setContentType("application/json");
		for( Reimbursement r: all) {
			allDTO.add(new ReimbursementDTO(r.getId(), 
					r.getAmount(),
					r.getAuthor(),
					r.getDescription(),
					r.getReceipt(),
					r.getResolver(),
					r.getResolved(),
					r.getStatus_id(),
					r.getType_id()));
					}
		out.println(om.writeValueAsString(allDTO));
		
	}

}
