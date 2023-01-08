package com.jsp.service;

import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.dto.StudentDto;

public class StudentService {
StudentDao studentDao=new StudentDao();
	
	public StudentDto saveStudent(StudentDto student) {
		return studentDao.saveStudent(student);
	}
	public StudentDto deleteStudentById(int id) {
		return studentDao.deleteStudentById(id);
	}
	public StudentDto updateStudentNameById(int id, String name) {
		return studentDao.updateStudentNameById(id, name);
	}
	public StudentDto updateStudentEmailById(int id, String email) {
		return studentDao.updateStudentEmailById(id, email);
	}
	public StudentDto updateStudentDobById(int id, String dob) {
		return studentDao.updateStudentDobById(id, dob);
	}
	public StudentDto getStudentById(int id) {
		return studentDao.getStudentById(id);
	}
	public List<StudentDto>getAllStudent() {
		return studentDao.getAllStudent();
	}
}

