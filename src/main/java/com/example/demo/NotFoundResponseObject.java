package com.example.demo;

public class NotFoundResponseObject{
	private Long id;
	private String message;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
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
