<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp"%>


<dl class="dl-horizontal">
	<dt class="dt-oee">First name:</dt>
	<dd class="dd-oee">${userDetailsWoW.userDetails.firstName}</dd>
	<dt class="dt-oee">Last name:</dt>
	<dd class="dd-oee">${userDetailsWoW.userDetails.lastName}</dd>
	<dt class="dt-oee">Email:</dt>
	<dd class="dd-oee">${userDetailsWoW.userDetails.email}</dd>
	<dt class="dt-oee">Job Title:</dt>
	<dd class="dd-oee">${userDetailsWoW.userDetails.jobTitle}</dd>
</dl>

<c:choose>
	<c:when test="${parentLink == 'account' }">
		<a href='<spring:url value="/index.html" />'
			class="btn btn-info btn-sm"> <i class="fa fa-long-arrow-left"
			aria-hidden="true"></i> &nbsp;Back to Home
		</a>
	</c:when>
	<c:when test="${parentLink == 'users' }">
		<a href='<spring:url value="/1/users.html" />'
			class="btn btn-info btn-sm"> <i class="fa fa-long-arrow-left"
			aria-hidden="true"></i> &nbsp;Back to list of users
		</a>
	</c:when>
	<c:when test="${parentLink == 'dailyReport' }">
		<a href='<spring:url value="/1/dailyReport.html" />'
			class="btn btn-info btn-sm"> <i class="fa fa-long-arrow-left"
			aria-hidden="true"></i> &nbsp;Back to Daily Report page
		</a>
	</c:when>
	<c:when test="${parentLink == 'productionLine' }">
		<a href='<spring:url value="/1/production_lines.html" />'
			class="btn btn-info btn-sm"> <i class="fa fa-long-arrow-left"
			aria-hidden="true"></i> &nbsp;Back to Production Line page
		</a>
	</c:when>
	<c:otherwise>
		<a href='<spring:url value="/1/users.html" />'
			class="btn btn-info btn-sm"> <i class="fa fa-long-arrow-left"
			aria-hidden="true"></i> &nbsp;Back to Users List
		</a>
	</c:otherwise>
</c:choose>


