/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Project Details Properties.
 */

package com.axis.lms.app.repository;

import java.util.List;
import com.axis.lms.app.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ProjectRepository")
public interface ProjectRepository extends JpaRepository<Project, Integer>{

	public List<Project> findByEmpId(int empId);
}
