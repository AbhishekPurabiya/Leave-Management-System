/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Leaves Repository.
 */

package com.axis.lms.app.repository;

import java.util.List;

import com.axis.lms.app.entity.ApplyLeave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "ApplyLeaveRepository")
public interface ApplyLeaveRepository extends JpaRepository<ApplyLeave, Integer> {
	
	public List<ApplyLeave> findByEmpId(int empId);

	@Query(value = "select * from leaves where EMP_ROLE= 'Hr'" , nativeQuery = true)
	public List<ApplyLeave> findAllHrLeaveRequest();
	
	@Query(value = "select * from leaves where EMP_ROLE= 'Employee'" , nativeQuery = true)
	public List<ApplyLeave> findAllEmployeeLeaveRequest();
	
	@Query(value = "select * from leaves where EMP_ROLE= 'Manager'" , nativeQuery = true)
	public List<ApplyLeave> findAllManagerLeaveRequest();

	
}
