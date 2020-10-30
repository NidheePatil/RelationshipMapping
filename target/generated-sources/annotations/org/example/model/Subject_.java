package org.example.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subject.class)
public abstract class Subject_ {

	public static volatile ListAttribute<Subject, Student> students;
	public static volatile SingularAttribute<Subject, UUID> subjectId;
	public static volatile SingularAttribute<Subject, String> subjectName;

	public static final String STUDENTS = "students";
	public static final String SUBJECT_ID = "subjectId";
	public static final String SUBJECT_NAME = "subjectName";

}

