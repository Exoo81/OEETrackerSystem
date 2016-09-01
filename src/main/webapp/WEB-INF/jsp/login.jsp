<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../template/taglibs.jsp" %>

<link href="/resources/css/signin.css" rel="stylesheet" type="text/css"  />

<form class="form-signin" action="<spring:url value="/login" />" method="POST">
	<h2 class="form-signin-heading">Please sign in</h2>
	
	<label for="username" class="sr-only">Username</label> 
	<input type="text" name="username" id="username" class="form-control" placeholder="Username" required autofocus> 
	<label for="password" class="sr-only">Password</label> 
	<input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
	
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>