<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp"%>


<center>
	<form:form commandName="user" cssClass="form-horizontal" method="POST">

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
		<label for="roles" class="col-sm-2 control-label">Roles:</label>
			<div class="col-sm-4">
				 <%-- <c:forEach var="role" items="${rolesList}">
					<span class="checkbox">
						<form:checkbox path="roles" value="${role}" label="${role.roleName}"/></span>
				</c:forEach> --%>
				<%-- <form:checkboxes path="roles" items="${rolesList}" itemLabel="roleName" /> --%>
				<spring:bind path="roles">
						<label class="col-sm-2 control-label">Roles</label>
						<div class="col-sm-10">
							<form:checkboxes path="roles" items="${rolesList}" element="label class='checkbox-inline'" />
							<br />
							
						</div>

				</spring:bind>

			</div>
		</div>



		<div class="form-group">
			<div class="col-sm-11">
				<input type="submit" value="Save" name="submit" class="btn btn-success" />
			</div>
		</div>

	</form:form>
	
	
	
</center>