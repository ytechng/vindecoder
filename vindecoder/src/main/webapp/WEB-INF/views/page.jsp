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
    <c:if test="${userClickHome == true}">
    	<%@ include file="home.jsp" %>
    </c:if>
    
    <!-- Load contact us content file -->
    <c:if test="${userClickContact == true}">
    	<%@ include file="contact.jsp" %>
    </c:if>
    
    <!-- Load my profile content file -->
    <c:if test="${userClickProfile == true}">
    	<%@ include file="profile.jsp" %>
    </c:if>
    
    <!-- Load edit profile content file -->
    <c:if test="${userClickEditProfile == true}">
    	<%@ include file="editProfile.jsp" %>
    </c:if>
    
    <!-- Load change password content file -->
    <c:if test="${userClickChangePassword == true}">
    	<%@ include file="changePassword.jsp" %>
    </c:if>
    
    <!-- Load Sign in content file -->
    <c:if test="${userClickSignIn == true}">
    	<%@ include file="signin.jsp" %>
    </c:if>
    
    <!-- /.container -->

    <!-- Footer -->
    <%@ include file="./shared/footer.jsp" %>

    <!-- JavaScript -->
    <%@ include file="./shared/scripts.jsp" %>

  </body>

</html>