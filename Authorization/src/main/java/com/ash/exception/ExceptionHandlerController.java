package com.ash.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController  extends ResponseEntityExceptionHandler{

	@ExceptionHandler({Exception.class})
	private ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request){
		log.error("ExceptionHandlerController :: handleGenericException :: {}", ex.getMessage());
		return handleExceptionInternal(ex, buildErrorResponse(ex.getMessage(), 400), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({AccessDeniedException.class})
	private ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex, WebRequest request){
		log.error("ExceptionHandlerController :: handleAccessDeniedException :: {}", ex.getMessage());
		return handleExceptionInternal(ex, buildErrorResponse(ex.getMessage(), 403), new HttpHeaders(), HttpStatus.FORBIDDEN, request);
	}
	
	@ExceptionHandler({AlreadyExistException.class})
	private ResponseEntity<Object> handleAlreadyExistException(AlreadyExistException ex, WebRequest request){
		log.error("ExceptionHandlerController :: handleAlreadyExistException :: {}", ex.getMessage());
		return handleExceptionInternal(ex, buildErrorResponse(ex.getMessage(), 409), new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler({NotFoundException.class})
	private ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request){
		log.error("ExceptionHandlerController :: handleNotFoundException :: {}", ex.getMessage());
		return handleExceptionInternal(ex, buildErrorResponse(ex.getMessage(), 404), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	private ApiErrorResponse buildErrorResponse(String msg, int errorCode) {
		return ApiErrorResponse.builder().errorCode(errorCode).errorMessage(msg).build();	
	}
}
