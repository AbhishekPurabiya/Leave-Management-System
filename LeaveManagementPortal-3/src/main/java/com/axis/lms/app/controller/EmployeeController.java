/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page : Employee Controller
 */

package com.axis.lms.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.axis.lms.app.entity.ApplyLeave;
import com.axis.lms.app.entity.Employee;
import com.axis.lms.app.entity.Holiday;
import com.axis.lms.app.entity.Project;
import com.axis.lms.app.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lms/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService empService;

	//for dashboard
	@RequestMapping("/dashboard")
	public ModelAndView getDashboard() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeeDashboard");
		return mv ;
	}
	
	// for applyLeaveform
	@RequestMapping("/ApplyLeaveForm")
	public ModelAndView getForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeeApplyLeave");
		return mv;
	}

	// for apply leave
	@RequestMapping("/empApplyLeave")
	public ModelAndView leave(ApplyLeave empLeave , HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String leaveType = request.getParameter("leaveType");
		int period = Integer.parseInt( request.getParameter("period"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		if(leaveType.equalsIgnoreCase("sickLeave")) {
			int balanceLeave =  empService.getBalancedSickLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+" leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("employeeApplyLeave");
				return mv ;
				
			}
		}else if(leaveType.equalsIgnoreCase("casualLeave")) {
			int balanceLeave =  empService.getBalancedCasualLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("employeeApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("personalLeave")) {
			int balanceLeave =  empService.getBalancedPersonalLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("employeeApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("maternityLeave")) {
			int balanceLeave =  empService.getBalancedMaternityLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("employeeApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("paternityLeave")) {
			int balanceLeave =  empService.getBalancedPaternityLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("employeeApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("marriageLeave")) {
			int balanceLeave =  empService.getBalancedMarriageLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("employeeApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("adoptionLeave")) {
			int balanceLeave =  empService.getBalancedAdoptionLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("employeeApplyLeave");
				return mv ;
			}
		}
		
		empService.addLeaves(empLeave);
		return new ModelAndView("redirect:/lms/employee/empLeaveList");
	}

	// for showing the hr Leave status
	@RequestMapping("/empLeaveList")
	public ModelAndView showStatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		List<ApplyLeave> leaveList = empService.getMyLeaveRequest(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empLeaveList", leaveList);
		mv.setViewName("employeeCheckStatus");
		return mv;
	}

	// for check leave balance
	@RequestMapping("/empCheckLeaveBalance")
	public ModelAndView leaveBalance(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("empId"));
		Employee empList = empService.getMyDetails(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empLeaveList", empList);
		mv.setViewName("employeeCheckLeaveBalance");
		return mv;

	}

	// for showing the profile details
	@RequestMapping("/employeeMyProfile")
	public ModelAndView myProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		Employee empdetails = empService.getMyDetails(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empDetails", empdetails);
		mv.setViewName("employeeMyProfile");
		return mv;

	}

	// for editing the username and password
	@RequestMapping("/employeeEditMyProfile")
	public ModelAndView editProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		Employee empdetails = empService.getMyDetails(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empDetails", empdetails);
		mv.setViewName("employeeEditMyProfile");
		return mv;
	}

	// for updating the username and pssword
	@RequestMapping("/employeeUpdateProfile")
	public ModelAndView update(Employee employee) {
		empService.deleteEmployee(employee.getEmpId());
		empService.addEmployee(employee);
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/lms/employee/employeeMyProfile");
	}

	// for showing the Project details assigned
	@RequestMapping("/employeeShowProject")
	public ModelAndView showProject(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		List<Project> project = empService.getProject(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("projectDetails", project);
		mv.setViewName("employeeShowProject");
		return mv;
	}

	// for showing the holiday list
	@RequestMapping("/employeeShowHoliday")
	public ModelAndView showHoliday(HttpServletRequest request) {
		List<Holiday> project = empService.getAllHoliday();
		ModelAndView mv = new ModelAndView();
		mv.addObject("holidayList", project);
		mv.setViewName("employeeShowHoliday");
		return mv;
	}
}
