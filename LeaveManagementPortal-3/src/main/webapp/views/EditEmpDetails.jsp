<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!-- tag library to use the jstl tag -->
    <!-- Add external jar file for jstl 1.2 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--linking bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />

    <title>HR | Edit Details</title>

    <!--Css Linking-->
    <!--linking the css file-->
    <link rel="stylesheet" href="/css/dashboard.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

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
                    <p class="text-center text-dark" style="font-size: 30px;">Edit Employee Details</p>
                    <br>
                    <hr>
                    <form action="/lms/hr/UpdateDetails" method="post" onsubmit="return validate()">
                        <div>
                            <br>
                            <p class="text-center text-dark" style="font-size: 20px;">Personal Details</p>
                            <!--first row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeId"
                                            placeholder="Employee Id" name="empId" value="<c:out value='${NewDetails.empId}'/>" readonly>
                                        <label for="EmployeeId">Employee Id</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmpFirstName"
                                            placeholder="First Name" name="empFirstName" value="<c:out value='${NewDetails.empFirstName}'/>" required>
                                        <label for="EmpFirstName">First Name</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmpLastName"
                                            placeholder="Last Name" name="empLastName" value="<c:out value='${NewDetails.empLastName}'/>" required>
                                        <label for="EmpLastName">Last Name</label>
                                    </div>
                                </div>

                            </div>
                            <!--Second row-->
                            <div class="row">
                                <div class="col">

                                    <div style="display: flex; flex-direction: row; column-gap: 20px;">
                                        <div>
                                            <lable>Select Gender</lable>
                                        </div>
                                        <div class="form-check mb-0">
                                            <input class="form-check-input me-2" type="radio" name="gender" value="Male"
                                                id="male" value="<c:out value='${NewDetails.gender}'/>" required/>
                                            <label class="form-check-label" for="male">
                                                Male
                                            </label>
                                        </div>
                                        <div class="form-check mb-0">
                                            <input class="form-check-input me-2" type="radio" name="gender"
                                                value="Female" id="female" />
                                            <label class="form-check-label" for="female">
                                                Female
                                            </label>
                                        </div>
                                        <div class="form-check mb-0">
                                            <input class="form-check-input me-2" type="radio" name="gender"
                                                value="Other" id="Other" />
                                            <label class="form-check-label" for="Other">
                                                Other
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <select class="form-select pb-4" id="selectRole" aria-label="Default select example" value="<c:out value='${NewDetails.empRole}'/>" name="empRole" required>
                                        <option value="">Select Role</option>
                                        <option value="Employee">Employee</option>
                                        <option value="Manager">Manager</option>
                                        <option value="Senior Manager">Senior Manager</option>
                                        <option value="Hr">Hr</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeContact"
                                            placeholder="Contact Number" name="empContact" value="<c:out value='${NewDetails.empContact}'/>"  name="empContact" required>
                                        <label for="floatingInput">Contact Number</label>
                                    </div>
                                    <p class="text-denger text-dark">${contactError}</p>
                                </div>
                            </div>
                            <!--Third row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="email" class="form-control" id="EmployeeEmail"
                                            placeholder="Email address" name="empEmail" value="<c:out value='${NewDetails.empEmail}'/>" required>
                                        <label for="EmployeeEmail">Email address</label>
                                    </div>
                                    <p class="text-denger text-dark">${EmailError}</p>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="EmployeeDOB"
                                            placeholder="EmployeeDOB" min="1972-01-01" max="2004-01-01" name="empDob" value="<c:out value='${NewDetails.empDob}'/>" required>
                                        <label for="EmployeeDOB">DOB (Between 18 to 50 Years)</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="date" class="form-control" id="EmployeeJoiningDate"
                                            placeholder="Joining Date" name="empJoining" value="<c:out value='${NewDetails.empJoining}'/>" required>
                                        <label for="EmployeeJoiningDate">Joining Date</label>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <p class="text-center text-dark" style="font-size: 20px;">Login Details</p>
                            <!--fourth row-->
                            <div class="row">
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" id="EmployeeUsername"
                                            placeholder="Set Username" name="empUsername" value="<c:out value='${NewDetails.empUsername}'/>" required>
                                        <label for="EmployeeUsername">Set Username</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" id="EmployeePassword"
                                            placeholder="Set Password" name="empPassword" value="<c:out value='${NewDetails.empPassword}'/>" required>
                                        <label for="EmployeePassword">Set Password</label>
                                    </div>
                                    <div class="form-check mb-0">
                                        <input class="form-check-input me-2" type="checkbox" id="showPassword" onclick="showpassword()"/>
                                        <label class="form-check-label" for="form2Example3">
                                            Show Password
                                        </label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" id="EmployeeReEnter"
                                            placeholder="Re-enter Password" name="empReEnter" required>
                                        <label for="EmployeeReEnter">Re-enter Password</label>
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
	<script type="text/javascript">
	function validate() {
	    /** Validation for first and last name */
	    var firstname = document.getElementById("EmpFirstName").value;
	    var lastname = document.getElementById("EmpLastName").value;
	    var NameRegExp = /[a-zA-Z]/;
	    var NameRegExpDigits = /\d/;
	    var specialChars = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;

	    if (firstname == " " || lastname == " " || firstname == "  " || lastname == "  ") {
	        window.alert("Invalid Name");
	        return false;
	    }

	    if (!NameRegExp.test(firstname) || NameRegExpDigits.test(firstname) || specialChars.test(firstname)) {
	        window.alert("Please Enter valid First Name");
	        return false;
	    }
	    if (!NameRegExp.test(lastname) || NameRegExpDigits.test(lastname) || specialChars.test(lastname)) {
	        window.alert("Please Enter valid Last Name");
	        return false
	    }
	    /** Validation for Contact Number */
	    var contact = document.getElementById("EmployeeContact").value;
	    var ContactRegExp = /[0-9]/;

	    if (!ContactRegExp.test(contact) || specialChars.test(contact) || contact == " " || contact == "  ") {
	        window.alert("Invalid Contact Number");
	        return false;
	    }
	    if (contact.length != 10) {
	        window.alert("Contact Number Should be of 10 digits.");
	        return false;
	    }

	    /**Validation for Username / email */
	    var email = document.getElementById("EmployeeEmail").value;
	    var emailRegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	    if (!emailRegExp.test(email) || email == " " || email == "  ") {
	        window.alert("Enter a valid email (Example1234@xyz.com)");
	        return false;
	    }

	    /**Validation for Username / email */
	    var username = document.getElementById("EmployeeUsername").value;
	    var emailRegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	    if (!emailRegExp.test(username) || username == " " || username == "  ") {
	        window.alert("Enter a valid Username (Example1234@xyz.com)");
	        return false;
	    }

	    if(email != username){
	        window.alert("Username and Email must be same");
	        return false;
	    }

	    /* validation for select*/
	    var ddlFruits = document.getElementById("selectRole");
        if (ddlFruits.value == "") {
            //If the "Please Select" option is selected display error.
            window.alert("Please select an option from Select Role!");
            return false;
        }

	    /**Validation for Password */
	    var password = document.getElementById("EmployeePassword").value;
	    var passwordRegExp = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;

	    if (!passwordRegExp.test(password) || password == " " || password == "  ") {
	        window.alert("Password must contain 1. atlest one UpperCase 2. atlest one LowerCase 3. atlest one Numeric value 4. atlest one special Character");
	        return false;
	    }
	    if (password.length < 8 || password.length > 14) {
	        window.alert("Password must be of 8 to 14 characters");
	        return false;
	    }

	    /** Validatin reEnter Password */
	    var rePassword = document.getElementById("EmployeeReEnter").value;
	    if (rePassword != password || rePassword.length != password.length) {
	        window.alert("Password does not verified");
	        return false;
	    }

	    
	}

	/** for joining date */
	$(function(){
	    var dtToday = new Date();

	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	        day = '0' + day.toString();

	    var minDate= year + '-' + (month-1) + '-' + day;
	    var maxDate= year + '-' + (month+1) + '-' + day;

	    $('#EmployeeJoiningDate').attr('min', minDate);
	    $('#EmployeeJoiningDate').attr('max', maxDate);
	});

	
	function showpassword() {
		var x = document.getElementById("EmployeePassword");

		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}

	}
	</script>
	
	





    <!-- linking the HrSignUp.js file
    <script type="text/javascript" src="AddEmployee.js"></script>-->
    <!--linking the bootstrap js-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous">
        </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous">
        </script>
</body>

</html>