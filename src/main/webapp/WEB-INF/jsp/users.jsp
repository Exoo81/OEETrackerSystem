<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp" %>

<c:url var="firstUrl" value="/1/users.html" />
<c:url var="lastUrl" value="/${deploymentUsers.totalPages}/users.html" />
<c:url var="prevUrl" value="/${currentIndex - 1}/users.html" />
<c:url var="nextUrl" value="/${currentIndex + 1}/users.html" />

<script type="text/javascript">

	$(document).ready(function(){		
		$('.triggerRemove').click(function(e){
				e.preventDefault();
				$('#modalRemoveInfo .removeBtn').attr("href", $(this).attr("href"));
				$('#modalRemoveInfo').modal();
		});		
	});

</script>


<c:if test="${param.delete eq true}">
			<div class="alert alert-success">Deleting successful !</div>
</c:if>

<table class="table table-bordered table-hover table-oee">
	<thead>
	  <tr class="info">
	     <th class="td-oee-h id-oee">Id</th>
	     <th class="td-oee-h">Username</th>
	     <th class="td-oee-h dr-oee">Daily Reports</th>
	     <th class="td-oee-h">Remove</th>
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
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<td class="td-oee dr-oee">
					<a class="btn btn-danger triggerRemove" href="<spring:url value="/user/remove/${user.id}.html" />">
						<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;Remove
					</a>
				</td>
			</security:authorize>
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

<!-- Modal -->
<div class="modal fade" id="modalRemoveInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove User</h4>
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