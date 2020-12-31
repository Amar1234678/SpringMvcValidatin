package com.nt.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nt.model.Student;

@Repository
public class StudentDaoImpl implements StudentDaoInterface{

public StudentDaoImpl() {

	System.out.println("StudentDaoImpl.StudentDaoImpl()");
}
@Autowired
private SessionFactory sessionFactory;

Session ses=null;


Transaction tx;

public int saveStudent(Student st) {
	System.out.println("StudentDaoImpl.saveStudent()"+st);
	int i = 0;
	try
	{
	ses=sessionFactory.openSession();
	tx=ses.beginTransaction();
	System.out.println("before");
	i=(Integer) ses.save(st);
	System.out.println("returnn::"+i);
	tx.commit();
	}
	catch (Exception e) {
		if(tx!=null)
		tx.rollback();
		e.printStackTrace();
	}
	return i;
	
}
public String deleteStudent(int id) {
	System.out.println("StudentDaoImpl.deleteStudent()"+id);
	try
	{
	ses=sessionFactory.openSession();
	tx=ses.beginTransaction();
	//tx.begin();
	System.out.println("before");
       Student s=(Student) ses.get(Student.class,id);
	System.out.println("returnn::"+s);
	ses.delete(s);
	tx.commit();
	return "sucessfully delete";
	}
	catch (Exception e) {
		if(tx!=null)
		tx.rollback();
		e.printStackTrace();
		return "not deleted";
	}
}
public Student getStudent(int id) {
	
	System.out.println("StudentDaoImpl.deleteStudent()"+id);
	Student student=null;
	try
	{
	ses=sessionFactory.openSession();
	System.out.println("before");
       student=(Student) ses.get(Student.class,id);

	}
	catch (Exception e) {
		e.printStackTrace();
		
	}
	return student;
}
public List<Student> getAllStudent() {
	System.out.println("StudentDaoImpl.deleteStudent()");
	List<Student> list = null;
	try
	{
	ses=sessionFactory.openSession();
       list=ses.createCriteria(Student.class).list();

	}
	catch (Exception e) {
		e.printStackTrace();
		
	}
	return list;
}
public String updateStudent(Student stu) {
	try
	{
	ses=sessionFactory.openSession();
	tx=ses.beginTransaction();
       ses.update(stu);
	
	tx.commit();
	return "sucessfully update";
	}
	catch (Exception e) {
		if(tx!=null)
		tx.rollback();
		return "not update";
	}
	}

}
