package co.develhope.CrudTest.controllers;

import co.develhope.CrudTest.entities.Student;
import co.develhope.CrudTest.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("{id}")
    public ResponseEntity<?> getStudent(@PathVariable long id) {
        try {
            return ResponseEntity.ok().body(studentService.getStudentById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<?> postStudent(@Valid @RequestBody Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            return ResponseEntity.ok().body(studentService.postStudent(student));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student, BindingResult bindingResult,
                                           @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try {
            return ResponseEntity.ok(studentService.updateStudent(student, id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/is-working")
    public ResponseEntity<?> updateIsWorking(@RequestParam("isWorking") boolean isWorking, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.isWorkingUpdate(id,isWorking));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted");
    }
}



