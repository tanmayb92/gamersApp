package com.bestseller.gamersApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoGamersForMatchMakingException extends RuntimeException {

	public NoGamersForMatchMakingException(String message) {
		super(message);
  	}

}
