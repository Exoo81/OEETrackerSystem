<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp" %>




<c:choose>
    <c:when test="${param.delete eq true}">
        <div class="alert alert-success">Deleting successful !</div>
        <br />
    </c:when>  
    <c:when test="${param.delete eq false}">
        <div class="alert alert-danger">Access denied !</div>
        <br />
    </c:when>   
   
</c:choose>


<c:url var="firstUrl" value="/1/dailyReport.html" />
<c:url var="lastUrl" value="/${deploymentDailyReports.totalPages}/dailyReport.html" />
<c:url var="prevUrl" value="/${currentIndex - 1}/dailyReport.html" />
<c:url var="nextUrl" value="/${currentIndex + 1}/dailyReport.html" />

<!-- Button trigger modal -->
	<button type="button" class="btn btn-success btn-sm"
		data-toggle="modal" data-target="#myModal">
		<i class="fa fa-plus" aria-hidden="true"></i> &nbsp; Add Daily Report
	</button>
<hr>
// all or filter per line or last week with option for pick dates range<br>

<hr>
//grafika dotyczaca raportow z listy ponizej<br>
<hr>


<table class="table table-bordered table-hover table-oee">
	<thead>
	  <tr class="info">
	     <th class="td-oee-h id-oee">Id</th>
	     <th class="td-oee-h">Shift</th>
	     <th class="td-oee-h dr-oee">Date of report</th>
	     <th class="td-oee-h dr-oee">Author</th>
	     <th class="td-oee-h">Remove</th>
	   
	  </tr>
	</thead>

	<tbody>
		<c:forEach items="${dailyReportWoW}" var="dailyReport">
		<tr>
			<td class="td-oee">${dailyReport.id}</td>
			<td class="td-oee">${dailyReport.shift}</td>
			<td class="td-oee">${dailyReport.dateOfReport}</td>
			<td class="td-oee"><a href='<spring:url value="/dailyReport/user/${dailyReport.reportCreatedBy.id}.html" />'>${dailyReport.reportCreatedBy.username}</a></td>
			<td class="td-oee">
				
				<c:choose>
					<c:when test="${pageContext.request.userPrincipal.name eq dailyReport.reportCreatedBy.username}">
						<a class="btn btn-danger triggerRemove" href="<spring:url value="/dailyReport/${dailyReport.reportCreatedBy.username}/remove/${dailyReport.id}.html" />">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;Remove
						</a>
					</c:when>
					<c:otherwise>
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<a class="btn btn-danger triggerRemove" href="<spring:url value="/dailyReport/remove/${dailyReport.id}.html" />">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;Remove
							</a>
						</security:authorize>
					</c:otherwise>
				</c:choose>
			 
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${deploymentDailyReports.totalPages != 0}">
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
				<c:url var="pageUrl" value="/${i}/dailyReport.html" />
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
				<c:when test="${currentIndex == deploymentDailyReports.totalPages}">
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

<!-- Modal -->
<div class="modal fade" id="modalRemoveInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Report</h4>
      </div>
      <div class="modal-body">
        Really remove ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>
