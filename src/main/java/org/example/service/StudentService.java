package org.example.service;

import org.example.dao.StudentRepository;
import org.example.dao.SubjectRepository;
import org.example.model.Student;
import org.example.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student getStudent(UUID id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Transactional
    public void addStudent(Student student) {

        List<Subject> subjects= new ArrayList<>();
        student.getSubjects().forEach(subject -> {
            Subject subjectResult= subjectRepository.findBySubjectName(subject.getSubjectName());
           if(subjectResult==null) {
               subjects.add(subjectRepository.save(subject));

           }
           else{
               subjects.add(subjectRepository.findBySubjectName(subject.getSubjectName()));
           }
        });

        Student student1= new Student();
        student1.setStudentName(student.getStudentName());
        student1.setStudentRollNumber(student.getStudentRollNumber());
        student1.setSubjects(subjects);

        studentRepository.save(student1);
    }


    @Transactional
    public void deleteStudent(UUID id) {
        Optional<Student> student = studentRepository.findById(id);
        student.ifPresent(value -> studentRepository.delete(value));
        return;
    }

    @Transactional
    public List<Student> addManyStudents(List<Student> studentList){
        return studentRepository.saveAll(studentList);
    }

    @Transactional
    public Student updateStudent(Student student){
        Student existingStudent = studentRepository.findById(student.getStudentId()).orElse(null);
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentRollNumber(student.getStudentRollNumber());
        return studentRepository.save(existingStudent);

    }

    @Transactional
    public void deleteAllStudent(){
        studentRepository.deleteAll();
    }



}
