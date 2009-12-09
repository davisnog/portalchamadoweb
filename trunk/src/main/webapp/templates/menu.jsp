<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<c:url value="/css/menu_style.css"/>" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div class="wrapper1">
	<div class="wrapper">
		<div class="nav-wrapper">
			<div class="nav">
				<ul id="navigation">
			   		<li class="active">
						<a href="${path}">
							<span class="menu-left"></span>
							<span class="menu-mid">Home</span>
							<span class="menu-right"></span>
						</a>
					</li>
					
					<c:if test="${not empty userInfo.user}">
					
					<c:choose>
					  <c:when test="${not empty adm}">
					     <%@ include file="menu_adm.jsp" %>
					  </c:when>
					  <c:when test="${not empty ser}">
					     <%@ include file="menu_ser.jsp" %>
					  </c:when>
					  <c:when test="${not empty cus}">
					     <%@ include file="menu_cus.jsp" %>
					  </c:when>
					</c:choose> 
					
					
			   		<li class="">
						<a href="">
							<span class="menu-left"></span>
							<span class="menu-mid">Usuário: <b>${userInfo.user.name}</b></span>
							<span class="menu-right"></span>
						</a>
			   		</li>
			   		
			   		<li class="">
						<a href="${path}home/logout">
							<span class="menu-left"></span>
							<span class="menu-mid">Sair</span>
							<span class="menu-right"></span>
						</a>
			   		</li>
			   		
			   		</c:if>
			   		
			   	</ul>
			</div>
		</div>
	</div>
</div>
</body>
</html>

    