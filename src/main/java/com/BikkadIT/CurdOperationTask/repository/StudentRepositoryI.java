package com.BikkadIT.CurdOperationTask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.CurdOperationTask.entities.Student;

@Repository
public interface StudentRepositoryI extends JpaRepository<Student, Integer> {

	public Student findById(int rollno);


}
