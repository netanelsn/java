package com.hit.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.model.User;
import com.hit.model.HibernateToDoListDAO;
import com.hit.model.ToDoListDAOException;

/**
 * Servlet implementation class authenticationServlet
 */
@WebServlet(value="/authenticationServlet/*", name="authenticationServlet")
public class authenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authenticationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		String path = request.getPathInfo();
		
		switch(path) {
		case "/login":
			view = request.getRequestDispatcher("/login.jsp");
			break;
			
		case "/register":
			view = request.getRequestDispatcher("/register.jsp");
			break;
			
		case "/cookies":
			Cookie[] cookies = request.getCookies();
			
			String username = null;
			String password = null;
			
			/* Check if cookies exists */
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().compareTo("username") == 0) {
						username = cookie.getValue();
					} else if(cookie.getName().compareTo("password") == 0) {
					    password = cookie.getValue();
					}
				}
								
			}
			
			/* If cookies contains username and password try to login */
			if(username !=null && password != null) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				
				try {
					/* try to authenticate */
					if(HibernateToDoListDAO.getInstance().authenticateUser(user)) {
						/* Valid Member */
						/* Create session */
						createSession(request, user);
						response.sendRedirect("/todolist/TodolistServlet/");
						return;
					} else {
						/* Invalid Member*/
						/* Remove cookies */
					    for(Cookie cookie : cookies) {
					        cookie.setValue("");
					        cookie.setMaxAge(0);
					        cookie.setPath("/todolist/");
					        response.addCookie(cookie);
					    }
					    response.sendRedirect("/todolist/");
					    return;
					}
				} catch (ToDoListDAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			break;
			
		default:
			response.sendRedirect("/todolist/");
			return;
		}
		
		if(view != null){
			view.forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getPathInfo();
		
		switch(path) {
		case "/login":
			if(request.getParameter("username").isEmpty() || request.getParameter("password").isEmpty()) {
				request.setAttribute("errorMsg", "Invalid Credential");
			} else {
				User user = new User();
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				try {
					if(!HibernateToDoListDAO.getInstance().authenticateUser(user)) {
						request.setAttribute("errorMsg", "Invalid username or password.");
					} else {
						/* Create session */
						createSession(request, user);
						
						/* create cookies if checkbox is checked */
						if(request.getParameterMap().containsKey("remember") && request.getParameter("remember").equals("true")) {
							createCookies(response, user);
						}
						
						response.sendRedirect("/todolist/TodolistServlet/");
						return;
					}
				} catch (ToDoListDAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		case "/register":
			/* check if username and password has been set */
			if(request.getParameter("username").isEmpty() || request.getParameter("password").isEmpty()) {
				request.setAttribute("errorMsg", "Invalid Credential");
			} else {
				
				User user = new User();
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setFirstname(request.getParameter("firstname"));
				user.setLastname(request.getParameter("lastname"));
				user.setDateTime(new Date());
				
				try {
					/* create member */
					if(HibernateToDoListDAO.getInstance().registerUser(user)) {
						/* Create session */
						createSession(request, user);
						
						/* Create cookies if checkbox is checked */
						if(request.getParameterMap().containsKey("remember") && request.getParameter("remember").equals("true")) {
							createCookies(response, user);
						}
						
						response.sendRedirect("/todolist/TodolistServlet/");
						return;
						
					} else {
						/* username is already exists - set an error */
						request.setAttribute("errorMsg", "Username already exists");
					}
					
				} catch (ToDoListDAOException e) {
					e.printStackTrace();
				}
			}
			break;
			
		default:
			break;
		}
		
		
		doGet(request, response);
	}
	
	
	/**
	 * Create Session and set attributes
	 */
	protected void createSession(HttpServletRequest request, User user) {
		HttpSession session = request.getSession(true);
		session.setAttribute("member_id", user.getId());
		session.setAttribute("password", user.getPassword());
		session.setAttribute("username", user.getUsername());
		session.setAttribute("firstname", user.getFirstname());
		session.setAttribute("lastname", user.getLastname());
		session.setAttribute("lastlogin", user.getDateTime());
		
		session.setMaxInactiveInterval(60*60*2); // valid for 2 hours
	}
	
	/**
	 * Create Cookies
	 */
	protected void createCookies(HttpServletResponse response, User user) {
		Cookie userId = new Cookie("member_id", String.valueOf(user.getId())); 
		Cookie password = new Cookie("password", String.valueOf(user.getPassword())); 
		Cookie username = new Cookie("username", user.getUsername());
		Cookie firstname = new Cookie("firstname", user.getFirstname()); 
		Cookie lastname = new Cookie("lastname", user.getLastname());
		
		// valid for 1 week 
		userId.setMaxAge(60*60*24*7);
		password.setMaxAge(60*60*24*7);
		username.setMaxAge(60*60*24*7);
		firstname.setMaxAge(60*60*24*7);
		lastname.setMaxAge(60*60*24*7);

		userId.setPath("/todolist/");
		password.setPath("/todolist/");
		username.setPath("/todolist/");
		firstname.setPath("/todolist/");
		lastname.setPath("/todolist/");

		response.addCookie(userId);
		response.addCookie(password);
		response.addCookie(username);
		response.addCookie(firstname);
		response.addCookie(lastname);
	}

}
