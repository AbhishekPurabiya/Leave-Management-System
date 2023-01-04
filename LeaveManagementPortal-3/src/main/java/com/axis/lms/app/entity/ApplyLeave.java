/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Leaves Details Properties.
 */


package com.axis.lms.app.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "leaves")
public class ApplyLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(length = 10)
	private int empId;
	@Column(length = 20)
	private String empRole;
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastname;
	@Column(length = 30)
	private String leaveType;
	@Column(length = 20)
	private String startDate;
	@Column(length = 20)
	private String endDate;
	@Column(length = 10)
	private int period;
	@Column(length = 100)
	private String leaveComment;
	@Column(length = 20)
	private String status = "Pending";
	
	
}
