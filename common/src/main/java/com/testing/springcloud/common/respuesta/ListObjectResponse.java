package com.testing.springcloud.common.respuesta;


import org.springframework.http.HttpStatus;

import java.util.List;

public abstract class ListObjectResponse<T> extends BaseResponse {
	private long count;
	private List<T> data;

	public ListObjectResponse() {
	}

	public ListObjectResponse(String message) {
		super(false, HttpStatus.INTERNAL_SERVER_ERROR, message);
	}

	public ListObjectResponse(HttpStatus status, String message) {
		super(false, status.value(), message);
	}

	public ListObjectResponse(int statusCode, String message) {
		super(false, statusCode, message);
	}

	public ListObjectResponse(List<T> data) {
		this("Success", data);
	}

	public ListObjectResponse(List<T> data, long count) {
		this("Success", data);
		this.count = count;
	}

	public ListObjectResponse(String message, List<T> data) {
		super(true, HttpStatus.OK, message);
		this.data = data;
		this.count = data == null ? 0L : (long) data.size();
	}

	public List<T> getData() {
		return this.data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public long getCount() {
		return this.count;
	}

	public void setCount(long count) {
		this.count = count;
	}
}
