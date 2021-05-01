package com.testing.springcloud.persona.error.procesar;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.testing.springcloud.common.respuesta.BaseResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ValidationErrorResponse extends BaseResponse {
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = "yyyy-MM-dd HH:mm:ss"
	)
	private LocalDateTime createdDate;
	private List<ValidationError> errors;

	public ValidationErrorResponse() {
	}

	public ValidationErrorResponse(String message, ValidationError... errors) {
		this(message, Arrays.asList(errors));
	}

	public ValidationErrorResponse(String message, List<ValidationError> errors) {
		super(false, HttpStatus.BAD_REQUEST, message);
		this.errors = errors;
		this.createdDate = LocalDateTime.now();
	}

	public LocalDateTime getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<ValidationError> getErrors() {
		return this.errors;
	}

	public void setErrors(List<ValidationError> errors) {
		this.errors = errors;
	}
}