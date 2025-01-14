package tw.pan.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import tw.pan.entity.dto.ErrorDto;
import tw.pan.utils.exception.DatabaseOperateException;
import tw.pan.utils.exception.PageNotFoundException;
import tw.pan.utils.exception.RequestErrorException;

@ControllerAdvice
public class SimpleExceptionHandler {

	@ExceptionHandler(DatabaseOperateException.class)
	public ErrorDto serverErrorHandler(HttpServletRequest request) {
		return new ErrorDto()
				.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.setPath(request.getRequestURI());
	}
	
	@ExceptionHandler(PageNotFoundException.class)
	public ErrorDto pageNotFoundHandler(HttpServletRequest request) {
		return new ErrorDto()
				.setStatus(HttpStatus.NOT_FOUND.value())
				.setPath(request.getRequestURI());
	}
	
	@ExceptionHandler(RequestErrorException.class)
	public ErrorDto badRequestHandler(RequestErrorException e, HttpServletRequest request) {
		return new ErrorDto()
				.setStatus(HttpStatus.BAD_REQUEST.value())
				.setMessage(e.getMessage())
				.setPath(request.getRequestURI());
	}
	
	@ExceptionHandler(IOException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDto sqlExceptionHandler(IOException e) {
		return new ErrorDto()
				.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.setMessage(e.getLocalizedMessage());
	}
	
	@ExceptionHandler(ClassNotFoundException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDto classNotFoundException(ClassNotFoundException e) {
		return new ErrorDto()
				.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.setMessage(e.getLocalizedMessage());
	}
	
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDto handleValidationExceptions(ValidationException e) {
		return new ErrorDto()
				.setStatus(HttpStatus.BAD_REQUEST.value())
				.setMessage(e.getLocalizedMessage());
	}
	
}
