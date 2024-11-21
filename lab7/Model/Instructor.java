package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Instructor {
    @NotEmpty(message = "Instructor name can't be empty")
    @Size(min = 6, message = "Instructor name size can't be less than 6 ")
    private String name;

    @NotEmpty(message = "Instructor id can't be empty")
    private String ID;


    @Email(message = "please enter valid email")
    @NotEmpty(message = "email can't be empty")
    private String email;

    @NotNull(message = "balance can't be null")
    @PositiveOrZero(message = "enter valid balance")
    private double balance;

    @NotEmpty(message = "field can't be empty")
    @Pattern(regexp = "^(back end |front end |data base)$", message = "enter valid field back end |front end |data base")
    private String field;

    @NotNull(message = "years Of Experience can't be null")
    @Positive(message = "enter valid years Of Experience")
    private int yearsOfExperience;


    //it can be null in the first, the instructor will add course
    private ArrayList<Course>InstructorCourses;

}
