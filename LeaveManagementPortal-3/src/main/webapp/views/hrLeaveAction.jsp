<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- tag library to use the jstl tag -->
    <!-- Add external jar file for jstl 1.2 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--Linking the bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!--linking the css file-->
    <link rel="stylesheet" href="/css/dashboard.css">

    <title>Admin | Leaves</title>
</head>

<body class="dashboard dashboard_2">
    <div class="full_container">
        <div class="inner_container">
            <%@ include file="/views/dashboard.jsp" %>
            <!-- end sidebar -->
            <!-- right content -->
            <div id="content">
                <!-- dashboard inner -->
				<div>
                    <p class="text-center text-dark" style="font-size: 30px;">Approve/Reject Leaves</p>
                    <br>
                    <hr>
                    <form action="/lms/hr/UpdateStatus" method="post">
                        <div>
                            <br>
                            <!--first row-->
                            <div class="row">
                            	
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeId"
                                            placeholder="Employee Id" name="empId" value="<c:out value='${EmpApplyLeave.empId}'/>">
                                        <label for="EmployeeId">Employee Id</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeId"
                                            placeholder="Employee Id" name="empRole" value="<c:out value='${EmpApplyLeave.empRole}'/>" readonly>
                                        <label for="EmployeeId">Employee Role</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmpFirstName"
                                            placeholder="First Name" name="firstName" value="<c:out value='${EmpApplyLeave.firstName}'/>">
                                        <label for="EmpFirstName">First Name</label>
                                    </div>
                                </div>
                                

                            </div>
                            <!--Second row-->
                            <div class="row">
                            	<div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="floatingInput"
                                            placeholder="Last Name" name="lastname" value="<c:out value='${EmpApplyLeave.lastname}'/>">
                                        <label for="floatingInput">Last Name</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="floatingInput"
                                            placeholder="Leave Type" name="leaveType" value="<c:out value='${EmpApplyLeave.leaveType}'/>">
                                        <label for="floatingInput">Leave Type</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="startDate" placeholder="Start Date"
                                             name="startDate" onchange="cal()" value="<c:out value='${EmpApplyLeave.startDate}'/>" required>
                                        <label for="startDate">Start Date</label>
                                    </div>
                                </div>
                                
                            </div>
                            <!--Third row-->
                            <div class="row">
                            	<div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="endDate" placeholder="End Date"
                                            name="endDate" onchange="cal()" value="<c:out value='${EmpApplyLeave.endDate}'/>" required>
                                        <label for="endDate">End Date</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="number" class="form-control" id="period" placeholder="Leave Period"
                                            name="period" value="<c:out value='${EmpApplyLeave.period}'/>" >
                                        <label for="period">Leave Period</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeId"
                                            placeholder="Employee Id" name="id" value="<c:out value='${EmpApplyLeave.id}'/>" hidden>
                                        
                                    </div>
                                </div>
                                </div>
                                <div class="row">
	                                <div class="col">
	
	                                    <div style="display: flex; flex-direction: row; column-gap: 20px;">
	                                        <div>
	                                            <lable>Action</lable>
	                                        </div>
	                                        <div class="form-check mb-0">
	                                            <input class="form-check-input me-2" type="radio" name="status" value="Approved"
	                                                id="approve" required/>
	                                            <label class="form-check-label" for="approve">
	                                                <b class="text-success">Approve</b>
	                                            </label>
	                                        </div>
	                                        <div class="form-check mb-0">
	                                            <input class="form-check-input me-2" type="radio" name="status"
	                                                value="Rejected" id="reject" />
	                                            <label class="form-check-label" for="reject">
	                                               <b class="text-danger">Reject</b>
	                                            </label>
	                                        </div>
	                                      
	                                    </div>
	                                </div>
                            </div>
                        </div>

                        <br>
                        <button class="btn btn-primary" type="submit"
                            style="padding-left: 2.5cm;  padding-right: 2.5cm;">Submit
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<%@ include file="/views/Footer.jsp" %>

    <!--linking the bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>

</html>