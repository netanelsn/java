package com.hit.model;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hit.hibernate.HibernateUtil;

/**
 * IToDoListDAO implementation class HibernateToDoListDAO
 *
 */
public class HibernateToDoListDAO implements IToDoListDAO {
	
	private final static Logger logger = Logger.getLogger(HibernateToDoListDAO.class);
	private static HibernateToDoListDAO instance;
	
	private HibernateToDoListDAO() {
		
	}
	
	/**
	 * singleton HibernateToDoListDAO object
	 * 
	 * */
	public static synchronized HibernateToDoListDAO getInstance() {
		if(instance == null) {
			instance = new HibernateToDoListDAO();
		}
		return instance;
	}
	
	
	
	@Override
	public boolean addItem(Item entity) throws ToDoListDAOException {
		
		Session session = null;
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			
			logger.info("Item " + entity.getId() +" was successfully inserted");
		}
		catch (HibernateException exception)
		{
			logger.error("Failed to insert an item " + entity.getId());
			
			Transaction tx = session.getTransaction();
			if(tx.isActive()) { 
				tx.rollback(); 
			}
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
		
		return true;
	}

	@Override
	public boolean removeItem(long itemID) throws ToDoListDAOException {

		Session session = null;
		Item remove = null;

		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			remove = (Item)session.get(Item.class, itemID);
			session.delete(remove);
			session.getTransaction().commit();
			
			logger.info("Item " + itemID +" was successfully removed");
		}
		catch (HibernateException exception)
		{
			logger.error("Failed to remove an item " + itemID);
			
			Transaction tx = session.getTransaction();
			if(tx.isActive()) { 
				tx.rollback(); 
			}
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
		
		return true;
	}

	@Override
	public boolean updateItem(Item entity) throws ToDoListDAOException {
		Session session = null;
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
			
			logger.info("Item " + entity.getId() +" was successfully updated");
		}
		catch (HibernateException exception)
		{
			logger.error("Failed to update an item " + entity.getId());
			
			Transaction tx = session.getTransaction();
			if(tx.isActive()) { 
				tx.rollback(); 
				return false;
			}
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
		
		return true;
	}

	@Override
	public List<Item> getItems(long userID) throws ToDoListDAOException {
		Session session = null;
		Query query = null;
		List<Item> list = new ArrayList<Item>();
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			query = session.createQuery("from Item where USER_ID=?");
			query.setParameter(0, userID);
			
			list = query.list();
			
			session.getTransaction().commit();
			logger.info("User " + userID +" got his items");

		}
		catch (HibernateException exception)
		{
			logger.error("User " + userID +" could not get his items");
			
			Transaction tx = session.getTransaction();
			if(tx.isActive()) { 
				tx.rollback(); 
			}
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
		
		return list;
	}

	@Override
	public Item getItemByID(long userID, long itemID) throws ToDoListDAOException {
		Session session = null;
		Item list = null;
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Item where ID=? AND USER_ID=?");
			query.setParameter(0, itemID);
			query.setParameter(1, userID);
			list = (Item)query.uniqueResult();
			
			session.getTransaction().commit();
			logger.info("User " + userID +" got Item "+ itemID);

		}
		catch (HibernateException exception)
		{
			logger.error("User " + userID +" could not get Item "+ itemID);
			
			Transaction tx = session.getTransaction();
			if(tx.isActive()) { 
				tx.rollback(); 
			}
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
		
		return list;
	}
	
	@Override
	public List<Item> getCompletedItems(long userID) throws ToDoListDAOException {
		Session session = null;
		Query query = null;
		List<Item> list = new ArrayList<Item>();
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			query = session.createQuery("from Item where USER_ID=? AND STATUS LIKE 'Completed'");
			query.setParameter(0, userID);
			
			list = query.list();
			
			session.getTransaction().commit();			

		}
		catch (HibernateException exception)
		{
			System.out.println("HibernateException - getAllToDoList()");
			Transaction tx = session.getTransaction();
			if(tx.isActive()) { 
				tx.rollback(); 
			}
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
		
		return list;
	}

	@Override
	public List<Item> getPendingItems(long userID) throws ToDoListDAOException {
		Session session = null;
		Query query = null;
		List<Item> list = new ArrayList<Item>();
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			query = session.createQuery("from Item where USER_ID=? AND STATUS LIKE 'Pending'");
			query.setParameter(0, userID);
			
			list = query.list();
			
			session.getTransaction().commit();
			

		}
		catch (HibernateException exception)
		{
			System.out.println("HibernateException - getAllToDoList()");
			Transaction tx = session.getTransaction();
			if(tx.isActive()) { 
				tx.rollback(); 
			}
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
		
		return list;
	}
	
	@Override
	public boolean authenticateUser(User user) throws ToDoListDAOException {
		Session session = null;
		Query query = null;
		User result = null;
		boolean authenticate = false;
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			query = session.createQuery("from User where USERNAME=? and PASSWORD=?");
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			result = (User)query.uniqueResult();
			
			session.getTransaction().commit();
			logger.info("Authentication for Username: " + user.getUsername());

		}
		catch (HibernateException exception)
		{
			logger.error("Username: " + user.getUsername() + "could not authanticate");
			
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
		
		if(result != null) {
			user.setId(result.getId());
			user.setFirstname(result.getFirstname());
			user.setLastname(result.getLastname());
			authenticate = true;
		}
		return authenticate;
	}
	
	@Override
	public boolean registerUser(User user) throws ToDoListDAOException {
		Session session = null;
		boolean userFound = true;
		/* Check if user exists */
		try
		{			
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("from User where USERNAME=:username");
			query.setParameter("username", user.getUsername());
			session.getTransaction().commit();
			
			User valid = (User)query.uniqueResult();
			
			if(valid == null) {
				userFound= false;
			}
		}
		catch (HibernateException exception)
		{
			logger.error("Username: " + user.getUsername() + "could not register");
			
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
		
		/* if user was found return false*/
		if(userFound) {
			return false;
		}
		
		/* create new member */
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			session.save(user);

			session.getTransaction().commit();
			logger.info("New member has been created");
		}
		catch (HibernateException exception)
		{
			logger.error("Could not create a member");
			
			throw new ToDoListDAOException(exception.getMessage(), exception);
		}
		finally
		{
			if(session!=null) { 
				try
				{
					session.close(); 
				} catch (HibernateException exception) {
					throw new ToDoListDAOException(exception.getMessage(), exception);
				}
			}
		}
			
		return true;
	}
	

}
