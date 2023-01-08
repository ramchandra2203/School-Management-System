package com.jsp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.StudentDto;

public class StudentDao {
          
	 EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ram");
	 EntityManager entityManager =entityManagerFactory.createEntityManager();
	 EntityTransaction entityTransaction=entityManager.getTransaction();
	 
	 public StudentDto saveStudent(StudentDto student) {
		 entityTransaction.begin();
		 entityManager.persist(student);
		 entityTransaction.commit();
		 return student;
	 }
	 public StudentDto deleteStudentById(int id) {
		 StudentDto student=entityManager.find(StudentDto.class, id);
		 if(student!=null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			System.out.println("Student deleted");
		 }else {
			 System.out.println("student not found");
		 }
		 return student;
	 }
	 public StudentDto updateStudentNameById(int id, String name) {
		 StudentDto student=entityManager.find(StudentDto.class, id);
		 if(student!=null) {
			 student.setName(name);
			 entityTransaction.begin();
			 entityManager.merge(student);
			 entityTransaction.commit();
			 System.out.println("student Name Updated");
		 }else {
			 System.out.println("student Not Found");
		 }
		 return student;
	 }
	 public StudentDto updateStudentEmailById(int id, String email) {
	 StudentDto student= entityManager.find(StudentDto.class, id);
//	 if(student!=null) {
		 student.setEmail(email);
		 entityTransaction.begin();
		 entityManager.merge(student);
		 entityTransaction.commit();
		 System.out.println("Email id Updated");
//	 }else {
//		 System.out.println("Student not Found");
//	 }
	 return student;
	 }
	 public StudentDto updateStudentDobById(int id, String dob) {
		 StudentDto student=entityManager.find(StudentDto.class, id);
		 if(student!=null) {
			 student.setDob(dob);
			 entityTransaction.begin();
			 entityManager.merge(student);
			 entityTransaction.commit();
			 System.out.println("DOB Updated");
		 }else {
			 System.out.println("Student not Found");
		 }
		 return student;
	 }
	 public StudentDto getStudentById(int id) {
		 StudentDto student=entityManager.find(StudentDto.class,id);
		return student;
		 
	 }
	 public List<StudentDto> getAllStudent() {
		 String sql="select s from StudentDto s";
		 Query query=entityManager.createQuery(sql);
		 List<StudentDto> students =query.getResultList();
		return students;
	 }
	 
}
