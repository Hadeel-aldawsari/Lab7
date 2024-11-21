package com.example.lab7.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Student {

    @NotEmpty(message = "student name can't be empty")
    @Size(min = 6, message = "strudent name size can't be less than 6 ")
    private String name;

    @NotEmpty(message = "student id can't be empty")
    private String ID;

    @Email(message = "please enter valid email")
    @NotEmpty(message = "email can't be empty")
    private String email;


    @Positive(message = "enter valid age")
    @Min(value =15,message = "age should be at least 15")
    private int age;


    private String review;

    @AssertFalse(message = "isSubscrib should be false in first")
    private boolean isSubscrib;
}

