<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<table class="table table-bordered table-hover table-oee">
	<thead>
	  <tr class="info">
	     <th class="td-oee id-oee">Id</th>
	     <th class="td-oee">Username</th>
	  </tr>
	</thead>

	<tbody>
		<c:forEach items="${usersWOW}" var="user">
		<tr>
			<td class="td-oee id-oee">${user.id}</td>
			<td class="td-oee"><a href='<spring:url value="/users/${user.id}.html" />'>${user.username}</a></td>
			
		</tr>
		</c:forEach>
	</tbody>
</table>