package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.StaffDto;
import com.jsp.service.StaffService;
@WebServlet("/updatestaff")
public class StaffUpdate extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     int id=Integer.parseInt(req.getParameter("id"));
     String name=req.getParameter("name");
     
     StaffService staffService=new StaffService();
     StaffDto staff=staffService.updateStaff(id, name);
}
}
