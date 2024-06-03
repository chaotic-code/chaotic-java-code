package com.ash.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Todo")
public class Todo {

	@Id
	private String todoId;
	private String task;
	private String dueDate;
	private String dueTime;
	private String completedDate;
	private String completedTime;
	private String userName;
}
