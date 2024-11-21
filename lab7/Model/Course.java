package com.example.lab7.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {

    @NotEmpty(message = "course name can't be empty")
    @Size(min=6,message = "course name size can't be less than 6 ")
   private String name;

    @NotEmpty(message = "course id can't be empty")
   private String ID;

    @NotEmpty(message = "course description can't be empty")
    @Size(min=10,message = "course description size can't be less than 10")
    private String description;

//    @NotEmpty(message = "Instructor name can't be empty")
//    @Size(min=4,message = "Instructor name size can't be less than 6 ")
//   private String Instructor;

    @NotEmpty(message = "category name can't be empty")
    @Pattern(regexp = "^(back end |front end |data base)$", message = "enter valid category back end |front end |data base")
    private String category;

    @NotNull(message = "course price can't be null")
    @Positive(message = "enter valid course price")
    @Min(value =5,message = "min value of offer should be between 5 - 100")
    @Max(value =100,message = "max value of offer should be between 5 - 100")
    private double price;

    @Min(value = 1,message = "rate should be from 1 to 5")
    @Max(value = 5,message ="rate should be from 1 to 5" )
    private int rate;

    @AssertTrue(message = "the course should be availability = true")
   private boolean isAvalible;

    @NotEmpty(message = "course language can't be empty")
    @Pattern(regexp = "^(arabic |english)$", message = "enter valid category arabic or english")
    private String courseLanguage;

}
