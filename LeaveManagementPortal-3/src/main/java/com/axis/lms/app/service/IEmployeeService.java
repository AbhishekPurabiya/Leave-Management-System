/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Employee Service Interface.
 */

package com.axis.lms.app.service;

import java.util.List;

import com.axis.lms.app.entity.ApplyLeave;
import com.axis.lms.app.entity.Employee;
import com.axis.lms.app.entity.Holiday;
import com.axis.lms.app.entity.Project;

import org.springframework.stereotype.Service;

@Service
public interface IEmployeeService {

	public abstract Employee addEmployee(Employee employee);
	public abstract void deleteEmployee(int empId);
	public abstract Employee getMyDetails(int empId);
	public abstract Employee updateMyDetails(Employee employee);
	
	public abstract ApplyLeave addLeaves(ApplyLeave leave);
	public abstract List<ApplyLeave> getMyLeaveRequest(int empid);
	
	public abstract List<Project> getProject(int empId);
	public abstract List<Holiday> getAllHoliday();
	
	public abstract int getBalancedSickLeave(int empId);
	public abstract int getBalancedCasualLeave(int empId);
	public abstract int getBalancedPersonalLeave(int empId);
	public abstract int getBalancedMarriageLeave(int empId);
	public abstract int getBalancedMaternityLeave(int empId);
	public abstract int getBalancedPaternityLeave(int empId);
	public abstract int getBalancedAdoptionLeave(int empId);
}
