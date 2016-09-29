<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp" %>

<c:url var="firstUrl" value="/1/users.html" />
<c:url var="lastUrl" value="/${deploymentUsers.totalPages}/users.html" />
<c:url var="prevUrl" value="/${currentIndex - 1}/users.html" />
<c:url var="nextUrl" value="/${currentIndex + 1}/users.html" />

<table class="table table-bordered table-hover table-oee">
	<thead>
	  <tr class="info">
	     <th class="td-oee-h id-oee">Id</th>
	     <th class="td-oee-h">Username</th>
	     <th class="td-oee-h dr-oee">Daily Reports</th>
	  </tr>
	</thead>

	<tbody>
		<c:forEach items="${usersWoW}" var="user">
		<tr>
			<td class="td-oee">${user.id}</td>
			<td class="td-oee"><a href='<spring:url value="/users/${user.id}.html" />'>${user.username}</a></td>
			<td class="td-oee">
				<c:choose>
					<c:when test="${not empty user.dailyReports}">
				<a class="btn btn-success" href='<spring:url value="/user/${user.id}/1/reports.html" />'>
  					<i class="fa fa-file-text-o" title="Daily reports list" aria-hidden="true"></i>
				</a>
				</c:when>
				</c:choose>
				<%-- <a class="btn btn-danger" href='<spring:url value="/user/${user.id}/reports.html" />'>
  					<i class="fa fa-file-text-o" title="Daily reports list" aria-hidden="true"></i>
				</a> --%>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${deploymentUsers.totalPages != 0}">
	<center>
		<ul class="pagination">
			<c:choose>
				<c:when test="${currentIndex == 1}">
					<li class="disabled"><a href="#"><span aria-hidden="true">&larr;</span>
							Newer</a></li>
					<li class="disabled"><a href="#">&laquo;</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${firstUrl}"><span aria-hidden="true">&larr;</span>
							Newer</a></li>
					<li><a href="${prevUrl}">&laquo;</a></li>
				</c:otherwise>
			</c:choose>


			<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				<c:url var="pageUrl" value="/${i}/users.html" />
				<c:choose>
					<c:when test="${i == currentIndex}">
						<li class="active"><a href="${pageUrl}"><c:out
									value="${i}" /></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:choose>
				<c:when test="${currentIndex == deploymentUsers.totalPages}">
					<li class="disabled"><a href="#">&raquo;</a></li>
					<li class="disabled"><a href="#">Older <span
							aria-hidden="true">&rarr;</span></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${nextUrl}">&raquo;</a></li>
					<li><a href="${lastUrl}">Older <span aria-hidden="true">&rarr;</span></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</center>
</c:if>