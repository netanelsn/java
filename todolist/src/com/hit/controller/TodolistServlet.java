package com.hit.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.model.Status;
import com.hit.model.Item;
import com.hit.model.HibernateToDoListDAO;
import com.hit.model.ToDoListDAOException;

/**
 * Servlet implementation class TodolistServlet
 */
@WebServlet(value="/TodolistServlet/*", name="TodolistServlet")
public class TodolistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public TodolistServlet() {
        super();       
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getPathInfo();
		RequestDispatcher view = null;
		
		HttpSession session = null;
		session = request.getSession(false); // don't create session if it doesn't exist
		long memberID = (long)session.getAttribute("member_id");
		
		List<Item> items = null;
		Item item = null;
		
		switch(path) {
		case "/create":
			view = request.getRequestDispatcher("/WEB-INF/create.jsp");
			break;
			
		case "/edit":
			view = request.getRequestDispatcher("/WEB-INF/edit.jsp");
			if(!request.getParameterMap().containsKey("id")) {
				//error case//
				response.sendRedirect("/todolist"+request.getServletPath()+"/");
				return;
			} else {
				long itemID = Long.parseLong(request.getParameter("id"));
				try {
					item = HibernateToDoListDAO.getInstance().getItemByID(memberID, itemID);
					
					if(item == null) {
						//error case//
						response.sendRedirect("/todolist"+request.getServletPath()+"/");
						return;
					}
					request.setAttribute("item", item);
				} catch (ToDoListDAOException exception) {
					exception.printStackTrace();
				}
			}
			break;
			
		case "/delete":	
			view = request.getRequestDispatcher("/WEB-INF/delete.jsp");
			if(!request.getParameterMap().containsKey("id")) {
				//error case//
				response.sendRedirect("/todolist"+request.getServletPath()+"/");
				return;
			} else {
				try {
					long itemID = Long.parseLong(request.getParameter("id"));
					item = HibernateToDoListDAO.getInstance().getItemByID(memberID, itemID);
					/* check if item exists in DB */
					if(item == null) {
						response.sendRedirect("/todolist"+request.getServletPath()+"/");
						return;
					} else {
						request.setAttribute("item", item);
					}
				} catch (ToDoListDAOException exception) {
					exception.printStackTrace();
				}
			}
			break;
			
		case "/completed":	
			view = request.getRequestDispatcher("/WEB-INF/home.jsp");
			try {
				items = HibernateToDoListDAO.getInstance().getCompletedItems(memberID);
				request.setAttribute("items", items);
				
			} catch (ToDoListDAOException exception) {
				exception.printStackTrace();
			}
			
			break;
			
		case "/pending":	
			view = request.getRequestDispatcher("/WEB-INF/home.jsp");
			
			try {
				items = HibernateToDoListDAO.getInstance().getPendingItems(memberID);
				request.setAttribute("items", items);
			} catch (ToDoListDAOException exception) {
				exception.printStackTrace();
			}
			
			break;
			
		case "/logout":
			/* remove session */
			session.invalidate();
			
			/* remove cookies */
			Cookie[] cookies = request.getCookies();
		    if(cookies != null) {
		        for(Cookie cookie : cookies) {
		            cookie.setValue("");
		            cookie.setMaxAge(0);
		            cookie.setPath("/todolist/");
		            response.addCookie(cookie);
		        }
		    }
		    
			response.sendRedirect("/todolist");
			return;

		case "/admin":
			view = request.getRequestDispatcher("/WEB-INF/admin.jsp");		
			break;
				
		case "/invalidate":
			view = request.getRequestDispatcher("/WEB-INF/admin.jsp");
			if(!request.getParameterMap().containsKey("id")) {
				//error case//
				response.sendRedirect("/todolist"+request.getServletPath()+"/");
				return;
			} else {
				//disconnect user from application by removing his session//
				Iterator<HttpSession> itr=((Set)request.getServletContext().getAttribute("sessions")).iterator();  
	    		while(itr.hasNext()){  
	    			HttpSession ses = itr.next();
	    			if(ses.getId().equals(request.getParameter("id"))) {
	    				ses.invalidate();
	    			}
	    		}  
			}
			break;
			
		default:
				try {
					items = HibernateToDoListDAO.getInstance().getItems(memberID);
					request.setAttribute("items", items);
					
					int completed = 0;
					int pending = 0;
					for(int i=0; i < items.size(); i++) {
						if(items.get(i).getStatus() == Status.Completed) {
							completed++;
						} else {
							pending++;
						}
					}
					/* set global data */
					request.getServletContext().setAttribute("num_of_items", items.size());
					request.getServletContext().setAttribute("num_of_completed", completed);
					request.getServletContext().setAttribute("num_of_pending", pending);
					
				} catch(ToDoListDAOException e) {
					
				}
				view = request.getRequestDispatcher("/WEB-INF/home.jsp");
			
			break;
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
		
		HttpSession session = null;
		session = request.getSession(false); // don't create session if it doesn't exist
		long memberID = (long)session.getAttribute("member_id");
		
		Item item = null;
		
		
		switch(path) {
		case "/create":
			
			if(request.getParameter("task").isEmpty()) {
				request.setAttribute("errorMsg", "Task field is require!");
				request.setAttribute("status", "error");
			} else if(request.getParameter("title").isEmpty()) {
				request.setAttribute("errorMsg", "Title field is require!");
				request.setAttribute("status", "error");
			} else {
				try {
					item = new Item();
					
					item.setUserId(memberID);
					item.setTitle(request.getParameter("title"));
					item.setContent(request.getParameter("task"));
					item.setStatus(Status.Pending);
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
					Date convertedDate = new Date();
					try {
				        convertedDate = dateFormat.parse(request.getParameter("dateTime"));
				    } catch (ParseException exception) {
				    	exception.printStackTrace();
				    }
					item.setDateTime(convertedDate);
					
					
					if(HibernateToDoListDAO.getInstance().addItem(item)) {	
						String msg = "New task has been inserted";
						response.sendRedirect("/todolist"+request.getServletPath()+"/?status=success&message="+msg);
						return;

					}
				} catch (ToDoListDAOException exception) {
					exception.printStackTrace();
				}
			}
			break;
			
		case "/edit":
			if(!request.getParameterMap().containsKey("id")) {
				request.setAttribute("errorMsg", "Task ID was not provided!");
				request.setAttribute("status", "error");
			} else if(request.getParameter("content").isEmpty()) {
				request.setAttribute("errorMsg", "Task field is require!");
				request.setAttribute("status", "error");
			} else if(request.getParameter("title").isEmpty()) {
				request.setAttribute("errorMsg", "Title field is require!");
				request.setAttribute("status", "error");
			} else {
				item = new Item();
				item.setId(Long.parseLong(request.getParameter("id")));
				item.setUserId(memberID);
				item.setTitle(request.getParameter("title"));
				item.setContent(request.getParameter("content"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
				Date convertedDate = new Date();
				try {
			        convertedDate = dateFormat.parse(request.getParameter("dateTime"));
			        item.setDateTime(convertedDate);
			    } catch (ParseException exception) {
			    	exception.printStackTrace();
			    }
				
				if("Completed".equals(request.getParameter("status"))) {
					item.setStatus(Status.Completed);
				} else {
					item.setStatus(Status.Pending);
				}
				try {
					if(HibernateToDoListDAO.getInstance().updateItem(item)) {
						String msg = "Task "+request.getParameter("id")+" has been updated";
						response.sendRedirect("/todolist"+request.getServletPath()+"/?status=success&message="+msg);
						return;
					}
				} catch (ToDoListDAOException exception) {
					exception.printStackTrace();
				}
			}
			break;
			
		case "/delete":
			if(request.getParameterMap().containsKey("id")) {

				try {
					if(!HibernateToDoListDAO.getInstance().removeItem(Long.parseLong(request.getParameter("id")))) {
						request.setAttribute("errorMsg", "Error - Task "+request.getParameter("id")+" could not delete from DB");
					} else {
						request.setAttribute("successMsg", "Success - Task "+request.getParameter("id")+" has been deleted");
					}
				} catch (ToDoListDAOException exception) {
					exception.printStackTrace(response.getWriter());
				}
			}
			break;
		
		}
		
		doGet(request, response);
	}
	
	
}