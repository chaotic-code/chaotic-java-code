package com.ash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ash.document.Todo;
import com.ash.repository.TodoRepository;
import com.ash.request.CompleteTodoRequest;
import com.ash.request.CreateTodoRequest;
import com.ash.response.TodoPage;
import com.ash.response.TodoResponse;
import com.ash.service.TodoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;
	
	@Override
	public Todo createTodo(CreateTodoRequest request) {
		Todo todo = new Todo();
		BeanUtils.copyProperties(request, todo);
		return todoRepository.save(todo);
	}

	@Override
	public Todo updateTodo(CompleteTodoRequest request) {
		Optional<Todo> todo = todoRepository.findById(request.getTodoId());
		BeanUtils.copyProperties(request, todo.get());
		return todoRepository.save(todo.get());
	}

	@Override
	public List<Todo> getAllTodo() {
		return todoRepository.findAll();
	}

	@Override
	public Page<TodoResponse> getAllTodoWithPagination(Integer page, Integer size) {		
		int skip = page * size;
		int limit = size;
		
		TodoPage todoPage = todoRepository.findAllTodoWithPagination(skip, limit);
		Pageable pageRequest = PageRequest.of(page, size);
		Page<TodoResponse> pageResponse = new PageImpl<>(todoPage.getTodoList(), pageRequest, todoPage.getTotalCount());
		return pageResponse;
	}

	
}
