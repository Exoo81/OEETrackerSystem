<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp" %>

<c:url var="firstUrl" value="/1/production_lines.html" />
<c:url var="lastUrl" value="/${deploymentProductionLines.totalPages}/production_lines.html" />
<c:url var="prevUrl" value="/${currentIndex - 1}/production_lines.html" />
<c:url var="nextUrl" value="/${currentIndex + 1}/production_lines.html" />

<c:if test="${param.success eq true}">
		<div class="alert alert-success">New Production Line created !</div>
</c:if>

<security:authorize access="hasRole('ROLE_ADMIN')">
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-success btn-sm"
		data-toggle="modal" data-target="#myModal">
		<i class="fa fa-plus" aria-hidden="true"></i> &nbsp;Add Production
		Line
	</button>
	<br>
	<br>
</security:authorize>

<table class="table table-bordered table-hover table-oee">
	<thead>
	  <tr class="info">
	     <th class="td-oee-h id-oee">Id</th>
	     <th class="td-oee-h">Line name</th>
	     <th class="td-oee-h">Created by</th>
	     <security:authorize access="hasRole('ROLE_ADMIN')"> 
	     	<th class="td-oee-h">Remove</th>
	     </security:authorize>
	  </tr>
	</thead>

	<tbody>
		<c:forEach items="${productionLinesWoW}" var="productionLine">
		<tr>
			<td class="td-oee">${productionLine.id}</td>
			<td class="td-oee">${productionLine.name}</td>
			<td class="td-oee">${productionLine.productionLineCreatedBy.username}</td>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<td class="td-oee dr-oee"><a class="btn btn-danger" href="<spring:url value="/productionLine/remove/${productionLine.id}.html" />">Remove</a></td>
			</security:authorize>
		</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${deploymentProductionLines.totalPages != 0}">
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
				<c:url var="pageUrl" value="/${i}/production_lines.html" />
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
				<c:when
					test="${currentIndex == deploymentProductionLines.totalPages}">
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
<form:form commandName="productionLine" cssClass="form-horizontal">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Create new production line</h4>
				</div>
				<div class="modal-body">
				
					<div class="form-group"> 
						<label for="name" class="col-sm-6 control-label">New Production Line name:</label>
						<div class="col-sm-6">
							<form:input path="name" cssClass="form-control" />
						</div>
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Save" />
				</div>
			</div>
		</div>
	</div>
</form:form>
