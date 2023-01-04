/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Manager Service Implementation.
 */

package com.axis.lms.app.service;

import java.util.List;

import com.axis.lms.app.entity.ApplyLeave;
import com.axis.lms.app.entity.Employee;
import com.axis.lms.app.entity.Holiday;
import com.axis.lms.app.entity.Project;
import com.axis.lms.app.repository.ApplyLeaveRepository;
import com.axis.lms.app.repository.EmployeeRepository;
import com.axis.lms.app.repository.HolidayRepository;
import com.axis.lms.app.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImp implements IManagerService {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	ApplyLeaveRepository leaveRepo;

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	HolidayRepository holidayRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		empRepo.deleteById(empId);
	}

	@Override
	public ApplyLeave addLeaves(ApplyLeave leaves) {
		// TODO Auto-generated method stub
		return leaveRepo.save(leaves);
	}

	@Override
	public void deleteLeaves(int id) {
		// TODO Auto-generated method stub
		leaveRepo.deleteById(id);
	}

	@Override
	public List<ApplyLeave> getMyAllLeaves(int empId) {
		// TODO Auto-generated method stub
		return leaveRepo.findByEmpId(empId);
	}

	@Override
	public List<ApplyLeave> getAllEmployeeLeaves() {
		// TODO Auto-generated method stub
		return leaveRepo.findAllEmployeeLeaveRequest();
	}

	@Override
	public Employee getMyDetails(int empId) {
		// TODO Auto-generated method stub
		return empRepo.findById(empId).orElse(null);
	}

	@Override
	public ApplyLeave getLeaveRequestDetails(int id) {
		// TODO Auto-generated method stub
		return leaveRepo.findById(id).orElse(null);
	}

	@Override
	public List<Project> getProject(int empId) {
		// TODO Auto-generated method stub
		return projectRepo.findByEmpId(empId);
	}

	@Override
	public List<Holiday> getAllHoliday() {
		// TODO Auto-generated method stub
		return holidayRepo.findAll();
	}

	@Override
	public boolean subtractLeave(String leaveType, int period, int empId) {

		if (leaveType.equalsIgnoreCase("sickLeave")) {
			empRepo.updateSickLeave(period, empId);
			return true;
		} else if (leaveType.equalsIgnoreCase("casualLeave")) {
			empRepo.updateCasualLeave(period, empId);
			return true;
		} else if (leaveType.equalsIgnoreCase("personalLeave")) {
			empRepo.updatePersonalLeave(period, empId);
			return true;
		} else if (leaveType.equalsIgnoreCase("maternityLeave")) {
			empRepo.updateMaternityLeave(period, empId);
			return true;
		} else if (leaveType.equalsIgnoreCase("paternityLeave")) {
			empRepo.updatePaternityLeave(period, empId);
			return true;
		} else if (leaveType.equalsIgnoreCase("marriageLeave")) {
			empRepo.updateMarriageLeave(period, empId);
			return true;
		} else if (leaveType.equalsIgnoreCase("adoptionLeave")) {
			empRepo.updateAdoptionLeave(period, empId);
			return true;
		} else

			return false;
	}
	
	@Override
	public int getBalancedSickLeave(int empId) {
		// TODO Auto-generated method stub
		return empRepo.findBalancedSickLeave(empId);
	}

	@Override
	public int getBalancedCasualLeave(int empId) {
		// TODO Auto-generated method stub
		return empRepo.findBalancedCasualLeave(empId);
	}

	@Override
	public int getBalancedPersonalLeave(int empId) {
		// TODO Auto-generated method stub
		return empRepo.findBalancedPersonalLeave(empId);
	}

	@Override
	public int getBalancedMarriageLeave(int empId) {
		// TODO Auto-generated method stub
		return empRepo.findBalancedMarriageLeave(empId);
	}

	@Override
	public int getBalancedMaternityLeave(int empId) {
		// TODO Auto-generated method stub
		return empRepo.findBalancedMaternityLeave(empId);
	}

	@Override
	public int getBalancedPaternityLeave(int empId) {
		// TODO Auto-generated method stub
		return empRepo.findBalancedPaternityLeave(empId);
	}

	@Override
	public int getBalancedAdoptionLeave(int empId) {
		// TODO Auto-generated method stub
		return empRepo.findBalancedAdoptionLeave(empId);
	}


}
