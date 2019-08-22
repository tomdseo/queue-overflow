<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!--important line to display jstl form -->    
<%@ page contentType="text/html; charset=UTF-8" %>  <!--important line to display emojis-->
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>
	<title></title>
</head>
<body>
	<h1>What is your Question?</h1>
	<form:form action="/questions/new/action" method="POST" modelAttribute="questionObj">
	<p>
		<form:label path="question" class="lead">Question</form:label>
		<form:textarea path="question" class="form-control"></form:textarea>
	</p>
	<p>
	<label class="lead">Tags</label><a> </a><label>(Separate each word with commas)</label>
	<input type="text" name="tags" class="form-control" required/>
	</p>

	<input type="submit" value="Submit"/>
	</form:form>
	
</body>