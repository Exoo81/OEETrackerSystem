<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Spring MVC checkbox</title>
</head>

<body>
	<h2>The roles you selected are shown below:</h2>
	<br>
	<c:if test="${empty userSuccess.roles}">
    	userSuccess.roles is empty or null.
	</c:if>
	<c:if test="${not empty userSuccess.roles}">
    	userSuccess.roles is NOT empty or null.
	</c:if>
	<c:forEach var="role" items="${userSuccess.roles}">  
	Role:
			<c:out value="${role}"/><br>
			
	</c:forEach>

</body>
</html> --%>