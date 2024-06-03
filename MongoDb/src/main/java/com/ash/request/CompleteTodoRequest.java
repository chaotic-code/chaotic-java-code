package com.ash.request;

import lombok.Data;

@Data
public class CompleteTodoRequest {

	private String todoId;
	private String completedDate;
	private String completedTime;
}
