<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<dl class="dl-horizontal">
  <dt class="dt-oee">First name:</dt>
  <dd class="dd-oee">${userDetailsWoW.firstName}</dd>
  <dt class="dt-oee">Last name:</dt>
  <dd class="dd-oee">${userDetailsWoW.lastName}</dd>
  <dt class="dt-oee">Job Title:</dt>
  <dd class="dd-oee">${userDetailsWoW.jobTitle}</dd>
</dl>

<a href='<spring:url value="/users.html" />' class="btn btn-info btn-sm">
	<i class="fa fa-long-arrow-left" aria-hidden="true"></i> &nbsp;Back to Users List
</a>

