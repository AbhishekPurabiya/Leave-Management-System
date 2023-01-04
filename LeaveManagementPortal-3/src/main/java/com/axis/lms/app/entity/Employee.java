/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page : Employee  Details Properties.
 */

package com.axis.lms.app.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
public class Employee {
	
	@Id
	private int empId;
	private String empFirstName;
	private String empLastName;
	private String gender;
	private String empRole;
	private String empContact;
	private String empEmail;
	private String empDob;
	private String empJoining;
	private String empUsername;
	private String empPassword;
	private int sickLeave = 15;
	private int casualLeave = 15;
	private int personalLeave = 15;
	private int maternityLeave = 180;
	private int paternityLeave = 30;
	private int marriageLeave = 15;
	private int adoptionLeave = 30;
	
	
	
	
}
