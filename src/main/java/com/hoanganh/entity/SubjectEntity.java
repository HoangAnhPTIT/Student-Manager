package com.hoanganh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class SubjectEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "numberofcertificate")
	private int numberOfCertificate;

	@Column(name = "studentpersubject")
	private int studentPerSubject;

	@ManyToMany(mappedBy = "subjects")
	private List<StudentEntity> students = new ArrayList<>();

	@ManyToMany(mappedBy = "subjects")
	private List<TeacherEntity> teachers = new ArrayList<>();

	@ManyToMany(mappedBy = "subjectExams")
	private List<StudentEntity> studentExams = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfCertificate() {
		return numberOfCertificate;
	}

	public void setNumberOfCertificate(int numberOfCertificate) {
		this.numberOfCertificate = numberOfCertificate;
	}

	public int getStudentPerSubject() {
		return studentPerSubject;
	}

	public void setStudentPerSubject(int studentPerSubject) {
		this.studentPerSubject = studentPerSubject;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	public List<TeacherEntity> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}

	public List<StudentEntity> getStudentExams() {
		return studentExams;
	}

	public void setStudentExams(List<StudentEntity> studentExams) {
		this.studentExams = studentExams;
	}



}
