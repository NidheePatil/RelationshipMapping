package org.example.controller;

import org.example.dao.StudentRepository;
import org.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.service.StudentService;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {

        @Autowired
        StudentService studentService ;

        @RequestMapping(value = "/students", method = RequestMethod.GET, headers = "Accept=application/json")
        public ResponseEntity<List<Student>> getAllStudents(Model model) {

          return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

        @RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET, headers = "Accept=application/json")
        public ResponseEntity<Student> getStudentById(@PathVariable UUID studentId) {

        return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.OK);
    }

        @RequestMapping(value = "/student", method = RequestMethod.POST, headers = "Accept=application/json")
        public ResponseEntity<Object> addStudent(@RequestBody Student student) {

        studentService.addStudent(student);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
        @RequestMapping(value = "/students", method = RequestMethod.POST, headers = "Accept=application/json")
        public ResponseEntity<Object> addManyStudents(@RequestBody List<Student> studentList){
        studentService.addManyStudents(studentList);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
        @RequestMapping(value = "/Student", method = RequestMethod.PUT, headers = "Accept=application/json")
        public ResponseEntity<Student> updateStudents(@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);

    }

        @RequestMapping(value = "student/{studentId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
        public void deleteStudent(@PathVariable("studentId") UUID id) {
        studentService.deleteStudent(id);
    }

        @RequestMapping(value = "/students", method = RequestMethod.DELETE, headers = "Accept=application/json")
        public ResponseEntity<Object> deleteStudent() {
        studentService.deleteAllStudent();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
