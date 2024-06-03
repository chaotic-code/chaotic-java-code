package com.ash.request;

import lombok.Data;

@Data
public class CreateTodoRequest {

	private String task;
	private String dueDate;
	private String dueTime;
}
