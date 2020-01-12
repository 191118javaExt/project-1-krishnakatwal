package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.UpdateTemplate;

public class UpdateServlet extends HttpServlet {


private static final long serialVersionUID = 1L;
private static ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line = reader.readLine();
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String body = sb.toString();
		UpdateTemplate model = om.readValue(body, UpdateTemplate.class);
		int id = model.getId();
		int status_id = model.getStatus_id();
		}
}
