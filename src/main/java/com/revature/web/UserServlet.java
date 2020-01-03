package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServlet extends HttpServlet{

	private static ObjectMapper om = new ObjectMapper();
	
	private static final long serialVersionUID = -4914841264666081261L;
	
	protected void  doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		res.setContentType("application/json");
		List<User> all = UserService.getAllUser();
		for(User u : all) {
			u.getUsername();
			u.getPassword();
			u.getFirstname();
			u.getLastname();
			u.getEmail();
			u.getRole_id();
		}
		
		String json = om.writeValueAsString(all);
		PrintWriter out = res.getWriter();
		out.println(json);
	}

}
