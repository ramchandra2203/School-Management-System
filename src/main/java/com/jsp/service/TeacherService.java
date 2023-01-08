package com.jsp.service;

import java.util.List;

import com.jsp.dao.TeacherDao;
import com.jsp.dto.TeacherDto;

public class TeacherService {

	TeacherDao teacherDao=new TeacherDao();
	
	public TeacherDto saveTeacher(TeacherDto teacher) {
		return teacherDao.saveTeacher(teacher);
	}
	public TeacherDto deleteTeacher(int id) {
		return teacherDao.deleteTeacherById(id);
	}
	public TeacherDto updateTeacher(int id,String name) {
		return teacherDao.UpdateTeacherNameById(id, name);
	}
	public TeacherDto updateEmail(int id, String email) {
		return teacherDao.updateTeacherEmailById(id, email);
	}
	public TeacherDto updateCno(int id ,String cno) {
		return teacherDao.updateTeacherCno(id, cno);
	}
	public TeacherDto updateSubject(int id, String subject) {
		return teacherDao.updateTeacherSubject(id, subject);
	}
	public TeacherDto getTeacher(int id) {
		return teacherDao.getTeacherById(id);
	}
	public List<TeacherDto> teacher(){
		return teacherDao.getAllTeachers();
	}
}
