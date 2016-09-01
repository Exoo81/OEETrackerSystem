<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<center>
<form:form commandName="user" cssClass="form-horizontal">
	<div class="form-group">
	    <label class="col-sm-2"></label>
		<label for="name" class="col-sm-2 control-label">Username:</label>
		<div class="col-sm-3">
			<form:input path="username" cssClass="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
	    <label class="col-sm-2"></label>
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-3">
			<form:password path="password" cssClass="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-11">
			<input type="submit" value="Save" class="btn btn-success" />
		</div>
	</div>

</form:form>
</center>