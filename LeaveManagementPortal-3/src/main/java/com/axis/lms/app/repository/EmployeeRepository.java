/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Employee Details Repository.
 */

package com.axis.lms.app.repository;

import java.util.List;

import com.axis.lms.app.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository(value = "EmployeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(value = "select * from EMPLOYEE where  EMP_EMAIL= :username AND EMP_PASSWORD= :password" , nativeQuery = true)
	public Employee checkCredential(@Param("username") String username ,@Param("password") String password);
	
	@Query(value = "select EMP_ID from Employee where EMP_ID=(select max(EMP_ID) from Employee)" , nativeQuery = true)
	public int findMaxValue();
	
	@Query(value = "select EMP_CONTACT from Employee" , nativeQuery = true)
	List<String> findAllContact();
	
	@Query(value = "select EMP_EMAIL from Employee" , nativeQuery = true)
	List<String> findAllEmail();
	
	// for checkig the balanced leave
	
	@Query(value  = "select SICK_LEAVE from Employee where EMP_ID= :empId" , nativeQuery = true)
	public int findBalancedSickLeave(@Param("empId") int empid);
	
	@Query(value  = "select CASUAL_LEAVE from Employee where EMP_ID= :empId"  , nativeQuery = true)
	public int findBalancedCasualLeave(@Param("empId") int empid);
	
	@Query(value  = "select PERSONAL_LEAVE from Employee where EMP_ID= :empId"  , nativeQuery = true)
	public int findBalancedPersonalLeave(@Param("empId") int empid);
	
	@Query(value  = "select MATERNITY_LEAVE from Employee where EMP_ID= :empId"  , nativeQuery = true)
	public int findBalancedMaternityLeave(@Param("empId") int empid);
	
	@Query(value  = "select PATERNITY_LEAVE from Employee where EMP_ID= :empId"  , nativeQuery = true)
	public int findBalancedPaternityLeave(@Param("empId") int empid);
	
	@Query(value  = "select MARRIAGE_LEAVE from Employee where EMP_ID= :empId"  , nativeQuery = true)
	public int findBalancedMarriageLeave(@Param("empId") int empid);
	
	@Query(value  = "select ADOPTION_LEAVE from Employee where EMP_ID= :empId"  , nativeQuery = true)
	public int findBalancedAdoptionLeave(@Param("empId") int empid);
	
	
	// for updating the leave balance
	
	@Query(value = "UPDATE Employee SET  SICK_LEAVE= SICK_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	public boolean updateSickLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE Employee SET  CASUAL_LEAVE= CASUAL_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	public boolean updateCasualLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE Employee SET  PERSONAL_LEAVE= PERSONAL_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	public boolean updatePersonalLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE Employee SET  MATERNITY_LEAVE= MATERNITY_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	public boolean updateMaternityLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE Employee SET  PATERNITY_LEAVE= PATERNITY_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	public boolean updatePaternityLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE Employee SET  MARRIAGE_LEAVE= MARRIAGE_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	public boolean updateMarriageLeave(@Param("period") int period , @Param("empId") int empId);
	
	@Query(value = "UPDATE Employee SET  ADOPTION_LEAVE= ADOPTION_LEAVE- :period where EMP_ID= :empId" , nativeQuery = true)
	public boolean updateAdoptionLeave(@Param("period") int period , @Param("empId") int empId);
}
