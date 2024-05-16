package com.ash.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiErrorResponse {

	private String errorMessage;
	private int errorCode;
}
