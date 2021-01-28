<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Article List</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <h2 align="center">Person List</h2>
  <br>
  <table class="table table-striped">
   <thead>
    <th scope="row">First Name</th>
    <th scope="row">Last Name</th>
    <th scope="row" colspan="3">Action</th>	
   </thead>
   <tbody>
   <c:if test="${not empty errMsg}">
   	<tr><td colspan="3" align="center"><font color="red">${errMsg}</font></td></tr>
	</c:if>
   <c:forEach var="person" items="${personList}">
     <tr>
      <td>${person.firstName}</td>
      <td>${person.lastName}</td>
      <td>
       <spring:url value="editPerson?id=${person.id}" var="editURL" />
       <a class="btn btn-primary" href="${editURL }" role="button" >Edit</a>
      </td>
      <td>
       <spring:url value="/usermanagement/deletePerson?id=${person.id}" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" >Delete</a>
      </td>
        <td>
       <spring:url value="/usermanagement/viewPersonAddress?id=${person.id}" var="viewURL" />
       <a class="btn btn-primary" href="${viewURL}" role="button" >View Person Address</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/usermanagement/newPerson" var="addNewPersonURL" />
  <a class="btn btn-primary" href="${addNewPersonURL }" role="button" >Add New Person</a>
 </div>
</body>
</html>