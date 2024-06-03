package com.ash.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ash.document.Todo;
import com.ash.request.CompleteTodoRequest;
import com.ash.request.CreateTodoRequest;
import com.ash.response.TodoResponse;
import com.ash.service.TodoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TodoController {

	private final TodoService todoService;
	
	@PostMapping("/createTodo")
	public ResponseEntity<Todo> createTodo(@RequestBody CreateTodoRequest request){
		Todo todo = todoService.createTodo(request);
		return new ResponseEntity<>(todo, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateTodo")
	public ResponseEntity<Todo> updateTodo(@RequestBody CompleteTodoRequest request){
		Todo todo = todoService.updateTodo(request);
		return new ResponseEntity<>(todo, HttpStatus.OK);
	}
	
	@GetMapping("/getAllTodo")
	public ResponseEntity<List<Todo>> getAllTodo(){
		List<Todo> todo = todoService.getAllTodo();
		return new ResponseEntity<>(todo, HttpStatus.OK);
	}
	
	@GetMapping("/getAllTodoWithPagination")
	public ResponseEntity<Page<TodoResponse>> getAllTodoWithPagination(@RequestParam Integer page, @RequestParam Integer size){
		Page<TodoResponse> todo = todoService.getAllTodoWithPagination(page, size);
		return new ResponseEntity<>(todo, HttpStatus.OK);
	}
}
