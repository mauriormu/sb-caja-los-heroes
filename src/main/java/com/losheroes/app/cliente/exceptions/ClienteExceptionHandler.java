package com.losheroes.app.cliente.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ClienteExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleSqlIntegrityException(HttpServletRequest req,
                                                                  SQLIntegrityConstraintViolationException ex){
        String error = "" + ex.getMessage();
        if(error.contains("UK_CORREO")){
            error = "Correo Duplicado: " + ex.getMessage();
        }else if(error.contains("UK_RUT")){
            error = "RUT Duplicado: " + ex.getMessage();
        }
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest req,
                                                               NoSuchElementException ex){
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
        response.setMessage("No Such Element " + req.getRequestURI());
        return buildResponseEntity(response);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        errorResponse.setCode(errorResponse.getStatus().value());
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }



}
