package com.marco.utils;

/**
 * This class has the structure of the 
 * PNotify notification. I use this
 * in order to return in a easy way to the Front
 * end any kind of notifications
 * 
 * @author Marco
 *
 */
public class MarcoException extends Exception {

	public enum ExceptionType {
		warning, info, success, error
	}

	private static final long serialVersionUID = 2793229948179272615L;
	private String title;
	private String message;
	private ExceptionType type;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public MarcoException(String message){
		this("Error", message);
	}
	
	public MarcoException(String title, String message){
		this(title, message, ExceptionType.error);
	}
	
	public MarcoException(String title, String message, ExceptionType type) {
		super(message);
		this.message = message;
		this.title = title;
		this.type = type;
	}

	public MarcoException(Exception e) {
		this(e.getMessage());
	}

	@Override
	public String toString() {
		return this.getMessage();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionType getType() {
		return type;
	}

	public void setType(ExceptionType type) {
		this.type = type;
	}
	
	public MarcoException clearStackTrace() {
		this.setStackTrace(new StackTraceElement[0]);
		return this;
	}

}
