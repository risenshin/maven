package com.iddel.spt.util;

import org.jboss.netty.handler.codec.http.HttpResponseStatus;

import com.iddel.spt.dto.GenericDTO;

public class Util {
	
	public static <T> GenericDTO<T> setGenericDTO(T t, String message) {

		GenericDTO<T> genericDTO = new GenericDTO<>();
		genericDTO.setMessage(message);
		genericDTO.setResponseStatus(HttpResponseStatus.OK);
		genericDTO.setResult(t);

		return genericDTO;
	}

	public static <T> GenericDTO<T> setGenericDTO(T t, String message, HttpResponseStatus responseStatus) {

		GenericDTO<T> genericDTO = new GenericDTO<>();
		genericDTO.setMessage(message);
		genericDTO.setResponseStatus(responseStatus);
		genericDTO.setResult(t);

		return genericDTO;
	}

	public static <T> GenericDTO<T> setGenericDTO(T t, Exception e) {
		GenericDTO<T> genericDTO = new GenericDTO<>();
		genericDTO.setMessage(e.getMessage());
		genericDTO.setResponseStatus(HttpResponseStatus.INTERNAL_SERVER_ERROR);
		genericDTO.setResult(t);

		return genericDTO;

	}

}
