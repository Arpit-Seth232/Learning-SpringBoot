package com.example.demo;

public class NotFoundResponse {
	private int id;
	private String message;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}


	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"NotFoundResponseObject{" + 
			"id = '" + id + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
