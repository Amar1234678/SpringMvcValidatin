package com.nt.dao;

import java.util.List;

import com.nt.model.Student;

public interface StudentDaoInterface {
	public int saveStudent(Student st) throws Exception;
	public String deleteStudent(int id);
	public String updateStudent(Student stu);

	public Student getStudent(int id);
	public List<Student> getAllStudent();




}
