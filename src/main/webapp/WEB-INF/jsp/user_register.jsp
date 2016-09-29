<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp"%>


<center>
	<form:form commandName="userRegistrationForm" cssClass="form-horizontal" method="POST">

		<c:if test="${param.success eq true}">
			<div class="alert alert-success">Registration successful !</div>
		</c:if>


		<div class="form-group">
			<label class="col-sm-2"></label> <label for="name" class="col-sm-2 control-label">Username:</label>
			<div class="col-sm-3">
				<form:input path="username" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2"></label> <label for="password" class="col-sm-2 control-label">Password:</label>
			<div class="col-sm-3">
				<form:password path="password" cssClass="form-control" />
			</div>
		</div>

		<div class="form-group">
		<label class="col-sm-2"></label> 
		<label for="roleId" class="col-sm-2 control-label">Roles:</label>
			<div class="col-sm-4">
				 <c:forEach var="role" items="${rolesList}">
					<span class="checkbox">
					<form:checkbox path="roleId" value="${role.id}" label="${role.roleName}"/></span>
				</c:forEach>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2"></label> <label for="firstName" class="col-sm-2 control-label">First Name:</label>
			<div class="col-sm-3">
				<form:input path="firstName" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2"></label> <label for="lastName" class="col-sm-2 control-label">Last Name:</label>
			<div class="col-sm-3">
				<form:input path="lastName" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2"></label> <label for="jobTitle" class="col-sm-2 control-label">Job Title:</label>
			<div class="col-sm-3">
				<form:input path="jobTitle" cssClass="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2"></label> <label for="email" class="col-sm-2 control-label">Email:</label>
			<div class="col-sm-3">
				<form:input path="email" cssClass="form-control" />
			</div>
		</div>



		<div class="form-group">
			<div class="col-sm-11">
				<input type="submit" value="Save" name="submit" class="btn btn-success" />
			</div>
		</div>

	</form:form>
	
	
	
</center>