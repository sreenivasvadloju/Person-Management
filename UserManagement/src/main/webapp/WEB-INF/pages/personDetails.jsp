<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
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
  <form:form action="savePerson" method="post" modelAttribute="person">
  <form:hidden path="id"/>
  <h2>Person details & Address</h2>
  <table class="table table-striped">
   <thead>
	<th scope="row">First Name: ${person.firstName}</th>		
    <th scope="row">Last Name:  ${person.lastName}</th>
   </thead>
  </table>
    	<spring:url value="/usermanagement/addAddress?id=${person.id}" var="addAddressURL" />
	  	<a class="btn btn-primary" href="${addAddressURL }" role="button" >Add Address</a>
	  	<button type="button" class="btn btn-primary" onCLick="history.back()">Back</button>
  <table class="table table-striped">
   <thead>
	<th scope="row">Street</th>		
    <th scope="row">City</th>
    <th scope="row">State</th>
    <th scope="row">Postal Code</th>
    <th scope="row">Action</th>	
   </thead>
   <tbody>

   <c:if test="${empty listAddress}">
		<tr><td colspan="3" align="center"><font color="red">No Data</font></td></tr>
	</c:if>
   <c:forEach var="address" items="${listAddress}">
     <tr>
     <td>${address.street}</td>
	<td>${address.city}</td>
	<td>${address.state}</td>
	<td>${address.postalcode}</td>
      <td>
       <spring:url value="editAddress?id=${address.id}" var="editURL" />
       <a class="btn btn-primary" href="${editURL }" role="button" >Edit</a>
      </td>
      <td>
       <spring:url value="/usermanagement/deleteAddress?id=${address.id}" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button" >Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  </form:form>
 </div>
</body>
</html>