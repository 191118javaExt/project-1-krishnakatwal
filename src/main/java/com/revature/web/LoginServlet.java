package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.HtmlTemplate;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginServlet.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		logger.info("User attempted to login with username " + email);
		User e = UserService.EmailAndPassword(email, password);
		if(e != null) {
			HttpSession session = req.getSession();
			// Gets the current session, or creates one if it did not exist
			session.setAttribute("username", email);
			RequestDispatcher rd = req.getRequestDispatcher("user/home.HTML");
			rd.forward(req, res);
			logger.info(email + " has successfully logged in");
		} else {
			PrintWriter out = HtmlTemplate.getHtmlWriter(res);
			logger.info(email + " has failed to login.");
			out.println("<h3 style='color:red'>Denied.</h3>");
			out.println("<p>email or password is incorrect.</p>");
		}
	}
}
