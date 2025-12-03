package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "todos")
public class Todo {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "boolean default false")
	private boolean completed;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false)
	private int userId;


	@CreationTimestamp
	@Column(name = "created_at",updatable = false)
	private LocalDateTime createdAt;


	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;


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

	public void setCreatedAt(LocalDateTime createdAt){
		this.createdAt = createdAt;
	}

	public LocalDateTime getCreatedAt(){
		return this.createdAt ;
	}

	public void setUpdatedAt(LocalDateTime updatedAt){
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getUpdatedAt(){
		return this.updatedAt ;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"id = '" + id + '\'' + 
			",completed = '" + completed + '\'' + 
			",title = '" + title + '\'' + 
			",userId = '" + userId + '\'' +
			",created_at = '" + createdAt + '\''+
					",updated_at = '" + updatedAt + '\''+
			"}";
		}
}
