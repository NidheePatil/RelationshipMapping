package org.example.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID studentId;

    @Column(name = "studentName")
    String studentName;

    @Column(name = "rollNumber")
    String studentRollNumber;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "STUDENTS_SUBJECTS",
            joinColumns = @JoinColumn(name = "studentid"),
            inverseJoinColumns = @JoinColumn(name = "subjectid")
    )
    private List<Subject> subjects= new ArrayList<>();

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Student() {
    }

    public Student(UUID studentId, String studentName, String studentRollNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentRollNumber() {
        return studentRollNumber;
    }

    public void setStudentRollNumber(String studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }
}
