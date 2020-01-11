package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FReviewReimbServlet extends HttpServlet{
	
	private static Logger logger = Logger.getLogger(FReviewReimbServlet.class);
	private static ObjectMapper om = new ObjectMapper();
	private static final long serialVersionUID = 4783902843062592174L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		
	}

}
