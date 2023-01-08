package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.StaffDto;
import com.jsp.service.StaffService;
@WebServlet("/getstaff")
public class StaffGet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		StaffService staffService =new StaffService();
		StaffDto staff= staffService.getStaff(id);
		if(staff!=null) {
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("<html><body><h1>"+"id :"+staff.getId()+"</h1></body></html>");
		printWriter.print("<html><body><h1>"+"Name :"+staff.getName()+"</h1></body></html>");
		printWriter.print("<html><body><h1>"+"Email :"+staff.getEmail()+"</h1></body></html>");
		printWriter.print("<html><body><h1>"+"Job :"+staff.getJob()+"</h1></body></html>");
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/Invalid.jsp");
			rd.forward(req, resp);
		}
	}
}
