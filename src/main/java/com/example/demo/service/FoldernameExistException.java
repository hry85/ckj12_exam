package com.example.demo.service;

public class FoldernameExistException extends RuntimeException{
	public FoldernameExistException(String msg) {
		super(msg);
	}
}
