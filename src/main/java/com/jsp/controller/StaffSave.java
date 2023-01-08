package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.StaffDto;
import com.jsp.service.StaffService;
@WebServlet("/savestaff")
public class StaffSave extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String job=req.getParameter("job");
		StaffDto staff =new StaffDto();
		
		staff.setName(name);
		staff.setEmail(email);
		staff.setJob(job);
		
		StaffService staffService=new StaffService();
		StaffDto s=staffService.saveStaff(staff);
		if(s != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("SaveMessage.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
 
}
