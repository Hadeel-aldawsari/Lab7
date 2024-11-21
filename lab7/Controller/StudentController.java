package com.example.lab7.Controller;


import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService  StudentService;



    @GetMapping("/get-all")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(200).body(StudentService.getStudent());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        StudentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id,@RequestBody @Valid Student Student, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated=StudentService.update(id,Student);
        if(isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Student Not found"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        boolean isDelete=StudentService.delete(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("Student delete successfully"));
        }return ResponseEntity.status(400).body(new ApiResponse("Student id Not found"));

    }


    @PutMapping("/add-review/{id}")
    public ResponseEntity addReview(@PathVariable String id,@RequestBody @Valid String review){
        if(StudentService.addReview(id,review)){
            return ResponseEntity.status(200).body(new ApiResponse("review added successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("review added unSuccessfully"));
    }


    @GetMapping("/get-average-age")
    public ResponseEntity GetAverageStudentAge(){
        return ResponseEntity.status(200).body(StudentService.GetAverageStudentAge());
    }


    @PutMapping("/subscribe/{id}")
    public ResponseEntity SubscribeInNews(@PathVariable String id){
        if (StudentService.SubscribeInNews(id))
            return ResponseEntity.status(200).body(new ApiResponse("Subscribe successfully"));
        return ResponseEntity.status(400).body(new ApiResponse("Subscribe unSuccessfully"));

    }

}
