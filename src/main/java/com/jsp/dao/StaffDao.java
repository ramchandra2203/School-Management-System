package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.StaffDto;


public class StaffDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ram");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction=entityManager.getTransaction();
    
    public StaffDto saveStaff(StaffDto staff) {
    	entityTransaction.begin();
		entityManager.persist(staff);
		entityTransaction.commit();
		return staff;
    }
   
    public StaffDto deleteStaffById(int id) {
    	StaffDto staff=entityManager.find(StaffDto.class, id);
    	if(staff!=null) {
    	entityTransaction.begin();
    	entityManager.remove(staff);
    	entityTransaction.commit();
    	System.out.println(staff.getName()+"Deleted Successfully");
    	}else {
    	       System.out.println("Staff Not Found");
        }
    	return staff;
    }
    public StaffDto updateStaffNameById(int id, String name) {
    	StaffDto staff=entityManager.find(StaffDto.class, id);
    	if(staff!=null) {
    	staff.setName(name);
    	entityTransaction.begin();
    	entityManager.merge(staff);
    	entityTransaction.commit();
    	System.out.println("Staff Updated");
    	}else {
    		System.out.println("staff not found");
    	}
    	return staff;
    }
    public StaffDto updateStaffEmailById(int id, String email) {
    	StaffDto staff= entityManager.find(StaffDto.class, id);
    	if(staff!=null) {
    		staff.setEmail(email);
    		entityTransaction.begin();
    		entityManager.merge(staff);
    		entityTransaction.commit();
    		System.out.println("email Updated");
    		
    	}else {
    		System.out.println("staff Not Found");
    	}
    	return staff;
    }
    public StaffDto updateStaffJobById(int id, String job) {
    	StaffDto staff= entityManager.find(StaffDto.class, id);
    	if(staff!=null) {
    	staff.setJob(job);
    	entityTransaction.begin();
    	entityManager.merge(staff);
    	entityTransaction.commit();
    	System.out.println("JOb Updated");
    	}else {
    		System.out.println("staff Not Found");
    	}
    	return staff;
    }
    public StaffDto getStaffById(int id) {
    	StaffDto staff=entityManager.find(StaffDto.class, id);
    	
    	return staff;	
    }
    public List<StaffDto> GetAllStaff() {
    	
    	String sql = "Select s FROM StaffDto s";
    	Query query=entityManager.createQuery(sql);
 
    	List<StaffDto>staffs=query.getResultList();
		return staffs;
    }
   
	}
