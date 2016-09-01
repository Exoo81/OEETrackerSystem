<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp" %>

<c:url var="firstUrl" value="/user/${dailyReports[0].user.id}/1/reports.html" />
<c:url var="lastUrl" value="/user/${dailyReports[0].user.id}/${deploymentReports.totalPages}/reports.html" />
<c:url var="prevUrl" value="/user/${dailyReports[0].user.id}/${currentIndex - 1}/reports.html" />
<c:url var="nextUrl" value="/user/${dailyReports[0].user.id}/${currentIndex + 1}/reports.html" />


<table class="table table-bordered table-hover table-oee">
	<thead>
		
	  <tr class="info">
	  	<th class="td-oee-h td-oee-mainh" colspan="4"><c:out value="${user.username}"/></th>
	  </tr>
	  <tr class="info">
	     <th class="td-oee-h id-oee">Id</th>
	     <th class="td-oee-h">Date of report</th>
	     <th class="td-oee-h">Output</th>
	     <th class="td-oee-h dr-oee">Shift</th>
	  </tr>
	</thead>
	<tbody>
		<c:forEach items="${dailyReports}" var="report">
			<tr>
				<td class="td-oee">${report.id}</td>
				<td class="td-oee">${report.dateOfReport}</td>
				<td class="td-oee">${report.actualOutput}</td>
				<td class="td-oee">${report.shift}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href='<spring:url value="/1/users.html" />' class="btn btn-info btn-sm">
	<i class="fa fa-long-arrow-left" aria-hidden="true"></i> &nbsp;Back to Users List
</a>


<center>
    <ul class="pagination">
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <li class="disabled"><a href="#"><span aria-hidden="true">&larr;</span> Newer</a></li>
                <li class="disabled"><a href="#">&laquo;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}"><span aria-hidden="true">&larr;</span> Newer</a></li>
                <li><a href="${prevUrl}">&laquo;</a></li>
            </c:otherwise>
        </c:choose>
        
        
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/user/${id}/${i}/reports.html" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        
        <c:choose>
            <c:when test="${currentIndex == deploymentReports.totalPages}">
                <li class="disabled"><a href="#">&raquo;</a></li>
                <li class="disabled"><a href="#">Older <span aria-hidden="true">&rarr;</span></a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&raquo;</a></li>
                <li><a href="${lastUrl}">Older <span aria-hidden="true">&rarr;</span></a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</center>