package com.example.springproject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// makes this class serve REST endpoints
@RestController

// define the url mapping
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    // This lets StudentService be injected into the constructor
    // meaning that an instance of studentService will be instantiated automatically.
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // We have a total of 4 REST endpoints
    // Gives an array of students
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    // RequestBody - This annotation informs Spring to deserialize an incoming request
    // body to the Student domain object.
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long StudentId){
        studentService.deleteStudent(StudentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}

// To run applciation - open a terminal and cd to target folder
// then type: java -jar spring-project-0.0.1-SNAPSHOT.jar
