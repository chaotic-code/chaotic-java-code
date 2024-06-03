package com.ash.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ash.document.Todo;
import com.ash.response.TodoPage;

public interface TodoRepository extends MongoRepository<Todo, String>{

	
	@Aggregation({
		"{$addFields:{dueDateTime:{$dateFromString:{dateString:{$concat:[\"$dueDate\",\"$dueTime\"]}}}}}",
		"{$facet:{output1:[{$match:{dueDateTime:{$lt:new Date()}}},{$addFields:{state:\"Overdue\"}}],output2:[{$match:{dueDateTime:{$gte:new Date()}}},{$addFields:{state:\"Pending\"}}]}}",
		"{$project:{mergedOutput:{$concatArrays:[\"$output1\",\"$output2\"]}}}",
		"{$unwind:{path:\"$mergedOutput\"}}",
		"{$replaceRoot:{newRoot:\"$mergedOutput\"}}",
		"{$facet:{totalCount:[{$count:\"totallTodo\"}],todoList:[{$skip:?0},{$limit:?1}]}}",
		"{$project:{totalCount:{$arrayElemAt:[\"$totalCount.totallTodo\",0]},todoList:1}}"
	})
	TodoPage findAllTodoWithPagination(int skip, int limit);

	
}
