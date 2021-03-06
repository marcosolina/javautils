package com.marco.utils.http;

import java.util.ArrayList;
import java.util.List;

import com.marco.utils.MarcoException;

public abstract class MarcoResponse {
	private boolean status;
	private List<MarcoApiError> errors;

	public boolean addError(MarcoException e) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		return errors.add(new MarcoApiError(e));
	}
	
	public boolean addError(MarcoApiError e) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		return errors.add(e);
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<MarcoApiError> getErrors() {
		return errors;
	}

	public void setErrors(List<MarcoApiError> errors) {
		this.errors = errors;
	}

}
