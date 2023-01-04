/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page : Manager Controller
 */

package com.axis.lms.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.axis.lms.app.entity.ApplyLeave;
import com.axis.lms.app.entity.Employee;
import com.axis.lms.app.entity.Holiday;
import com.axis.lms.app.entity.Project;
import com.axis.lms.app.service.IManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lms/manager")
public class ManagerController {

	@Autowired
	IManagerService managerService;
	
	@RequestMapping("/dashboard")
	public ModelAndView getDashboard() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("managerApplyLeave");
		return mv;
	}
	
	@RequestMapping("/ApplyLeaveForm")
	public ModelAndView getLeaveForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("managerApplyLeave");
		return mv;
	}

	// for apply leave
	@RequestMapping("/managerApplyLeave")
	public ModelAndView leave(ApplyLeave leave , HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String leaveType = request.getParameter("leaveType");
		int period = Integer.parseInt( request.getParameter("period"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		if(leaveType.equalsIgnoreCase("sickLeave")) {
			int balanceLeave =  managerService.getBalancedSickLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+" leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("managerApplyLeave");
				return mv ;
				
			}
		}else if(leaveType.equalsIgnoreCase("casualLeave")) {
			int balanceLeave =  managerService.getBalancedCasualLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("managerApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("personalLeave")) {
			int balanceLeave =  managerService.getBalancedPersonalLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("managerApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("maternityLeave")) {
			int balanceLeave =  managerService.getBalancedMaternityLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("managerApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("paternityLeave")) {
			int balanceLeave =  managerService.getBalancedPaternityLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("managerApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("marriageLeave")) {
			int balanceLeave =  managerService.getBalancedMarriageLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("managerApplyLeave");
				return mv ;
			}
		}else if(leaveType.equalsIgnoreCase("adoptionLeave")) {
			int balanceLeave =  managerService.getBalancedAdoptionLeave(empId);
			if(balanceLeave < period) {
				mv.addObject("periodError", "your "+leaveType+"  leave balance is "+balanceLeave+ "Can't apply more than Balanced leave..");
				mv.setViewName("managerApplyLeave");
				return mv ;
			}
		}
		
		managerService.addLeaves(leave);
		
		return new ModelAndView("redirect:/lms/manager/managerLeaveList");
	}

	// for showing the hr Leave status
	@RequestMapping("/managerLeaveList")
	public ModelAndView showStatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		List<ApplyLeave> leaveList = managerService.getMyAllLeaves(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("managerLeaveList", leaveList);
		mv.setViewName("managerCheckStatus");
		return mv;
	}

	// for check leave balance
	@RequestMapping("/managerCheckLeaveBalance")
	public ModelAndView leaveBalance(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		Employee empList = managerService.getMyDetails(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empLeaveList", empList);
		mv.setViewName("managerCheckLeaveBalance");
		return mv;

	}

	// for showing the all leave request
	@RequestMapping("/managerManageLeaves")
	public ModelAndView showLeaves() {
		ModelAndView mv = new ModelAndView();
		List<ApplyLeave> leavesList = managerService.getAllEmployeeLeaves();
		mv.addObject("empLeavesList", leavesList);
		mv.setViewName("managerManageLeave");
		return mv;

	}

	// for approval
	@RequestMapping("/managereditAction")
	public ModelAndView approveLeave(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ApplyLeave applyLeave = managerService.getLeaveRequestDetails(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmpApplyLeave", applyLeave);
		mv.setViewName("managerLeaveAction");
		return mv;

	}

	// updating the status
	@RequestMapping("/managerUpdateStatus")
	public ModelAndView update(ApplyLeave leave , HttpServletRequest request) {
		
		String leaveType = request.getParameter("leaveType");
		int period = Integer.parseInt(request.getParameter("period"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		String status = request.getParameter("status");
		
		if(status.equalsIgnoreCase("Approved")) {
			try {
			managerService.subtractLeave(leaveType, period, empId);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		int id = Integer.parseInt( request.getParameter("id"));
		managerService.deleteLeaves(id);
		managerService.addLeaves(leave);
		return new ModelAndView("redirect:/lms/manager/managerManageLeaves");
	}

	@RequestMapping("/managerMyProfile")
	public ModelAndView myProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		Employee empdetails = managerService.getMyDetails(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empDetails", empdetails);
		mv.setViewName("managerMyProfile");
		return mv;

	}

	// for editing the username and password
	@RequestMapping("/managerEditMyProfile")
	public ModelAndView editProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		Employee empdetails = managerService.getMyDetails(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empDetails", empdetails);
		mv.setViewName("managerEditMyProfile");
		return mv;

	}

	// for updating the username and pssword
	@RequestMapping("/managerUpdateProfile")
	public ModelAndView update(Employee employee) {
		managerService.deleteEmployee(employee.getEmpId());
		managerService.addEmployee(employee);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("managerDashboard");
		return mv;
	}

	// for showing the project details assigned
	@RequestMapping("/managerShowProject")
	public ModelAndView showProject(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		List<Project> project = managerService.getProject(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("projectDetails", project);
		mv.setViewName("managerShowProject");
		return mv;
	}

	// for showing the holiday list
	@RequestMapping("/managerShowHoliday")
	public ModelAndView showHoliday(HttpServletRequest request) {
		List<Holiday> project = managerService.getAllHoliday();
		ModelAndView mv = new ModelAndView();
		mv.addObject("holidayList", project);
		mv.setViewName("managerShowHoliday");
		return mv;
	}

}
