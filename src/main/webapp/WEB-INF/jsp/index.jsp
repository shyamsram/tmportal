<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>DELHAIZE</title>
<link href="http://fonts.googleapis.com/css?family=Oxygen:400,700,300" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<script type="text/javascript">
function addNewAssociate() {
    document.getElementById("frmTeamDetails").action="addnewassociate";
}
</script>
<form id="frmTeamDetails" method="post">
<div id="wrapper">
	<div id="logo" class="container">
		<h1><a href="#">Delhaize - Performance and Talent Management Portal</a></h1>
		<br> <br>
		<p>Welcome <b> John Doe </b> (Team Leader - Hannaford Bros)</p>
	</div>
	<div id="menu-wrapper">
		<div id="menu" class="container">
			<ul>
				<li class="current_page_item"><a href="index.html">myTeam</a></li>
				<li><a href="evaluation.html">Evaluation</a></li>
				<li><a href="calibration.html">Calibration</a></li>
				<li><a href="reports.html">Reports</a></li>
				<li><a href="help.html">Help</a></li>
				<li><a href="contactus.html">Contact Us</a></li>
			</ul>
		</div>
	</div>


<div id="page" class="container", align="center">
		<div id="content">
			<div class="post">
				<h2 class="title"><a href="#">My Team : Performance and Talent Management Status</a></h2>
			</div>
			<div style="clear: both;"></div>

		</div>
</div>
<table class="tg", align="center">
  <tr id="homehdr">
    <th><b>Associate ID</b></th>
    <th><b>Associate First Name</b></th>
    <th><b>Associate Last Name</b></th>
    <th><b>Designation</b></th>
    <th><b>View</b></th>
    <th><b>Next Action</b></th>
  </tr>
<c:forEach items="${teamList}" var="element">
  <tr id="homerow1">
    <td>${element.getId()}</td>
    <td>${element.getFirstName()}</td>
    <td>${element.getLastName()}</td>
    <td>${element.getDesignation()}</td>
    <td><button type="button">></button></td>
    <td>
    <c:choose>
    <c:when test="${element.getEvaluationStatus() eq 'InProgress'}">
        <button type="button">Continue Evaluation</button>
    </c:when>
    <c:otherwise>
        Evaluation Complete
    </c:otherwise>
    </c:choose>
    </td>
  </tr>
</c:forEach>
</table>
<br>

        <div class="form-group" align="center">
            <input type="submit" value="Add a new associate" onclick="addNewAssociate()"></input>
        </div>

<div id="footer-bg">
	<div id="footer-content" class="container">
		<div id="column1">
			<ul class="list-style2">
				<li class="first"><a href="https://www.aholddelhaize.com/en/terms-of-use/">Terms of use</a></li>
				<li><a href="https://www.aholddelhaize.com/en/privacy-and-cookies-policy/">Privacy and Cookies Policy</a></li>
				<li><a href="https://www.aholddelhaize.com/en/security/">Security Notice</a></li>
			</ul>
		</div>
	</div>
</div>
<div id="footer">
	<p>© 2016 Tata Consultancy Services - All rights reserved.</p>
</div>
<!-- end #footer -->
</form>
</body>
</html>
