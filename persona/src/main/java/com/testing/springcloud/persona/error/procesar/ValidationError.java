package com.testing.springcloud.persona.error.procesar;

public class ValidationError {
	private String field;
	private String message;

	public ValidationError() {
	}

	public ValidationError(String message) {
		this((String) null, message);
	}

	public ValidationError(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}