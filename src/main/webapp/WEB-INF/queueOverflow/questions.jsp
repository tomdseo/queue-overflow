<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page contentType="text/html; charset=UTF-8" %>  <!--important line to display emojis-->
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css"/>
	<title></title>
</head>
<body>
	<h1 class="mb-5">📚 Queue Overflow</h1>
	<!--TABLE & OUTPUT----------------------------------------- -->
	<table class="table">
		<thead class="thead-dark">
		        <tr>
		            <th>Questions</th>
		            <th>Tags</th>
		        </tr>
		</thead>
		<tbody>
		<c:if test="${questions.size() > 0}">
	      	<c:forEach items="${questions}" var="q">
	        <tr>
	            <td><a href="/questions/${q.id}"><c:out value="${q.question}"/></a></td>
	             <td>|
		            <c:forEach items="${q.tags}" var="tag">
		            	<c:out value="${tag.subject} |"/>
		            </c:forEach>
	            </td>
	        </tr>
	        </c:forEach>
	    </c:if>
	    <c:if test="${questions.size() == 0}">
	    <tr>
	    	<td>No Questions to Display</td>
	    	<td>None</td>
	    </tr>
	    </c:if>
		</tbody>
	</table>
	<a href="/questions/new" class="btn btn-primary btn-sm mt-3">New Question</a>
</body>