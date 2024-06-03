package com.ash.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoPage {

	private List<TodoResponse> todoList;
	private int totalCount;
}
