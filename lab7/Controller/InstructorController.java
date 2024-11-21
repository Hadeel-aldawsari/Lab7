package com.example.lab7.Controller;
import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Course;
import com.example.lab7.Model.Instructor;
import com.example.lab7.Service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService InstructorService;

    @GetMapping("/get-all")
    public ResponseEntity getInstructor(){
        return ResponseEntity.status(200).body(InstructorService.getInstructors());
    }

    @PostMapping("/add")
    public ResponseEntity addInstructor(@RequestBody @Valid Instructor instructor, Errors errors){
        if(errors.hasErrors())return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        InstructorService.addCourses(instructor);
        return ResponseEntity.status(200).body(new ApiResponse("instructor added successfully"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id,@RequestBody @Valid Instructor instructor, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated=InstructorService.update(id,instructor);
        if(isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("instructor updated successfully"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("instructor id Not found"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        boolean isDelete=InstructorService.delete(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("instructor delete successfully"));
        }return ResponseEntity.status(400).body(new ApiResponse("instructor id Not found"));

    }

    @GetMapping("/get-instructor-by-field/{field}")
    public ResponseEntity getInstructorByField(@PathVariable String field){
                return ResponseEntity.status(200).body(InstructorService.getInstructorByField(field));
    }

    @PutMapping("/debit-balance/{id}/{amount}")
    public ResponseEntity debitBalance(@PathVariable String id,@PathVariable double amount){
        if(InstructorService.debitBalance(id,amount))
            return ResponseEntity.status(200).body(new ApiResponse("balance debit successfully"));
        return ResponseEntity.status(400).body(new ApiResponse("sorry balance debit unsuccessfully"));
    }


    @GetMapping("/classify-instructor/{id}")
    public ResponseEntity classifyInstructor(@PathVariable String id){
        if(InstructorService.classifyInstructor(id).equalsIgnoreCase(null))
            return ResponseEntity.status(400).body(new ApiResponse("not found id"));
        return ResponseEntity.status(200).body(InstructorService.classifyInstructor(id));
    }



}
