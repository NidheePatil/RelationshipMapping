package org.example.service;

import org.example.dao.StudentRepository;
import org.example.dao.SubjectRepository;
import org.example.model.Student;
import org.example.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public Subject getByName(Subject subject){
        return subjectRepository.findBySubjectName(subject.getSubjectName());

    }
    @Transactional
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Transactional
    public Subject getSubject(UUID id) {
        Optional<Subject> Subject = subjectRepository.findById(id);
        return Subject.orElse(null);
    }

    @Transactional
    public String addSubject(Subject subject) {
        if(getByName(subject)==null) {

            subjectRepository.save(subject);
            return "CREATED";
        }
        else{
            return "ALREADY PRESENT";
        }
    }


    @Transactional
    public void deleteSubject(UUID id) {
        Optional<Subject> Subject = subjectRepository.findById(id);
        Subject.ifPresent(value -> subjectRepository.delete(value));
        return;
    }

    @Transactional
    public List<Subject> addManySubject(List<Subject> subjectList){

        List<Subject> subjectList2= new ArrayList<>();

        subjectList.forEach(subject -> {
            List<Student> newStudentList= subject.getStudents();
            Subject subjectResult= subjectRepository.findBySubjectName(subject.getSubjectName());
           if(subjectResult==null){

               subjectList2.add(subjectRepository.save(subject));
           }
           else{
               // subjectResult.setStudents(newStudentList);
               subjectList2.add(subjectResult);
               newStudentList.forEach(student -> {
                   Student newStudent= new Student();
                   newStudent.setStudentRollNumber(student.getStudentRollNumber());
                   newStudent.setStudentName(student.getStudentName());
                   newStudent.setSubjects(subjectList2);
                   studentRepository.save(newStudent);
               });
           }

        });
        return subjectRepository.saveAll(subjectList2);
    }

    @Transactional
    public Subject updateSubject(Subject Subject){
        Subject existingSubject = subjectRepository.findById(Subject.getSubjectId()).orElse(null);
        existingSubject.setSubjectName(Subject.getSubjectName());
        return subjectRepository.save(existingSubject);

    }

    @Transactional
    public void deleteAllSubject(){
        subjectRepository.deleteAll();
    }


}
