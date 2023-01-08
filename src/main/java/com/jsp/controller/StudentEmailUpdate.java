package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.StudentDto;
import com.jsp.service.StudentService;

@WebServlet("/updateStudentEmail")
public class StudentEmailUpdate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");

		StudentService studentService = new StudentService();
		StudentDto studentDto = studentService.getStudentById(id);
		PrintWriter printWriter = resp.getWriter();
		if (studentDto != null) {
			studentService.updateStudentEmailById(id, email);
			printWriter.print("done...");
		} else {
			printWriter.print("student not find");
		}

	}
}
