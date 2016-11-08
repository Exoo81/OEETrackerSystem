<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../template/taglibs.jsp"%>

<c:url var="firstUrl" value="/1/production_lines/users/${productionLine.id}.html" />
<c:url var="lastUrl" value="/${deploymentAuthorizedUsersPages.totalPages}/production_lines/users/${productionLine.id}.html" />
<c:url var="prevUrl" value="/${currentIndex - 1}/production_lines/users/${productionLine.id}.html" />
<c:url var="nextUrl" value="/${currentIndex + 1}/production_lines/users/${productionLine.id}.html" />


<!-- TODO:
edycja usera <form w modalu z widoku tabeli i to samo juz zrovic z lista users i userdetail www
opcja znalezienia 
dodania nowego  -->

<c:if test="${param.removeFromList eq true}">
		<div class="alert alert-success">User deleted from the authorized list !</div>
</c:if>

<security:authorize access="hasRole('ROLE_ADMIN')">
	<!-- Button trigger modal add line -->
	<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#addUserModal">
		<i class="fa fa-plus" aria-hidden="true"></i> &nbsp;Add new user
	</button>
	<br>
	<br>
</security:authorize>

<table class="table table-bordered table-hover table-oee">
	<thead>
	  <tr class="info">
	     <th class="td-oee-h id-oee">Id</th>
	     <th class="td-oee-h">Username</th>
	     <th class="td-oee-h">First name</th>
	     <th class="td-oee-h">Last name</th>
	     <th class="td-oee-h">Job title</th>
	     <th class="td-oee-h">Email</th>
	     <security:authorize access="hasRole('ROLE_ADMIN')"> 
	     	<th class="td-oee-h">Options</th>
	     </security:authorize>
	  </tr>
	</thead>

	<tbody>
		<c:forEach items="${authorizedUsersListWoW}" var="user">
		<tr>
			<td class="td-oee">${user.id}</td>
			<td class="td-oee">${user.username}</td>
			<td class="td-oee">${user.userDetails.firstName}</td>
			<td class="td-oee">${user.userDetails.lastName}</td>
			<td class="td-oee">${user.userDetails.jobTitle}</td>
			<td class="td-oee">
				<c:out value="${empty user.userDetails.email ? '-' : user.userDetails.email}" />
			</td>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<td class="td-oee dr-oee">
				<!-- Button trigger modal add line -->
					<span data-toggle="modal" data-target="#editUserDetails" data-email="${user.userDetails.email}" data-jobtitle="${user.userDetails.jobTitle}" data-username="${user.username}">
						<button type="button" class="btn btn-info btn-sm" data-toggle="tooltip" title="Edit user details" data-placement="left" >
							<i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i>
						</button>
					</span>
					<a class="btn btn-danger btn-sm triggerRemove" id="toolTipID" href="<spring:url value="/production_lines/remove/user/${user.id}/${productionLine.id}.html" />" data-toggle="tooltip" title="Remove user from authorized list" data-placement="left">
						<i class="fa fa-minus fa-lg" aria-hidden="true"></i>
					</a>
				</td>
			</security:authorize>

		</tr>
		</c:forEach>
	</tbody>
</table>

<a href='<spring:url value="/1/production_lines.html" />' class="btn btn-info btn-sm"> 
	<i class="fa fa-long-arrow-left" aria-hidden="true"></i> &nbsp;Back to List of Production Line 
</a>

<c:if test="${deploymentAuthorizedUsersPages.totalPages != 0}">
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
				<c:url var="pageUrl" value="/${i}/production_lines/users/${productionLine.id}.html" />
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
					test="${currentIndex == deploymentAuthorizedUsersPages.totalPages}">
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


<!-- Modal Add user to list -->
<%-- <form:form commandName="productionLine" cssClass="form-horizontal"> --%>
	<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Find user ...</h4>
				</div>
				<div class="modal-body">
				
				<!-- <div class="col-lg-6"> -->
    				<div class="input-group">
      					<input type="text" class="form-control" placeholder="Search username...">
      					<span class="input-group-btn">
        					<button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"></span> Search</button>
      					</span>
    				</div>
  				<!-- </div> -->
					<%-- <div class="form-group"> 
						<label for="name" class="col-sm-6 control-label">New Production Line name:</label>
						<div class="col-sm-6">
							<form:input path="name" cssClass="form-control" />
						</div>
					</div> --%>
					
				</div>
				<!-- <div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-success" value="Add user" />
				</div> -->
			</div>
		</div>
	</div>
<%-- </form:form> --%>


<!-- Modal edit userdetails -->
<div class="modal fade" id="editUserDetails" tabindex="-1" role="dialog" aria-labelledby="editEmailModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="editEmailModalLabel">Edit User Details</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="jobTitle" class="control-label">Job title:</label>
            <input type="text" class="form-control" id="jobTitle">
          </div>
          <div class="form-group">
            <label for="email" class="control-label">Email:</label>
            <input type="text" class="form-control" id="email">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-info"><i class="fa fa-pencil-square-o fa-lg" aria-hidden="true"></i>&nbsp;Edit</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal Remove -->
<div class="modal fade" id="modalRemoveInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove User from authorized list</h4>
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

<script>

$('document').ready(function(){
	
	$('#editUserDetails').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var currentEmail = button.data('email') // Extract info from data-* attributes
		  var currentJobTitle = button.data('jobtitle')
		  var currentUsername = button.data('username')// Extract info from data-* attributes
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		  modal.find('.modal-title').text('Edit details for ' + currentUsername)
		  modal.find('.modal-body input[id=jobTitle]').val(currentJobTitle)
		  modal.find('.modal-body input[id=email]').val(currentEmail)
		})
});


</script>
