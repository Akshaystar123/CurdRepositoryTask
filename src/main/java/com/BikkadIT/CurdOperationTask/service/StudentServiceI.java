package com.BikkadIT.CurdOperationTask.service;

import java.util.List;

import com.BikkadIT.CurdOperationTask.entities.Student;

public interface StudentServiceI {

	public boolean createStudent(Student stu);
	
	public boolean saveAll(List<Student> stu);

	public List<Student> getAllStudent();
	
	public Student findById(int rollno);
	
	public List<Student> findByAllId(List<Integer> rollno);

	public boolean updateStudent(Student stu, int rollno);
	
	public List<Student> updateAllStudent(List<Student> stu, List<Integer> rollno);

	public Student deleteStudent(int rollno);

	public Student deleteAll();


		
}
