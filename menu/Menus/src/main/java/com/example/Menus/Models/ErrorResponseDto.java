package com.example.Menus.Models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorResponseDto {


  
   
  

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public HttpStatus getCode() {
		return code;
	}


	public void setCode(HttpStatus code) {
		this.code = code;
	}


	private String msg;
    
    private HttpStatus code;

    
    public ErrorResponseDto(String message, HttpStatus badRequest) {
  		// TODO Auto-generated constructor stub
      	this.msg = message;
      	this.code = badRequest;
  	}

   
}