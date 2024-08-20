package com.example.Menus.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class InvalidMenuItemException extends RuntimeException {

	public InvalidMenuItemException (String msg) {
		super(msg);
	}
}
