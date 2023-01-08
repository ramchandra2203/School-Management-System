package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.TeacherService;
@WebServlet("/updateTeacherEmail")
public class TeacherEmailUpdate extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		String email=req.getParameter("email");
		
		TeacherService teacherService=new TeacherService();
		teacherService.updateEmail(id, email);
	}
}
