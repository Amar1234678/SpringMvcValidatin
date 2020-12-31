package com.nt.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nt.dao.StudentDaoInterface;
import com.nt.model.Student;

@Service
public class StudentService implements StudentServiceInterface{
	
public StudentService() {
System.out.println("service obj");	
}
@Autowired
StudentDaoInterface sdao;


public String saveStu(Student st) {

	System.out.println("StudentService.saveStu()"+st);
	int i = 0;
	try {
		i = sdao.saveStudent(st);
	} catch (Exception e) {
		e.printStackTrace();
	}
	if(i!=0)
	return "sucess";
	else
	{
		return "not inserted";
	}
}
public String deleteStu(int id) {
	System.out.println("StudentService.deleteStu()"+id);
	String res = null;
	try {
		res=sdao.deleteStudent(id);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return res;
}
public Student getStudent(int id) {
	System.out.println("StudentService.deleteStu()"+id);
	Student student = null;
	try {
		student=sdao.getStudent(id);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return student;
}
public List<Student> getAllStudent() {
	System.out.println("StudentService.deleteStu()");
	List<Student> listStudent = null;
	try {
	listStudent=sdao.getAllStudent();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return listStudent;
}
public String updateStudent(Student stu) {
	System.out.println("StudentService.updateStudent()"+stu);
	String res=sdao.updateStudent(stu);
	
	return res;
}

}
