<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!--important line to display jstl form -->    
<%@ page contentType="text/html; charset=UTF-8" %>  <!--important line to display emojis-->
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>
	<title></title>
</head>
<body>
	<a href="/questions" class="margin-left">Dashboard</a>
		<h1 class="mb-3"><c:out value="${question.question}"/></h1>
	<div>
		<label class="lead">Tags</label>
		<div class="card-group mb-3">
	    <c:forEach items="${question.tags}" var="tag">
	    	<div class="card text-center max-width max-height">
    			<p class="text-muted"><c:out value="${tag.subject}"/></p>
	    	</div>
	    </c:forEach>
	    </div>
    </div>
  
	<table class="table">
		<thead class="thead-dark">
		        <tr>
		            <th>Answers</th>
		        </tr>
		</thead>
		<tbody>
		        <c:forEach items="${question.answers}" var="answer">
		        <tr>
		            <td>+<c:out value="${answer.answer}"/></td>
		        </tr>
		        </c:forEach>
		</tbody>
	</table>
	
	<h3>Add Your Answer</h3>
	<form:form action="/answers/new/action/${question.id}" method="POST" modelAttribute="answerObj">
	<p>
		<form:errors path="answer"/>
		<form:textarea path="answer" class="form-control textarea"/>
	</p>
	<input type="submit" value="Submit"/>
	</form:form>
</body>