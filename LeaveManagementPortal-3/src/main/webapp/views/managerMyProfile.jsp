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

    <title>Manager | My Profile</title>
</head>

<body class="dashboard dashboard_2">
    <div class="full_container">
        <div class="inner_container">
            <%@ include file="/views/managerDashboard.jsp" %>
            <!-- end sidebar -->
            <!-- right content -->
            <div id="content">
                <!-- dashboard inner -->
                 <div>
                    <p class="text-center text-dark" style="font-size: 30px;">My Profile</p>
                    <br>
                    <hr>
                  
                        <div>
                            <br>
                            <p class="text-center text-dark" style="font-size: 20px;">Personal Details</p>
                            <!--first row-->
                            <div class="row mb-4 mt-5">
                                <div class="col ">
                                    <lable class="text-dark"><strong>Employee Name : </strong> <c:out value='${empDetails.empFirstName}'/> <c:out value='${empDetails.empLastName}'/></lable>
                                </div>
                                <div class="col">
                                    <lable class="text-dark"><strong>Gender : </strong><c:out value='${empDetails.gender}'/></lable>
                                </div>
                                <div class="col">
                                    <lable class="text-dark"><strong>Designation : </strong><c:out value='${empDetails.empRole}'/> </lable>
                                </div>

                            </div>
                            <!--Second row-->
                            <div class="row mb-4 mt-5">
                                <div class="col">

                                    <lable class="text-dark"><strong>Contact No. : </strong><c:out value='${empDetails.empContact}'/></lable>
                                </div>
                                <div class="col">
                                    <lable class="text-dark"><strong>Email Id : </strong><c:out value='${empDetails.empEmail}'/></lable>
                                </div>
                                <div class="col">
                                    <lable class="text-dark"><strong>Date of Birth : </strong><c:out value='${empDetails.empDob}'/></lable>
                                </div>
                            </div>
                            <!--Third row-->
                            <div class="row mb-4 mt-5">
                                <div class="col">
                                    <lable class="text-dark"><strong>Date of Joining : </strong><c:out value='${empDetails.empJoining}'/></lable>
                                </div>
                                <div class="col">
                                    <lable class="text-dark"><strong>Login Username : </strong><c:out value='${empDetails.empUsername}'/></lable>
                                </div>
                                <div class="col">
                                    <lable class="text-dark"><strong>Login Password : </strong><c:out value='${empDetails.empPassword}'/></lable>
                                </div>
                            </div>
                            <div class="row mb-4 mt-5">
                            	<div>
                            		<lable class="text-dark"><strong>Employee Id : </strong><c:out value='${empDetails.empId}'/></lable>
                            	</div>
                            </div>
                            <div class="row mb-4 mt-5">
                            	<div>
                            		<a href="/lms/manager/managerEditMyProfile?email=<c:out value='${empDetails.empEmail}'/>"><button class="btn btn-primary ps-4 pe-4">Edit</button></a>
                            	</div>
                            </div>
                            <br>
                            
                        </div>
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