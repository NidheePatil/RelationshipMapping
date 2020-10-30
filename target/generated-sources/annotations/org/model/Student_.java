package org.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, UUID> studentId;
	public static volatile SingularAttribute<Student, String> studentName;
	public static volatile ListAttribute<Student, Subject> subjects;
	public static volatile SingularAttribute<Student, String> studentRollNumber;

	public static final String STUDENT_ID = "studentId";
	public static final String STUDENT_NAME = "studentName";
	public static final String SUBJECTS = "subjects";
	public static final String STUDENT_ROLL_NUMBER = "studentRollNumber";

}

