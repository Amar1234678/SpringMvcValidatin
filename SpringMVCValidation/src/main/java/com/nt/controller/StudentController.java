package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.model.Student;
import com.nt.service.StudentServiceInterface;

@Controller
public class StudentController {
	
	
	@Autowired
	StudentServiceInterface ser;
	
	
	StudentController() {
	System.out.println("controller");
	}


	@RequestMapping(name="/save",method =RequestMethod.POST )
	@ResponseBody
	public String save(@RequestBody Student empp,BindingResult br)
	{
		System.out.println("save method"+empp);
	       String s=ser.saveStu(empp);
	       System.out.println("controller "+s);
		return s;
	}
	@RequestMapping(path="/delete/{id}",method =RequestMethod.DELETE )
	@ResponseBody
	public String delete(@PathVariable("id") int id)
	{
		System.out.println("StudentController.delete()");
	       String s=ser.deleteStu(id);
		return s;
	}
	@RequestMapping(path="/retrive/{id}",method =RequestMethod.GET)
	@ResponseBody
	public Student getStudent(@PathVariable("id") int id)
	{
		System.out.println("StudentController.getStudent()");
	       Student stu=ser.getStudent(id);
		return stu;
	}
	@RequestMapping(path="/retriveAll",method =RequestMethod.GET)
	@ResponseBody
	public List<Student> getStudent()
	{
		System.out.println("StudentController.getStudent()");
	       List<Student> stu=ser.getAllStudent();
		return stu;
	}
	@RequestMapping(path="/update",method =RequestMethod.POST )
	@ResponseBody
	public String update(@RequestBody Student stu)
	{
		int id = 0;
		String res=null;
		if(id!=0)
		{
			res =ser.updateStudent(stu);
		}
		else
		{
			return "for updation id is compulsory";
		}
	       
		return res;
	}
	@ExceptionHandler(Exception.class)
	  @ResponseBody
	  public String handleMyException(Exception  exception) {
		System.out.println("EmployeeController.handleMyException()");
	      return exception.getMessage();
	  } 
    
}
