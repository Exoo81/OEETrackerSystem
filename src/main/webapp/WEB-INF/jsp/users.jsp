<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
			<td class="td-oee">${user.username}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>