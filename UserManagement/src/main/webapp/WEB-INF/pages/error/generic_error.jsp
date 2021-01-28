<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<c:if test="${not empty errMsg}">
		<h4>${errMsg}</h4>
	</c:if>
	
</body>
</html>