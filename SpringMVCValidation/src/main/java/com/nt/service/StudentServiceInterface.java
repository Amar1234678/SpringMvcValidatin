package com.nt.service;

import java.util.List;

import com.nt.model.Student;

public interface StudentServiceInterface {
	public String saveStu(Student st);
	public String deleteStu(int id);
	public Student getStudent(int id);
	public String updateStudent(Student stu);

	public List<Student> getAllStudent();




}
