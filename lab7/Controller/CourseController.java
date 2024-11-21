package com.example.lab7.Controller;
import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Course;
import com.example.lab7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService CourseService;


    @GetMapping("/get-all")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(200).body(CourseService.getCourses());
    }


    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course, Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        CourseService.addCourses(course);
        return ResponseEntity.status(200).body(new ApiResponse("course added successfully"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id,@RequestBody @Valid Course course, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated=CourseService.update(id,course);
        if(isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("course updated successfully"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("course Not found"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        boolean isDelete=CourseService.delete(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("course delete successfully"));
        }return ResponseEntity.status(400).body(new ApiResponse("course id Not found"));

    }



    @PutMapping("/apply-offer/{courseID}/{percent}")
    public ResponseEntity applyOffer(@PathVariable String courseID,@PathVariable int percent){
      if(CourseService.applyOffer(courseID,percent))
          return ResponseEntity.status(200).body(new ApiResponse("offer applied successfully "));

      return ResponseEntity.status(400).body(new ApiResponse("something went wrong"));
    }

@PutMapping("/change-Availability/{courseID}")
    public ResponseEntity changeCourseAvailability(@PathVariable String courseID){
        if(CourseService.changCourseAvailability(courseID))
            return ResponseEntity.status(200).body(new ApiResponse("changed Course Availability successfully "));

       return ResponseEntity.status(400).body(new ApiResponse("course id Not found"));
    }



    @GetMapping("/get-course-by-language/{language}")
    public ResponseEntity getCourseByLanguage(@PathVariable String language){
       if(CourseService.getCourseByLanguage(language).isEmpty())
           return ResponseEntity.status(400).body(new ApiResponse("Not found courses"));
           return ResponseEntity.status(200).body(CourseService.getCourseByLanguage(language));
    }




}
