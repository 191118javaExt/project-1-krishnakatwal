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
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.services.UserService;
import com.revature.util.HtmlTemplate;

public class FmLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(FmLoginServlet.class);


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
System.out.println("Inside log in servlet");
		
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		String body = sb.toString();
		ObjectMapper om = new ObjectMapper();
		User model = om.readValue(body, User.class);
		
		System.out.println("password = " + model.getPassword());
		logger.info("User attempted to login with email," + model.getEmail());
		User u = UserService.EmailAndPassword(model.getEmail(), model.getPassword());
		System.out.println(u);
		if(u != null) {
			HttpSession session = req.getSession();
			// Gets the current session, or creates one if it did not exist
		
			//RequestDispatcher rd = req.getRequestDispatcher("user/home.HTML");
			UserDTO udto = UserService.convertToDto(u);
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			
			out.println(om.writeValueAsString(udto));
			System.out.println("response of login attempt is user with = " + udto);
			session.setAttribute("userName", udto);
			logger.info(udto.getFirstname() + " has successfully logged in");
		} else {
			PrintWriter out = HtmlTemplate.getHtmlWriter(res);
			logger.info(model.getEmail() + " has failed to login.");
			res.setStatus(204);
		}
	}
}
