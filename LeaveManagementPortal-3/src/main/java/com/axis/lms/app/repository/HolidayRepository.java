/**
 * Project Name : Leave Management Portal
 * Date of Starting : 02/01/2023
 * Date of Completion : 04/01/2023
 * Author Name : Abhishek Purabiya
 * About this Page :  Holiday Details Properties.
 */

package com.axis.lms.app.repository;

import com.axis.lms.app.entity.Holiday;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value = "HolidayRepository")
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

}
