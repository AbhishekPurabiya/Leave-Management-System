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
    <style type="text/css">
    .action-button{
		display : flex ;
		flex-direction: row;
		column-gap: 1cm;
	}
    </style>

    <title>Admin | Dashboard</title>
</head>

<body class="dashboard dashboard_2">
    <div class="full_container">
        <div class="inner_container">
              <%@ include file="/views/dashboard.jsp" %>
            <!-- end sidebar -->
            <!-- right content -->
            <div id="content">
                <!-- dashboard inner -->
				<p class="text-center text-dark" style="font-size: 30px;">Add Project Details</p>
                    <br>
                    <hr>
                   <form action="/lms/hr/saveProject" method="post">
                   		<div class="row">
                   				<div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeId"
                                            placeholder="Employee Id" name="empId" value="<c:out value='${empDetails.empId}'/>" readonly>
                                        <label for="EmployeeId">Employee Id</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmpFirstName"
                                            placeholder="First Name" name="empFirstName" value="<c:out value='${empDetails.empFirstName}'/>" readonly>
                                        <label for="EmpFirstName">First Name</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmpLastName"
                                            placeholder="Last Name" name="empLastName" value="<c:out value='${empDetails.empLastName}'/>" readonly>
                                        <label for="EmpLastName">Last Name</label>
                                    </div>
                                </div>
                                </div>
	                        <div class="row">
	                        	<div class="col">
	                        		<div class="form-floating mb-3">
									  <textarea type="text" class="form-control" id="floatingInput" name="empProjects" placeholder="Project Details" required></textarea>
									  <label for="floatingInput">Project Details</label>
									</div>
	                        	</div>
	                        </div>
	                        <br><br>
		                        <button class="btn btn-primary" type="submit" 
		                            style="padding-left: 2.5cm;  padding-right: 2.5cm;">Submit
		                        </button>
                   		
                   </form>
                   
                   
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