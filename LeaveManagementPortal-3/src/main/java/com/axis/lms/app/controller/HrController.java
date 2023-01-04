/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page : Human Resource Controller
 */
package com.axis.lms.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.axis.lms.app.entity.ApplyLeave;
import com.axis.lms.app.entity.Employee;
import com.axis.lms.app.entity.Holiday;
import com.axis.lms.app.entity.Project;
import com.axis.lms.app.service.IHrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lms/hr")
public class HrController {

	@Autowired
	IHrService hrService;

	// for any request
	@RequestMapping(value =  "/dashboard" , method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		return mv;
	}

	// for Adding the new Employee in the organization(getting empID and show the
	// form)
	@RequestMapping( value =  "/AddEmployeeForm" , method = RequestMethod.GET)
	public ModelAndView getId() {
		int id = hrService.autoId();
		ModelAndView mv = new ModelAndView();
		mv.addObject("newEmpId", id);
		mv.setViewName("AddEmployee");
		return mv;
	}

	// for Adding the new Employee in the organization(saving the details into
	// database)
	@RequestMapping(value =  "/addEmployee" , method = RequestMethod.POST)
	public ModelAndView addEmp(Employee employee, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String contact = request.getParameter("empContact");
		String email = request.getParameter("empEmail");
		boolean isContactExist = hrService.checkContactNumber(contact);
		if (isContactExist == true) {
			int id = hrService.autoId();
			mv.addObject("contactError", "Contact Already Exist..");
			mv.addObject("newEmpId", id);
			mv.setViewName("AddEmployee");
			return mv;
			//return new ModelAndView("redirect:/lms/hr/AddEmployeeForm");
		}
		boolean isEmailExist = hrService.checkEmail(email);
		if (isEmailExist == true) {
			int id = hrService.autoId();
			mv.addObject("EmailError", "Email Already Exist..");
			mv.addObject("newEmpId", id);
			mv.setViewName("AddEmployee");
			return mv;
			//return new ModelAndView("redirect:/lms/hr/AddEmployeeForm");
		}
		
		hrService.addEmployee(employee);

		return new ModelAndView("redirect:/lms/hr/employeeList");
	}

	// getting the list of employee from database
	@RequestMapping(value = "/employeeList" , method = RequestMethod.GET )
	public ModelAndView showEmp() {
		ModelAndView mv = new ModelAndView();
		List<Employee> EmployeeList = hrService.getAllEmployee();
		mv.addObject("EmployeeList", EmployeeList);
		mv.setViewName("manageUsers");
		return mv;
	}

	// for edit the Employee Details
	@RequestMapping(value = "/edit" , method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("empId"));
		Employee newEmployee = hrService.getEmpbyId(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("NewDetails", newEmployee);
		mv.setViewName("EditEmpDetails");
		return mv;

	}

	// for saving the edited details
	@RequestMapping(value =  "/UpdateDetails" , method = RequestMethod.POST)
	public ModelAndView changeDetails(Employee employee, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String contact = request.getParameter("empContact");
		String email = request.getParameter("empEmail");
		int empId = Integer.parseInt(request.getParameter("empId"));
		boolean isContactExist = hrService.checkContactNumber(contact);
		if (isContactExist == true) {
			mv.addObject("contactError", "Contact Already Exist..");
			return new ModelAndView("redirect:/lms/hr/edit?empId=" + empId);
		}
		boolean isEmailExist = hrService.checkEmail(email);
		if (isEmailExist == true) {
			mv.addObject("EmailError", "Email Already Exist..");
			return new ModelAndView("redirect:/lms/hr/edit?empId=" + empId);
		}
		hrService.deleteEmployee(employee.getEmpId());
		hrService.addEmployee(employee);
		return new ModelAndView("redirect:/lms/hr/employeeList");
	}

