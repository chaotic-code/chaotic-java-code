package com.ash.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ash.document.Todo;
import com.ash.request.CompleteTodoRequest;
import com.ash.request.CreateTodoRequest;
import com.ash.response.TodoResponse;

public interface TodoService {

	public Todo createTodo(CreateTodoRequest request);

	public Todo updateTodo(CompleteTodoRequest request);

	public Page<TodoResponse> getAllTodoWithPagination(Integer page, Integer size);

	public List<Todo> getAllTodo();

}
