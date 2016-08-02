<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../template/taglibs.jsp" %>


<table class="table table-bordered table-hover table-oee">
	<thead>
		
	  <tr class="info">
	  	<!-- <th class="td-oee-h td-oee-mainh" colspan="4"><c:out value="${reportsWoW.username }"/></th> -->
	  </tr>
	  <tr class="info">
	     <th class="td-oee-h id-oee">Id</th>
	     <th class="td-oee-h">Date of report</th>
	     <th class="td-oee-h">Output</th>
	     <th class="td-oee-h dr-oee">Shift</th>
	  </tr>
	</thead>
	<tbody>
		<c:forEach items="${reportsWoW.dailyReports}" var="report">
			<tr>
				<td class="td-oee">${report.id}</td>
				<td class="td-oee">${report.dateOfReport}</td>
				<td class="td-oee">${report.actualOutput}</td>
				<td class="td-oee">${report.shift}</td>
			</tr>
		</c:forEach>
	<!-- example for fetch=FetchType.LAZY -->
	<!--<c:forEach items="${usersWOW.dailyReports}" var="dailyReport">
	<tr>
			<td class="td-oee">${dailyReport.id}</td>
			<td class="td-oee">${dailyReport.user.username}</td>
			<td class="td-oee">${dailyReport.dateOfReport}</td>
			<td class="td-oee">${dailyReport.actualOutput}</td>
			<td class="td-oee">${dailyReport.shift}</td>
			</tr>
	</c:forEach>-->
		
	</tbody>
</table>