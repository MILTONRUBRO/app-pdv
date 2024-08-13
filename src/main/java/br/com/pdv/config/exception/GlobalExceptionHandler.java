package br.com.pdv.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidQuantityException.class)
    public ResponseEntity<ApiErrorMessage> handleInvalidProductException(InvalidQuantityException ex, WebRequest request) {
        ApiErrorMessage errorResponse = new ApiErrorMessage();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        errorResponse.setPath(request.getDescription(false).substring(4)); // Remove o "uri=" do início da string
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEnumValueException.class)
    public ResponseEntity<ApiErrorMessage> handleInvalidEnumValueException(InvalidEnumValueException ex, WebRequest request) {
        ApiErrorMessage errorResponse = new ApiErrorMessage();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        errorResponse.setPath(request.getDescription(false));
        return ResponseEntity.badRequest().body(errorResponse);
    }
}