package com.hit.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hit.model.User;
import com.hit.model.Item;
import com.hit.model.HibernateToDoListDAO;
import com.hit.model.ToDoListDAOException;

//import com.hit.hibernate.Hibernate;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ToDoList entity = new ToDoList();
		entity.setTask("test2");
		entity.setTitle("test title2");
		entity.setMemberId(1);
		try {
			HibernateToDoListDAO.getInstance().insertToDoList(entity);
		} catch (ToDoListDAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		
		/*try {
			System.out.println(HibernateToDoListDAO.getInstance().deleteToDoList(1));
		} catch (ToDoListDAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123");
		try {
			System.out.println(HibernateToDoListDAO.getInstance().authenticateUser(user));
		} catch (ToDoListDAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//System.out.println("yes- "+user.getId());
		
		/*Member m = new Member("admin12","123");
		try {
			System.out.println(HibernateToDoListDAO.getInstance().registerUser(m));
		} catch (ToDoListDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}