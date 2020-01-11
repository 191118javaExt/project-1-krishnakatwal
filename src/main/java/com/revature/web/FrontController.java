//package com.revature.web;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class FrontController extends HttpServlet{
//
//	private static final long serialVersionUID = 8339100247721381693L;
//	
//	protected void dopost(HttpServletRequest req, HttpServletResponse res)
//	throws ServletException, IOException{
//		final String URI = req.getRequestURI().replace("/project-1/", "");
//		
//		switch(URI) {
//		case "Login":
//			RequestHelper.processLogin(req, res);
//			break;
//		case "logout":
//			RequestHelper.processLogout(req, res);
//			break;
//		case "users":
//			RequestHelper.ProcessUsers(req, res);
//		}
//	}
//	
//	protected void doGet(HttpServletRequest req, HttpServletResponse res)
//			throws ServletException, IOException {
//		doPost(req, res);
//	}
//}
