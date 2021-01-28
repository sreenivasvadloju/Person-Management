<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Article Form</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <spring:url value="/usermanagement/savePerson" var="saveURL" />
  <h2 align="center" >New/Edit Person</h2>
  <br>
  <form:form modelAttribute="person" method="post" action="${saveURL }" cssClass="form" >
   <form:hidden path="id"/>
   <div class="form-group">
    <label>First Name:</label>
    <form:input path="firstName" cssClass="form-control" id="firstName" size="50" maxlength="50"/>
     <font color="red"> <form:errors path="firstName"></form:errors></font><br/>
   </div>
   <div class="form-group">
    <label>Last Name:</label>
    <form:input path="lastName" cssClass="form-control" id="lastName" size="50" maxlength="50"/>
    <font color="red"> <form:errors path="lastName"></form:errors></font><br/>
   </div>
   <button type="submit" class="btn btn-primary">Save</button>
   <button type="button" class="btn btn-primary" onCLick="history.back()">Back</button>
  </form:form>
  
 </div>
</body>
</html>