package com.BookManagementSystem.college.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException {
    public BookNotFoundException(String message){
        super();

    }


}
