package com.BikkadIT.CurdOperationTask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.CurdOperationTask.entities.Student;
import com.BikkadIT.CurdOperationTask.repository.StudentRepositoryI;

@Service
public class StudentServiceImpl implements StudentServiceI{

	@Autowired
	private StudentRepositoryI studentRepositoryI;
	
	@Override
	public boolean createStudent(Student stu) {

		Student createStudent = studentRepositoryI.save(stu);
		
		if (createStudent!=null) {
			
			return true;
		}else
			
		return false;
	}

	@Override
	public List<Student> getAllStudent() {

		List<Student> findAll = studentRepositoryI.findAll();
		
		return findAll;
	}

	@Override
	public boolean updateStudent(Student stu, int rollno) {

 Student save = studentRepositoryI.save(stu);
		if (save!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Student deleteStudent(int rollno) {

		studentRepositoryI.deleteById(rollno);
		return null;
	}

	@Override
	public Student deleteAll() {

		studentRepositoryI.deleteAll();
		
		return null;
	}

	@Override
	public Student findById(int rollno) {

		Student findById = studentRepositoryI.findById(rollno);
		return findById;
	}

	@Override
	public List<Student> findByAllId(List<Integer> rollno) {

		List<Student> findAllById = studentRepositoryI.findAllById(rollno);
		return findAllById;
	}

	@Override
	public boolean saveAll(List<Student> stu) {

		List<Student> saveAll = studentRepositoryI.saveAll(stu);
		
      if (saveAll!=null) {
			
			return true;
		}else
			
		return false;
	}

	@Override
public List<Student> updateAllStudent(List<Student> stu, List<Integer> rollno) {

		List<Student> save = studentRepositoryI.saveAll(stu);
		
		return save;
	}

	



		
	/*
	 * @Override public List<Student> saveMultipleStudnets() {
	 * 
	 * List<Student> saveAll = studentRepositoryI.saveAll(null); return saveAll; }
	 */

}

