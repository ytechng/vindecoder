<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/img" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Carfacts - ${title}</title>
	
	<script>
		window.menu = '${title}';
	</script>
	
	<!-- Stylesheets -->
	<%@ include file="./shared/styles.jsp" %>

  </head>

  <body>

    <!-- Navigation -->
    <%@ include file="./shared/navbar.jsp" %>

    <!-- Page Content -->
    <!-- Load home content file -->
   
   <div class="row">
   		
	   <div class="col-md-8 mx-auto">
	   		<div class="jumbotron">
				<h1>${errorTitle}</h1>
				<hr>
									
				<blockquote>
					${errorDesc}
				</blockquote>
			</div>
		</div>
		
		<div style="padding-bottom: 40%;"></div>
	</div>
    
    <!-- /.container -->

    <!-- Footer -->
    <%@ include file="./shared/footer.jsp" %>

    <!-- JavaScript -->
    <%@ include file="./shared/scripts.jsp" %>

  </body>

</html>
					