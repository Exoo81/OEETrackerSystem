<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- JQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<!-- minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		
		<!-- Resources -->
		<spring:url value="/resources/css/style.css" var="styleCSS" />
		<spring:url value="/resources/js/tooltip.js" var="tooltipJS" />
		<spring:url value="/resources/js/triggerRemove.js" var="triggerRemove" />
		
		<!-- minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<!-- Custom CSS style -->
		<link href="${styleCSS}" rel="stylesheet"/>
		<!-- theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		<!-- Awesome fonts -->
		<script src="https://use.fontawesome.com/969da422e1.js"></script>
		<!-- Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
		
		<!-- JS -->
		<script src="${tooltipJS}"></script>
		<script src="${triggerRemove}"></script>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><tiles:getAsString name="title" /></title>
	</head>
	
	<body>
	
	<tilesx:useAttribute name="activePage"/>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href='<spring:url value="/index.html" />'>OEE Tracker System</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	<security:authorize access="isAuthenticated()">
		        <security:authorize access="hasRole('ROLE_ADMIN')">  
            		<li class="${activePage == 'register' ? 'active' : ''}"><a href='<spring:url value="/register.html" />'>Register</a></li>
            	</security:authorize>
            </security:authorize>
            <security:authorize access="! isAuthenticated()">
            	<li class="${activePage == 'login' ? 'active' : ''}"><a href='<spring:url value="/login.html" />'>Login</a></li>
            </security:authorize>
            <security:authorize access="isAuthenticated()">
            	<li><a href='<spring:url value="/account.html" />'>My Account</a></li>
            	<li><a href='<spring:url value="/logout" />'>Logout</a></li>
            </security:authorize>
            <!-- <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li> -->
          </ul>
          <!-- <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form> -->
        </div>
      </div>
    </nav>
    
    <div class="container-fluid">
      <div class="row">
      
      <security:authorize access="isAuthenticated()">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
	            <li class="${activePage == 'index' ? 'active' : ''}"><a href='<spring:url value="/index.html" />'>Home </a></li>
	            <li class="${activePage == 'dailyReport' ? 'active' : ''}"><a href='<spring:url value="/1/dailyReport.html" />'>Daily Report</a></li>
	            <security:authorize access="hasRole('ROLE_ADMIN')">
	            	<li class="${activePage == 'users' ? 'active' : ''}"><a href='<spring:url value="/1/users.html" />'>Users</a></li>
	            </security:authorize>
	            <li class="${activePage == 'productionLinesList' ? 'active' : ''}"><a href='<spring:url value="/1/production_lines.html" />'>Production Lines</a></li>
          </ul>
        </div>
        </security:authorize>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header oee-header"><tiles:insertAttribute name="header" /></h1>
          	<tiles:insertAttribute name="body"/>
			<br><br>
        </div>
      </div>
    </div>
   
    <div class="footer footer-oee">
	    <center>
			<tiles:insertAttribute name="footer"/>
		</center>
    </div>
    
    <!-- do osobnego pliku -->
    <!-- <script type="text/javascript">
		$('document').ready(function(){
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script> -->
    

	</body>
</html>