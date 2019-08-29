package com.medalytics.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/students")
public class StudentController {

   private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody
    List findAll(){
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Student> findStudent(@PathVariable Long id){
        return studentRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
/*
    @GetMapping
    public @ResponseBody Student findByFirstName(@RequestParam(value="first_name") String first_name){
        return studentRepository.findByFirstName(first_name);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody void updateStudent(@PathVariable Long id){
        studentRepository.updateStudent(id);
    }*/

    @PostMapping
    void addStudent(@RequestBody Student student){
        studentRepository.save(student);
    }
/*
    @PutMapping(value = "/{id}")
    void updateStudent(@RequestBody )
*/
    @DeleteMapping(value = "/students/{id}")
    void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

}
