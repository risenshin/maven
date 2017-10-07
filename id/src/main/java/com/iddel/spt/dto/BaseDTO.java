package com.iddel.spt.dto;

import org.jboss.netty.handler.codec.http.HttpResponseStatus;

public class BaseDTO<T> {
	private String Message;

	private HttpResponseStatus responseStatus = HttpResponseStatus.OK;

	private T result;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public BaseDTO() {
		super();
	}

	public BaseDTO(String message, HttpResponseStatus responseStatus) {
		super();
		Message = message;
		this.responseStatus = responseStatus;

	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public HttpResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	@Override
	public String toString() {
		return "BaseDTO [Message=" + Message + ", responseStatus=" + responseStatus + ", result=" + result + "]";
	}

}
