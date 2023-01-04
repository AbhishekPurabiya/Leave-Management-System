/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Hr Service Interface.
 */

package com.axis.lms.app.service;

import java.util.List;

import com.axis.lms.app.entity.ApplyLeave;
import com.axis.lms.app.entity.Employee;
import com.axis.lms.app.entity.Holiday;
import com.axis.lms.app.entity.Project;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface IHrService {

	public abstract Employee addEmployee(Employee employee);
	public abstract Employee updateEmployee(Employee employee);
	public abstract void deleteEmployee(int empId);
	public abstract Employee getEmpbyId(int empId);
	public abstract List<Employee> getAllEmployee();
	
	public abstract ApplyLeave addHrLeave(ApplyLeave hrLeave);
	public abstract void deleteLeave(int id);
	public abstract List<ApplyLeave> getAllEmployeeLeaves();
	public abstract List<ApplyLeave> getAllManagerLeaves();
	public abstract List<ApplyLeave> getMyLeaveRequest(int empId);
	public abstract ApplyLeave getLeaveRequestDetails(int id);
	
	public abstract Project addProject(Project project);
	public abstract Project updateProject(Project project);
	public abstract Project getProjectById(int id);
	public abstract void deleteProject(int id);
	public abstract List<Project> getAllProject();
	
	public abstract Holiday addHoliday(Holiday holiday);
	public abstract void deleteHoliday(int id);
	public abstract List<Holiday> getAllHoliday();
	
	public abstract int autoId();
	public abstract boolean subtractLeave(String leaveType, int period, int empId);
	public abstract boolean checkEmail(String email);
	public abstract boolean checkContactNumber(String contact);
	public abstract int getBalancedSickLeave(int empId);
	public abstract int getBalancedCasualLeave(int empId);
	public abstract int getBalancedPersonalLeave(int empId);
	public abstract int getBalancedMarriageLeave(int empId);
	public abstract int getBalancedMaternityLeave(int empId);
	public abstract int getBalancedPaternityLeave(int empId);
	public abstract int getBalancedAdoptionLeave(int empId);
}
