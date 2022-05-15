package com.bestseller.gamersApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidGamerException extends RuntimeException {

	public InvalidGamerException(String message) {
		super(message);
	}

}