	// for deleting the Employee details
	@RequestMapping(value = "/delete" , method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("empId"));
		hrService.deleteEmployee(empId);
		return new ModelAndView("redirect:/lms/hr/employeeList");
	}

	// for any request
	@RequestMapping(value = "/ApplyLeaveForm" , method = RequestMethod.GET)
	public ModelAndView applyLeaveForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ApplyLeave");
		return mv;
	}

	// for apply leave
	@RequestMapping(value = "/hrApplyLeave" , method = RequestMethod.POST)
	public ModelAndView leave(ApplyLeave hrLeave, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String leaveType = request.getParameter("leaveType");
		int period = Integer.parseInt(request.getParameter("period"));
		int empId = Integer.parseInt(request.getParameter("empId"));

		if (leaveType.equalsIgnoreCase("sickLeave")) {
			int balanceLeave = hrService.getBalancedSickLeave(empId);
			if (balanceLeave < period) {
				
				mv.addObject("periodError", "your " + leaveType + " leave balance is " + balanceLeave
						+ "Can't apply more than Balanced leave..");
				mv.setViewName("ApplyLeave");
				return mv ;
			}
		} else if (leaveType.equalsIgnoreCase("casualLeave")) {
			int balanceLeave = hrService.getBalancedCasualLeave(empId);
			if (balanceLeave < period) {
				mv.addObject("periodError", "your " + leaveType + "  leave balance is " + balanceLeave
						+ "Can't apply more than Balanced leave..");
				mv.setViewName("ApplyLeave");
				return mv ;
			}
		} else if (leaveType.equalsIgnoreCase("personalLeave")) {
			int balanceLeave = hrService.getBalancedPersonalLeave(empId);
			if (balanceLeave < period) {
				mv.addObject("periodError", "your " + leaveType + "  leave balance is " + balanceLeave
						+ "Can't apply more than Balanced leave..");
				mv.setViewName("ApplyLeave");
				return mv ;
			}
		} else if (leaveType.equalsIgnoreCase("maternityLeave")) {
			int balanceLeave = hrService.getBalancedMaternityLeave(empId);
			if (balanceLeave < period) {
				mv.addObject("periodError", "your " + leaveType + "  leave balance is " + balanceLeave
						+ "Can't apply more than Balanced leave..");
				mv.setViewName("ApplyLeave");
				return mv ;
			}
		} else if (leaveType.equalsIgnoreCase("paternityLeave")) {
			int balanceLeave = hrService.getBalancedPaternityLeave(empId);
			if (balanceLeave < period) {
				mv.addObject("periodError", "your " + leaveType + "  leave balance is " + balanceLeave
						+ "Can't apply more than Balanced leave..");
				mv.setViewName("ApplyLeave");
				return mv ;
			}
		} else if (leaveType.equalsIgnoreCase("marriageLeave")) {
			int balanceLeave = hrService.getBalancedMarriageLeave(empId);
			if (balanceLeave < period) {
				mv.addObject("periodError", "your " + leaveType + "  leave balance is " + balanceLeave
						+ "Can't apply more than Balanced leave..");
				mv.setViewName("ApplyLeave");
				return mv ;
			}
		} else if (leaveType.equalsIgnoreCase("adoptionLeave")) {
			int balanceLeave = hrService.getBalancedAdoptionLeave(empId);
			if (balanceLeave < period) {
				mv.addObject("periodError", "your " + leaveType + "  leave balance is " + balanceLeave
						+ "Can't apply more than Balanced leave..");
				mv.setViewName("ApplyLeave");
				return mv ;
			}
		}
		hrService.addHrLeave(hrLeave);
		return new ModelAndView("redirect:/lms/hr/hrLeaveList");
	}

	// for showing the hr Leave status
	@RequestMapping(value = "/hrLeaveList" , method = RequestMethod.GET)
	public ModelAndView showStatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("empId");
		List<ApplyLeave> leaveList = hrService.getMyLeaveRequest(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("hrLeaveList", leaveList);
		mv.setViewName("HrCheckStatus");
		return mv;
	}

	// for showing the all leave request
	@RequestMapping(value = "/ManageEmployeeLeaves" , method = RequestMethod.GET)
	public ModelAndView showLeaves() {
		ModelAndView mv = new ModelAndView();
		List<ApplyLeave> leavesList = hrService.getAllEmployeeLeaves();
		mv.addObject("empLeavesList", leavesList);
		mv.setViewName("hrManageLeave");
		return mv;

	}

	// for approval
	@RequestMapping(value = "/editAction" , method = RequestMethod.GET)
	public ModelAndView approveLeave(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ApplyLeave applyLeave = hrService.getLeaveRequestDetails(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmpApplyLeave", applyLeave);
		mv.setViewName("hrLeaveAction");
		return mv;

	}

//
	// updating the status
	@RequestMapping(value = "/UpdateStatus" , method = RequestMethod.POST)
	public ModelAndView update(ApplyLeave leave, HttpServletRequest request) {
		

		String leaveType = request.getParameter("leaveType");
		int period = Integer.parseInt(request.getParameter("period"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		String status = request.getParameter("status");
		if (status.equalsIgnoreCase("approved")) {
			try {
				hrService.subtractLeave(leaveType, period, empId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int id = Integer.parseInt(request.getParameter("id"));
		hrService.deleteLeave(id);
		hrService.addHrLeave(leave);
		return new ModelAndView("redirect:/lms/hr/ManageEmployeeLeaves");
	}

//
	// for managing the leave request of manager
	@RequestMapping(value = "/ManageManagerLeaves" , method = RequestMethod.GET)
	public ModelAndView showSeniorManagerLeaves() {
		ModelAndView mv = new ModelAndView();
		List<ApplyLeave> ManagerLeaveDetails = hrService.getAllManagerLeaves();
		mv.addObject("ManagerLeaveDetails", ManagerLeaveDetails);
		mv.setViewName("hrManageLeave(Manager)");
		return mv;
	}

//
	// for approving the leave request of senior manager
	@RequestMapping(value = "/editActionManager" , method = RequestMethod.GET)
	public ModelAndView approve(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		ApplyLeave applyLeave = hrService.getLeaveRequestDetails(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("EmpApplyLeave", applyLeave);
		mv.setViewName("hrLeaveAction(Manager)");
		return mv;

	}

//
	// updating the status
	@RequestMapping(value = "/UpdateStatusManager" , method = RequestMethod.POST)
	public ModelAndView updateLeave(ApplyLeave leave, HttpServletRequest request) {
		

		String leaveType = request.getParameter("leaveType");
		int period = Integer.parseInt(request.getParameter("period"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		String status = request.getParameter("status");

		

		if (status.equalsIgnoreCase("approved")) {
			try {
				hrService.subtractLeave(leaveType, period, empId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int id = Integer.parseInt(request.getParameter("id"));
		hrService.deleteLeave(id);
		hrService.addHrLeave(leave);
		return new ModelAndView("redirect:/lms/hr/ManageManagerLeaves");
	}

	// for check leave balance
	@RequestMapping(value = "/CheckLeaveBalance" , method = RequestMethod.GET)
	public ModelAndView leaveBalance(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		Employee empList = hrService.getEmpbyId(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empLeaveList", empList);
		mv.setViewName("hrCheckLeaveBalance");
		return mv;

	}

	// to show my profile details
	@RequestMapping(value = "/hrMyProfile" , method = RequestMethod.GET)
	public ModelAndView myProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int empId = (int) session.getAttribute("empId");
		Employee empdetails = hrService.getEmpbyId(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empDetails", empdetails);
		mv.setViewName("hrMyProfile");
		return mv;

	}

	// for editing the username and password
	@RequestMapping(value = "/hrEditMyProfile" , method = RequestMethod.GET)
	public ModelAndView editProfile(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("empId"));
		Employee empdetails = hrService.getEmpbyId(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empDetails", empdetails);
		mv.setViewName("hrEditMyProfile");
		return mv;

	}

	// for updating the username and pssword
	@RequestMapping(value = "/hrUpdateProfile" , method = RequestMethod.POST)
	public ModelAndView update(Employee employee , HttpServletRequest request) {
		hrService.deleteEmployee(employee.getEmpId());
		hrService.addEmployee(employee);
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/lms/hr/hrMyProfile");
	}

	// for adding the project details
	@RequestMapping(value = "/addProject" , method = RequestMethod.GET)
	public ModelAndView addProject(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("empId"));
		Employee empdetails = hrService.getEmpbyId(empId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("empDetails", empdetails);
		mv.setViewName("hrAddProject");
		return mv;

	}

	// for submitting the project details
	@RequestMapping(value = "/saveProject" , method = RequestMethod.POST)
	public ModelAndView Project(Project project) {
		hrService.addProject(project);
		return new ModelAndView("redirect:/lms/hr/showProjectList");
	}

	// for showing the project Details
	@RequestMapping(value = "/showProjectList" , method = RequestMethod.GET)
	public ModelAndView showProject() {
		List<Project> projectDetails = hrService.getAllProject();
		ModelAndView mv = new ModelAndView();
		mv.addObject("projectDetails", projectDetails);
		mv.setViewName("projectDetails");
		return mv;
	}

	@RequestMapping(value = "/editProject" , method = RequestMethod.GET)
	public ModelAndView editProjectDetails(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Project project = hrService.getProjectById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("ProjectDetails", project);
		mv.setViewName("hrEditProject");
		return mv;
	}

	@RequestMapping(value = "/updateProject" , method = RequestMethod.POST)
	public ModelAndView updateProject(Project project) {
		hrService.deleteProject(project.getId());
		hrService.addProject(project);
		return new ModelAndView("redirect:/lms/hr/showProjectList");
	}

	// for deleting the project details
	@RequestMapping(value = "/deleteProject" , method = RequestMethod.GET)
	public ModelAndView deleteProject(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		hrService.deleteProject(id);
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/lms/hr/showProjectList");
	}

	@RequestMapping(value = "/addHolidayForm" , method = RequestMethod.GET)
	public ModelAndView addHolidayForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddHoliday");
		return mv;
	}

	// for uploading the Holiday details
	@RequestMapping(value = "/addHoliday" , method = RequestMethod.POST)
	public ModelAndView add(Holiday holiday , HttpServletRequest request) {
		hrService.addHoliday(holiday);
		return new ModelAndView("redirect:/lms/hr/hrShowHoliday");
	}

	// for showing the Holiday list
	@RequestMapping(value = "/hrShowHoliday" , method = RequestMethod.GET)
	public ModelAndView show() {
		List<Holiday> holiday = hrService.getAllHoliday();
		ModelAndView mv = new ModelAndView();
		mv.addObject("holidayList", holiday);
		mv.setViewName("hrShowHoliday");
		return mv;
	}

	// for deleting the holiday details
	@RequestMapping(value = "/deleteHoliday" , method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		hrService.deleteHoliday(id);
		ModelAndView mv = new ModelAndView();
		return new ModelAndView("redirect:/lms/hr/hrShowHoliday");
	}

}
