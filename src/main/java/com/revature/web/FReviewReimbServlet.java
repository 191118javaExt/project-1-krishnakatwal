//package com.revature.web;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.TreeMap;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.log4j.Logger;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.models.Reimbursement;
//
//public class FReviewReimbServlet extends HttpServlet{
//	
//	private static Logger logger = Logger.getLogger(FReviewReimbServlet.class);
//	private static ObjectMapper om = new ObjectMapper();
//	private static final long serialVersionUID = 4783902843062592174L;
//	Reimbursement reimb = new Reimbursement();
//	
//	
//	@Override
//	
//	protected void doGet(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//			
//			res.setContentType("application/json");
//			PrintWriter outputStream = res.getWriter();
//			res.setStatus(200);
//			
//			outputStream.println(om.writeValueAsString(allReimb));
//			
//		}
//}

	
	
	
	
