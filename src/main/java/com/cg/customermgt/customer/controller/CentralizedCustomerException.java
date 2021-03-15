package com.cg.customermgt.customer.controller;


import com.cg.customermgt.customer.exceptions.CustomerNotFoundException;
import com.cg.customermgt.customer.exceptions.InvalidIdException;
import com.cg.customermgt.customer.exceptions.InvalidNameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedCustomerException
{
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidIdException.class)
    public String handleInvalidIdException(InvalidIdException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidNameException.class)
    public String handleInvalidNameException(InvalidNameException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleInvalidIdException(CustomerNotFoundException e)
    {
        return e.getMessage();
    }
}