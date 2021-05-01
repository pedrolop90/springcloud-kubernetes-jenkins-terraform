package com.testing.springcloud.common.respuesta;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public class BaseResponse {
	private boolean success;
	private int statusCode;
	private String message;

	public BaseResponse() {
	}

	public BaseResponse(boolean success, @NotNull HttpStatus status, String message) {
		this.success = success;
		this.statusCode = status.value();
		this.message = message;
	}

	public BaseResponse(boolean success, int statusCode, String message) {
		this.success = success;
		this.statusCode = statusCode;
		this.message = message;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@JsonIgnore
	public HttpStatus getStatus() {
		HttpStatus[] var1 = HttpStatus.values();
		int var2 = var1.length;

		for (int var3 = 0; var3 < var2; ++var3) {
			HttpStatus status = var1[var3];
			if (status.value() == this.statusCode) {
				return status;
			}
		}

		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	@JsonIgnore
	public void setStatus(HttpStatus status) {
		this.statusCode = status.value();
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}