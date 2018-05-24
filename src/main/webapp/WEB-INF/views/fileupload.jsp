<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
	<form:form method="POST" action="processUploadFile.htm"  enctype="multipart/form-data" modelAttribute="FileUploadForm">
		File to upload: <form:input type="file" path="file"/><br />  
		<input type="submit" value="Upload"/> Press here to upload the file!
	</form:form>	
</body>
</html>