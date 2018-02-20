package com.hit.model;

import java.util.List;


/**
 * Simple API documentation.
 * interface that lists the methods through which we access the database
 */
public interface IToDoListDAO {
	/**
     * This method allows us to add new item to database.
     * @param entity
     * @return true if the item added to database
     * @throws ToDoListDAOException
     */
	public boolean addItem(Item entity) throws ToDoListDAOException;
	
	/**
     * This method allows us to remove an item from database.
     * @param itemID
     * @return true if the item removed from database
     * @throws ToDoListDAOException
     */
	public boolean removeItem(long itemID) throws ToDoListDAOException;
	
	/**
     * This method allows us to update an existent item in database.
     * @param entity
     * @return true if the item has been updated in database
     * @throws ToDoListDAOException
     */
	public boolean updateItem(Item entity) throws ToDoListDAOException;
	
	/**
     * This method allows us to get ALL items from database.
     * @param userID
     * @return list of items
     * @throws ToDoListDAOException
     */
	public List<Item> getItems(long userID) throws ToDoListDAOException;
	
	/**
     * This method allows us to get specific item by ID from database.
     * @param userID
     * @param itemID
     * @return single item
     * @throws ToDoListDAOException
     */
	public Item getItemByID(long userID, long itemID) throws ToDoListDAOException;
	
	/**
	 * This method allows us to get all pending items from database.
	 * @param userID
	 * @return list of items
	 * @throws ToDoListDAOException
	 */
	public List<Item> getPendingItems(long userID) throws ToDoListDAOException;
	
	/**
	 * This method allows us to get all completed items from database.
	 * @param userID
	 * @return list of items
	 * @throws ToDoListDAOException
	 */
	public List<Item> getCompletedItems(long userID) throws ToDoListDAOException;
	
	/**
     * This method allows us to authenticate user in database.
     * @param user
     * @return true if user is registered
     * @throws ToDoListDAOException
     */
	public boolean authenticateUser(User user) throws ToDoListDAOException;
	
	/**
     * This method allows us to register a user to the database.
     * @param user
     * @return true if user was able to register to database
     * @throws ToDoListDAOException
     */
	public boolean registerUser(User user) throws ToDoListDAOException;
}
