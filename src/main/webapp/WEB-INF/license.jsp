<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

<body>
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <span class="navbar-brand mb-0 h1">New License</span>
  </div>
</nav>

<form:form method = "post" action = "/create/license" modelAttribute = "license">
		
		<p>
			<form:label path = "person">Person:</form:label>
			<form:select path = "person">
				<c:forEach items = "${persons}" var = "person">
					<c:if test = "${person.getLicense() == null}">
						<form:option value = "${person}" label = "${person.getFirstName()} ${person.getLastName()}"/>					
					</c:if>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path = "state">State:</form:label>
			<form:input path = "state"/>
		</p>
		<p>
			<form:label path = "expirationDate">Expiration Date:</form:label>
			<form:input type = "date" path = "expirationDate"/>
		</p>
		<button type="submit" >Create License</button>
	</form:form>
    








<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>

</body>
</html>