<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html >
			   		<li class="">
						<a href="#">
							<span class="menu-left"></span>
							<span class="menu-mid">Menu</span>
							<span class="menu-right"></span>
						</a>
			   			<div class="sub">
			   				<ul>
			   					<c:if test="${not empty corporation}">
			   					<li>
									<a href='<c:url value="/service"/>'>Serviços</a>
								</li>
								<li>
									<a href='<c:url value="/serviceProviderCorporation/${userInfo.user.id}"/>'>Atualizar dados</a>
								</li>
								</c:if>
								
								<c:if test="${not empty individual}">
								<li>
									<a href='<c:url value="/service"/>'>Serviços</a>
								</li>
								<li>
									<a href='<c:url value="/serviceProviderIndividual/${userInfo.user.id}"/>'>Atualizar dados</a>
								</li>
								</c:if>
								
			   				</ul>
			   				<div class="btm-bg"></div>
			   			</div>
			   		</li>
</html>

    