package org.example.controller;

import org.example.dao.SubjectRepository;
import org.example.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.service.SubjectService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "/subjects", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Subject>> getAllSubjects(Model model) {

        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatus.OK);
    }

    @RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Subject> getSubjectById(@PathVariable UUID subjectId) {

        return new ResponseEntity<>(subjectService.getSubject(subjectId), HttpStatus.OK);
    }

    @RequestMapping(value = "/subject", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Object> addSubject(@RequestBody Subject subject) {

        String result=subjectService.addSubject(subject);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Object> addManySubjects(@RequestBody List<Subject> subjectList) {
        subjectService.addManySubject(subjectList);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/subject", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Subject> updateSubjects(@RequestBody Subject subject) {
        return new ResponseEntity<>(subjectService.updateSubject(subject), HttpStatus.OK);

    }

    @RequestMapping(value = "subject/{subjectId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteSubject(@PathVariable("subjectId") UUID id) {
        subjectService.deleteSubject(id);
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Object> deleteSubject() {
        subjectService.deleteAllSubject();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}