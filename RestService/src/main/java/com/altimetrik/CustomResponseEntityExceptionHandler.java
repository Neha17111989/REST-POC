package com.altimetrik;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.altimetrik.model.UserNotPresentException;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(Exception.class)
	ResponseEntity<Object> handleAllException(Exception ex, WebRequest wr) {
		CustomException exce = new CustomException(new Date(), ex.getMessage(), wr.getDescription(false));
		return new ResponseEntity(exce, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserNotPresentException.class)
	ResponseEntity<Object> handleCutomException(Exception ex, WebRequest wr) {
		CustomException exce = new CustomException(new Date(), ex.getMessage(), wr.getDescription(false));
		return new ResponseEntity(exce, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomException exce = new CustomException(new Date(), "validation error msg",
				ex.getBindingResult().getObjectName());
		return new ResponseEntity(exce, HttpStatus.BAD_REQUEST);
	}

}
