/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page : Project Details Properties.
 */

package com.axis.lms.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length = 10 , unique = true)
	private int id;
	@Column(length = 10)
	private int empId;
	@Column(length = 20)
	private String empFirstName;
	@Column(length = 20)
	private String empLastName;
	@Column(length = 100)
	private String empProjects;

	
}
