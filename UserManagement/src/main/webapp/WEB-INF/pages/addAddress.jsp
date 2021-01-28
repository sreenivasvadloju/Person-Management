<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>New/Edit Person</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">

  <spring:url value="/usermanagement/saveAddress" var="saveURL" />
  <h2>New/Edit Address</h2>
  <form:form modelAttribute="address" method="post" action="${saveURL }" cssClass="form" >
  <form:hidden path="id" />
  <form:hidden path="person.id" />
<form:hidden path="person.firstName" />
<form:hidden path="person.lastName" />
  <table class="table table-striped">
   <thead>
	<th scope="row">First Name: ${person.firstName}</th>		
    <th scope="row">Last Name:  ${person.lastName}</th>
   </thead>
  </table>

   <div class="form-group">
    <label>Street:</label>
    <form:input path="street" cssClass="form-control" id="street" />
    <font color="red"> <form:errors path="street"></form:errors></font><br/>
   </div>
   <div class="form-group">
    <label>City:</label>
    <form:input path="city" cssClass="form-control" id="city" />
    <font color="red"> <form:errors path="city"></form:errors></font><br/>
   </div>
    <div class="form-group">
    <label>state:</label>
    <form:input path="state" cssClass="form-control" id="state" />
    <font color="red"> <form:errors path="state"></form:errors></font><br/>
   </div>
   <div class="form-group">
    <label>Postal Code:</label>
    <form:input path="postalcode" cssClass="form-control" id="postalcode" />
    <font color="red"> <form:errors path="postalcode"></form:errors></font><br/>
   </div>
   <button type="submit" class="btn btn-primary">Save</button>
   <button type="button" class="btn btn-primary" onCLick="history.back()">Back</button>
  </form:form>
  
 </div>
</body>
</html>