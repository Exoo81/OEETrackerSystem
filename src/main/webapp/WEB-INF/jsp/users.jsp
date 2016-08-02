<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp" %>

<table class="table table-bordered table-hover table-oee">
	<thead>
	  <tr class="info">
	     <th class="td-oee-h id-oee">Id</th>
	     <th class="td-oee-h">Username</th>
	     <th class="td-oee-h dr-oee">Daily Reports</th>
	  </tr>
	</thead>

	<tbody>
		<c:forEach items="${usersWOW}" var="user">
		<tr>
			<td class="td-oee">${user.id}</td>
			<td class="td-oee"><a href='<spring:url value="/users/${user.id}.html" />'>${user.username}</a></td>
			<td class="td-oee">
				<a class="btn btn-danger" href='<spring:url value="/user/${user.id}/reports.html" />'>
  					<i class="fa fa-file-text-o" title="Daily reports list" aria-hidden="true"></i>
				</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>