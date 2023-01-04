/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page : All Holiday Details Properties
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
public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	@Column(length = 14)
	private String hdate ;
	@Column(length = 50)
	private String holidayName;
}
