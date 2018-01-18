<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<template:admin>
	<jsp:attribute name="extraStyles">
<link rel="stylesheet"
			href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
	<jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>
	<jsp:body>
  <div>
    <div class="container min-container">
      <h2 class="basic-title">List category</h2>
        <div class="well">
          <table
						class="table table-condensed table-bordered table-striped table-hover">
          		  <thead>
	                  <tr>
	                  	<td>id</td>
		                  	<td>name</td>
		                  	<td>description</td>
						<td>actions</td>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}'
								var='object'>         		
	                  <tr>
						<td><a href="<c:url value='/category'/>/${object.id}">${object.id}</a></td>
		                  	<td>${object.name}</td>
		                  	<td>${object.description}</td>
		                  	<sec:authorize access="hasRole('ROLE_ADMIN')">
	                    	<td><a href="<c:url value='/category/remove'/>/${object.id}">Remove</a></td>
							</sec:authorize>
					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
           
		  <template:paginationComponent paginatedList="${paginatedList}"
						page="${param.page}" action="/category" />
		  <sec:authorize access="hasRole('ROLE_ADMIN')">
          <a href="<c:url value='/category/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Add New</a>
          </sec:authorize>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
