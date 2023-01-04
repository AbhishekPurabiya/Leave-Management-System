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
                
                <p class="text-center text-dark" style="font-size: 30px;">Add Holiday Details</p>
                    <br>
                    <hr>
                    
					<form action="/lms/hr/addHoliday" method="post">
					<div class="row">
						<div class="col">
							<div class="form-floating mb-3">
				                <input type="date" class="form-control"  name="hdate" required>
				                <label for="floatingInput">Date</label>
				              </div>
						</div>
						<div class="col">
							<div class="form-floating">
				                <input type="text" class="form-control" id="floatingPassword" placeholder="Holiday Name" name="holidayName" required>
				                <label for="floatingPassword">Holiday Name</label>
				              </div>
						</div>
					</div>
					
		              <br><br>
						<button type="Submit" class="btn btn-primary" style="padding-left: 2.5cm; padding-right: 2.5cm;">Submit</button>
	            </form>
            </div>
        </div>
    </div>
    <%@ include file="/views/Footer.jsp" %>
    <script>
    /* validation for select*/
    var ddlFruits = document.getElementById("selectMonth");
    if (ddlFruits.value == "") {
        //If the "Please Select" option is selected display error.
        window.alert("Please select an option from Select Month!");
        return false;
    }
    </script>


    <!--linking the bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>

</html>