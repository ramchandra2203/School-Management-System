package com.jsp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.TeacherDto;

public class TeacherDao {
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ram");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();
        
public TeacherDto saveTeacher(TeacherDto teacher) {
	entityTransaction.begin();
	entityManager.persist(teacher);
	entityTransaction.commit();
	return teacher;
}
public TeacherDto deleteTeacherById(int id) {
	TeacherDto teacher=entityManager.find(TeacherDto.class, id);
	if(teacher!=null) {
		entityTransaction.begin();
		entityManager.remove(teacher);
		entityTransaction.commit();
		System.out.println("Teacher Deleted");
	}else {
		System.out.println("teacher Not Found");
	}
	return teacher;
}
public TeacherDto UpdateTeacherNameById(int id, String name) {
	TeacherDto teacher= entityManager.find(TeacherDto.class, id);
	if(teacher !=null) {
		teacher.setName(name);
		entityTransaction.begin();
		entityManager.merge(teacher);
		entityTransaction.commit();
		System.out.println("Teacher Name Updated");
	}else {
		System.out.println("Teacher Not Found");
	}
	return teacher;
}
public TeacherDto updateTeacherEmailById (int id,String email) {
	TeacherDto teacher =entityManager.find(TeacherDto.class, id);
	if(teacher!=null) {
		teacher.setEmail(email);
		entityTransaction.begin();
		entityManager.merge(teacher);
		entityTransaction.commit();
		System.out.println("Teacher Email Updated");
	}else {
		System.out.println("Teacher Not Found");
	}
	return teacher;
}
public TeacherDto updateTeacherCno(int id, String cno) {
	TeacherDto teacher=entityManager.find(TeacherDto.class,id);
	if(teacher!=null) {
		teacher.setCno(cno);
		entityTransaction.begin();
		entityManager.merge(teacher);
		entityTransaction.commit();
		System.out.println("Contact no Updated");
	}else {
		System.out.println("Teacher Not Found");
	}
	return teacher;
}
public TeacherDto updateTeacherSubject(int id, String subject) {
	TeacherDto teacher=entityManager.find(TeacherDto.class,id);
	if(teacher!=null) {
		teacher.setSubject(subject);
		entityTransaction.begin();
		entityManager.merge(teacher);
		entityTransaction.commit();
		System.out.println("Subject Updated");
	}else {
		System.out.println("Teacher Not Found");
	}
	return teacher;
}
public TeacherDto getTeacherById(int id) {
	TeacherDto teacher =entityManager.find(TeacherDto.class, id);
	return teacher;	
}
public List<TeacherDto> getAllTeachers(){
   String sql="select t from TeacherDto t";
   Query query =entityManager.createQuery(sql);
    
   List<TeacherDto>teachers =query.getResultList();
   return teachers;
}
}
