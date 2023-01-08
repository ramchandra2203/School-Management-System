package com.jsp.service;

import java.util.List;

import com.jsp.dao.StaffDao;
import com.jsp.dto.StaffDto;

public class StaffService {
     
	StaffDao staffDao = new StaffDao();
	
	public StaffDto saveStaff(StaffDto staff) {
		return staffDao.saveStaff(staff);
	}
	public StaffDto updateStaff(int id,String name) {
		return staffDao.updateStaffNameById(id, name);
	}
	public StaffDto updateEmail(int id, String email) {
		return staffDao.updateStaffEmailById(id, email);
	}
	public StaffDto updateJob(int id, String job) {
		return staffDao.updateStaffJobById(id, job);
	}
	public StaffDto deleteStaff(int id) {
		return staffDao.deleteStaffById(id);
	}
	public StaffDto getStaff(int id) {
		return staffDao.getStaffById(id);
	}
	public List<StaffDto>getAllStaffs(){
		return staffDao.GetAllStaff();
	}
}
