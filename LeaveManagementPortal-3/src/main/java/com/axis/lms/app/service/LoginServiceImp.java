/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Login Service Implementation.
 */

package com.axis.lms.app.service;

import com.axis.lms.app.entity.Employee;
import com.axis.lms.app.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements ILoginService {

	@Autowired
	EmployeeRepository empRepo ;
	
	@Override
	public boolean isValid(String username, String password) {
		Employee employee = empRepo.checkCredential(username, password);
		if(employee == null) {
			return false ;
		}
		return true ;
	}

	@Override
	public Employee findEmployee(String username, String password) { 
		return empRepo.checkCredential(username, password);
	}

	
}
