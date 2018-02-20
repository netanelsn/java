package com.hit.model;

public class ToDoListDAOException extends Exception{

	private static final long serialVersionUID = 1L;

	public ToDoListDAOException() {
	}
	
	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message
	 */
	public ToDoListDAOException(String message) {
		super("ToDoList Exception: " + message);
	}
	
	
	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * @param message
	 * @param cause
	 */
	public ToDoListDAOException(String message, Throwable cause) {
		super("ToDoList Exception: " + message, cause);
	}
	
}
