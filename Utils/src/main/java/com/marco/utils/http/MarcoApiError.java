package com.marco.utils.http;

import com.marco.utils.MarcoException;
import com.marco.utils.MarcoException.ExceptionType;

public class MarcoApiError {
	public MarcoApiError() {
	}

	public MarcoApiError(MarcoException e) {
		this(e.getTitle(), e.getMessage(), e.getType());
	}

	public MarcoApiError(String title, String message, ExceptionType type) {
		this.title = title;
		this.message = message;
		this.type = type;
	}

	private String title;
	private String message;
	private ExceptionType type;
	private boolean close = true;

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

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}
}
