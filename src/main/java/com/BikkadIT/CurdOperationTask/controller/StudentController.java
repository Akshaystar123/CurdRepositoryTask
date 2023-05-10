package com.BikkadIT.CurdOperationTask.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.CurdOperationTask.entities.Student;
import com.BikkadIT.CurdOperationTask.service.StudentServiceI;

import jakarta.websocket.server.PathParam;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceI studentServiceI;

//******************************create new record**************************************

	@PostMapping("/student")
	public ResponseEntity<String> createStudent(@RequestBody Student stu) {

		boolean student = studentServiceI.createStudent(stu);

		if(student) {
			String msg="Student save successfully";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}else {
		String msg="Student is not save successfully";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	}

	// ****************************** create multiple records at time**************************************

	@PostMapping("/student/saveAll")
	public ResponseEntity<String> saveAll(@RequestBody List<Student> stu) {

		boolean saveAll = studentServiceI.saveAll(stu);

		if(saveAll) {
			String msg="Student save successfully";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}else {
		String msg="Student is not save successfully";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	}

	// ******************************getAll records**************************************

	@GetMapping("/student")
	public List<Student> getAllStudent() {

		List<Student> findAll = studentServiceI.getAllStudent();

		return findAll;

	}

	// ******************************get Single record using request param**************************************

	@GetMapping("/getstudent")
	public ResponseEntity<Student> findById1(@RequestParam int rollno) {

		Student findById = studentServiceI.findById(rollno);
		return new ResponseEntity<Student>(findById, HttpStatus.OK);
	}

	// ******************************get Single record using path param**************************************

	@GetMapping("/studentPath")
	public ResponseEntity<Student> getStudentById(@PathParam("rollno") int rollno) {

		Student findById = studentServiceI.findById(rollno);
		return new ResponseEntity<Student>(findById, HttpStatus.OK);
	}

	// ******************************get Single record using Request body**************************************

	/*
	 * @GetMapping("/student/{rollno}") public ResponseEntity<Student>
	 * findById(@RequestBody int rollno) {
	 * 
	 * Student findById = studentServiceI.findById(rollno); return new
	 * ResponseEntity<Student>(findById, HttpStatus.OK); }
	 */
	
	  @PostMapping(value = "/getStudentById", consumes = "application/json") 
	  public ResponseEntity<Student> getById(@RequestBody Map<String, Integer>requestBody) {
		  
		  int stuid = requestBody.get("rollno");
		  Student student =  studentServiceI.findById(stuid); 
		  
		  return new ResponseEntity<Student>(student, HttpStatus.OK); }
	 

	// ******************************update single record Record**************************************

	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student stu) {

		Student updateStudent = studentServiceI.updateStudent(stu);
		return new ResponseEntity<Student>(updateStudent, HttpStatus.OK);
	}

	// ******************************update multiple record at time**************************************

	@PostMapping("/student/updateAll")
	public List<Student> updateAll(@RequestBody List<Student> stu) {

		List<Student> saveAll = studentServiceI.saveAll(stu);

		return saveAll;
	}

	// ******************************delete Single record**************************************

	@DeleteMapping("/student/{rollno}")
	public Student deleteStudent(@PathVariable int rollno) {

		Student deleteStudent = studentServiceI.deleteStudent(rollno);
		return deleteStudent;
	}

	// ******************************delete All record**************************************

	@DeleteMapping("/student")
	public Student deleteAll() {

		Student deleteAll = studentServiceI.deleteAll();

		return deleteAll;
	}

	@GetMapping("/students/{rollno}")
	public ResponseEntity<List<Student>> findByAllId(@PathVariable List<Integer> rollno) {

		List<Student> findAllById = studentServiceI.findByAllId(rollno);

		return new ResponseEntity<List<Student>>(findAllById, HttpStatus.OK);
	}

}
