package com.bestseller.gamersApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidGeographyException extends RuntimeException {

	public InvalidGeographyException(String message) {
		super(message);
	}

}
