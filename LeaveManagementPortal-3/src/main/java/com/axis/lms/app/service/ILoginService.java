/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Login Service interface.
 */

package com.axis.lms.app.service;

import com.axis.lms.app.entity.Employee;

import org.springframework.stereotype.Service;

@Service
public interface ILoginService {

	public abstract boolean isValid(String username , String password);
	public abstract Employee findEmployee(String username , String password);
	
}
