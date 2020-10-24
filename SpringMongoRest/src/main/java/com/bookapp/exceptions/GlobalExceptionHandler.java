package com.bookapp.exceptions;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler{


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
    String message=ex.getMessage();
    LocalDateTime timestamp=LocalDateTime.now();
    List<String>details=Arrays.asList("Wrong method name","Not supoprted");
    APIErrors apierrors=
    		new APIErrors(message,timestamp,status,details);
        return ResponseEntity.status(status).body(apierrors);
    }

 

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        LocalDateTime timestamp=LocalDateTime.now();
        List<String>details=Arrays.asList("Wrong media type","Not valid");
        APIErrors apierrors=new APIErrors(message,timestamp,status,details);
            return ResponseEntity.status(status).body(apierrors);
    }

 

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        LocalDateTime timestamp=LocalDateTime.now();
        List<String>details=Arrays.asList("missing params","Not supoprted");
        APIErrors apierrors=new APIErrors(message,timestamp,status,details);
            return ResponseEntity.status(status).body(apierrors);
    }

 

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        LocalDateTime timestamp=LocalDateTime.now();
        List<String>details=Arrays.asList("missing servlet request params","No params");
        APIErrors apierrors=new APIErrors(message,timestamp,status,details);
            return ResponseEntity.status(status).body(apierrors);
    }

 

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String message=ex.getMessage();
        LocalDateTime timestamp=LocalDateTime.now();
        List<String>details=Arrays.asList("type mismatch","invalid");
        APIErrors apierrors=new APIErrors(message,timestamp,status,details);
            return ResponseEntity.status(status).body(apierrors);
    }
    
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object>
    handleBookException(BookNotFoundException ex){
    	String message=ex.getMessage();
        LocalDateTime timestamp=LocalDateTime.now();
        List<String>details=Arrays.asList("book is notavailable");
        APIErrors apierrors=new APIErrors(message,timestamp,HttpStatus.BAD_REQUEST,details);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apierrors);
    	
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>
    handleOtherException(Exception ex){
    	String message=ex.getMessage();
        LocalDateTime timestamp=LocalDateTime.now();
        List<String>details=Arrays.asList(message);
        APIErrors apierrors=new APIErrors(message,timestamp,HttpStatus.INTERNAL_SERVER_ERROR,details);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apierrors);
    	
    }

 
	
	
}
