/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page : Login and Logout Controller
 */

package com.axis.lms.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.axis.lms.app.entity.Employee;
import com.axis.lms.app.service.ILoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lms")
public class LoginController {

	@Autowired
	ILoginService loginService;

	// for any request
	@RequestMapping("/")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}

	// for login
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {

		if (username.isBlank() == false && password.isBlank() == false) {
			boolean isValid = loginService.isValid(username, password);
			if (isValid) {
				Employee employee = loginService.findEmployee(username, password);
				String first = employee.getEmpFirstName();
				String role = employee.getEmpRole();
				int empId = employee.getEmpId();
				String last = employee.getEmpLastName();
				String email = employee.getEmpEmail();
				ModelAndView mv = new ModelAndView();
				HttpSession session = request.getSession();
				session.setAttribute("empFirst", first);
				session.setAttribute("empRole", role);
				session.setAttribute("empLast", last);
				session.setAttribute("empId", empId);
				session.setAttribute("empEmail", email);
				if (role.equalsIgnoreCase("Hr")) {
					return new ModelAndView("redirect:/lms/hr");
				} else if (role.equalsIgnoreCase("Employee")) {
					return new ModelAndView("redirect:/lms/Employee");
				} else if (role.equalsIgnoreCase("Manager")) {
					return new ModelAndView("redirect:/lms/Manager");
				} else if (role.equalsIgnoreCase("Senior Manager")) {
					return new ModelAndView("redirect:/lms/SeniorManager");
				} else {
					return new ModelAndView("redirect:/lms/AccessDenied");
				}
			} else {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("Login");
				mv.addObject("error", "Invalid Username/Password.... ");
				return mv;
			}
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("Login");
			mv.addObject("error", "Invalid Username/Password.... ");
			return mv;
		}
	}

	// redirecting to HR Dashboard
	@RequestMapping("/hr")
	public ModelAndView hrLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard");
		return mv;
	}

	// redirecting to Employee Dashboard
	@RequestMapping("/Employee")
	public ModelAndView empLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeeDashboard");
		return mv;

	}

	// redirecting to Manager Dashboard
	@RequestMapping("/Manager")
	public ModelAndView mnLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("managerDashboard");
		return mv;

	}

	// redirecting to Senior Manager Dashboard
	@RequestMapping("/SeniorManager")
	public ModelAndView sMnLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("seniorManagerDashboard");
		return mv;

	}
	

	// for logout
	@RequestMapping("/Logout")
	public ModelAndView logout(HttpSession session) throws IOException {
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
}
