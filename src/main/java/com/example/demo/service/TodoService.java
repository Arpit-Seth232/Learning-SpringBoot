package com.example.demo.service;

import java.util.*;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    public final TodoRepository repo;

    public TodoService(TodoRepository repo){
        this.repo = repo;
    }

    public List<Todo> getAll() {
        return repo.findAll();

    }

    public Optional<Todo> getTodoByID(int Id){
        return repo.findById(Id);
    }

    public Todo add(Todo todo) {

        return repo.save(todo);
    }

    public String delete(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "deleted";
        }
        else{
            return "not found";
        }
    }



}
