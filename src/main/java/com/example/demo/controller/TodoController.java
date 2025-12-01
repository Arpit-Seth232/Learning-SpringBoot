package com.example.demo.controller;
import java.util.*;

import com.example.demo.NotFoundResponseObject;
import com.example.demo.TimeMonitor;
import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

//    public List<Todo>TodoList;

//    public TodoController() {
//        TodoList = new ArrayList<Todo>();
//        TodoList.add(new Todo(1, "dsa", false, 1));
//        TodoList.add(new Todo(2, "web", false, 2));
//    }


    public final TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }


    @GetMapping("")
//    @TimeMonitor
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        TodoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodo(@PathVariable Long todoId){
        for (Todo t : TodoList){
            if(t.getId() == todoId){
                return ResponseEntity.ok(t);
            }
        }
        NotFoundResponseObject notFound = new NotFoundResponseObject();
        notFound.setId(todoId);
        notFound.setMessage("todo with id " + todoId + " !!! NOT FOUND !!!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodo (@PathVariable Long todoId){
        Todo delTodo = null;
        for (Todo t : TodoList){
            if(t.getId() == todoId){
                delTodo = t;
                TodoList.remove(t);
            }
        }

        if(delTodo != null){
            return ResponseEntity.ok(delTodo);
        }
        else{
            NotFoundResponseObject notFound = new NotFoundResponseObject();
            notFound.setId(todoId);
            notFound.setMessage("todo with id " + todoId + " !!! NOT FOUND !!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }

    }

    @PatchMapping("")
    public ResponseEntity<?> updateTodo(@RequestBody Todo updatedTodo){

        boolean updated = false;

        for (Todo t : TodoList){
            if(t.getId() == updatedTodo.getId()){
                TodoList.remove(t);
                TodoList.add(updatedTodo);
                updated = true;
                break;
            }
        }

        if(updated){
            return ResponseEntity.ok(updatedTodo);
        }
        else{
            long id = updatedTodo.getId();
            NotFoundResponseObject notFound = new NotFoundResponseObject();
            notFound.setId(id);
            notFound.setMessage("todo with id " + id + " !!! NOT FOUND !!!");
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }

    }


}
