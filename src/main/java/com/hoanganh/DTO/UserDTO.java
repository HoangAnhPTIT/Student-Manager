package com.hoanganh.DTO;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
	private Long id;
	private String address;
	private int age;
	private String fullName;
	private String userName;
	private String password;
	private String gender;
	private String code;
	private List<UserDTO> listResult = new ArrayList<>();
	private List<StudentDTO> listStudent = new ArrayList<>();
	private List<TeacherDTO> listTeacher = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UserDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<UserDTO> listResult) {
		this.listResult = listResult;
	}

	public List<StudentDTO> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<StudentDTO> listStudent) {
		this.listStudent = listStudent;
	}

	public List<TeacherDTO> getListTeacher() {
		return listTeacher;
	}

	public void setListTeacher(List<TeacherDTO> listTeacher) {
		this.listTeacher = listTeacher;
	}

}
