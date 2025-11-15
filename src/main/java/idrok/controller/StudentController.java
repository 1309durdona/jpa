package idrok.controller;


import idrok.model.Student;
import idrok.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        List<Student> list = studentService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok().body(studentService.create(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getId(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        return  ResponseEntity.ok().body(student);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        Student updatedStudent = studentService.update(id, student);
        return ResponseEntity.ok().body(updatedStudent);
    }



}
