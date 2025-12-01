package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "boolean default false")
	private boolean completed;

	@Column(nullable = false, unique = true, length = 100)
	private String title;

	@Column(nullable = false, unique = true)
	private int userId;

	public Todo(int id,String title, boolean completed, int userId){
		this.id = id;
		this.completed = completed;
		this.userId = userId;
		this.title = title;
	}

	public Todo(){

	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCompleted(boolean completed){
		this.completed = completed;
	}

	public boolean isCompleted(){
		return completed;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"id = '" + id + '\'' + 
			",completed = '" + completed + '\'' + 
			",title = '" + title + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}
