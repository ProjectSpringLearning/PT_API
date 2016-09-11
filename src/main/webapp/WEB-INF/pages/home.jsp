<%@page import="org.khmeracademy.entities.User"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='sec' uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<h1> Home Page </h1>
<%-- 		<sec:authorize access="hasRole('ADMIN')"> --%>
<!--             <label><a href="#">ADMIN</label> -->
<%--         </sec:authorize> --%>
        
        <%
                                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                                		User user = (User)authentication.getPrincipal();
                                		out.print("____________adminID " +user.getId());
                                		out.print("____________adminID " +user.getUsername());
                                		out.print("____________adminID " +user.getRoles().get(0).getRole_name() +"<br/>");
                                        %>
<%--                                         <sec:authorize access="isAuthenticated()">Logout</sec:authorize> --%>
<%--                                        <sec:authorize access="isAuthenticated()">Logout</sec:authorize>  --%>
                                        <sec:authorize access="hasAnyRole('ADMIN' , 'USER')">ROLE ADMIN</sec:authorize>
                                        <sec:authorize access="hasRole('USER')">ROLE USER</sec:authorize>
                                         <sec:authorize access="hasRole('ADMIN')">ROLE USER</sec:authorize>
                                        <sec:authorize access="isAnonymous()">Login</sec:authorize>
                                        
                                        <sec:authorize access="hasAnyRole('ADMIN' , 'USER')" var="isAdmin" />
                                        <c:if test="${isAdmin eq true}"> True </c:if>
                                        
                                        <script type="text/javascript">
                                        	if('${isAdmin}' == 'true'){
                                        		alert("True");
                                        	}
                                        </script> --%>
</body>
</html>