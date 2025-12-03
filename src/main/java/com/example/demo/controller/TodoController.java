package com.example.demo.controller;
import java.util.*;

import com.example.demo.NotFoundResponse;
import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {




    public final TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<?> getTodos(){

        List<Todo> todosList = service.getAll();

        System.out.println(todosList);

        if(todosList.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("nothing to show sorry");
        }
        else{
            return ResponseEntity.ok(todosList);
        }


    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        Todo savedTodo = service.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodo(@PathVariable int todoId){
        Optional<Todo> todo = service.getTodoByID(todoId);

        if(todo.isEmpty()) {
            NotFoundResponse notFound = new NotFoundResponse();
            notFound.setId(todoId);
            notFound.setMessage("todo with id " + todoId + " !!! NOT FOUND !!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }
        else{
            return ResponseEntity.ok(todo.get());
        }
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodo (@PathVariable int todoId){
        String msg = service.delete(todoId);



        if(msg.equals("deleted")){
            return ResponseEntity.ok(msg);
        }
        else{
            NotFoundResponse notFound = new NotFoundResponse();
            notFound.setId(todoId);
            notFound.setMessage("todo with id " + todoId + " !!! NOT FOUND !!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }

    }

//    @PatchMapping("")
//    public ResponseEntity<?> updateTodo(@RequestBody Todo updatedTodo){
//
//        boolean updated = false;
//
//        for (Todo t : ){
//            if(t.getId() == updatedTodo.getId()){
//                TodoList.remove(t);
//                TodoList.add(updatedTodo);
//                updated = true;
//                break;
//            }
//        }
//
//        if(updated){
//            return ResponseEntity.ok(updatedTodo);
//        }
//        else{
//            long id = updatedTodo.getId();
//            NotFoundResponse notFound = new NotFoundResponse();
//            notFound.setId(id);
//            notFound.setMessage("todo with id " + id + " !!! NOT FOUND !!!");
//            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
//        }
//
//    }


}
