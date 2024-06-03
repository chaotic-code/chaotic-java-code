package com.ash.response;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponse {

	@Id
	private String todoId;
	private String task;
	private String dueDate;
	private String dueTime;
	private String completedDate;
	private String completedTime;
	private String state;
}
