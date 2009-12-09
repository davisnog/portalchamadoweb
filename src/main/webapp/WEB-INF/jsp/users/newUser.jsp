
<%@ include file="/templates/header.jsp" %> 

<div class="formWrap">

<form action="<c:url value="/login" />" name="registerForm" method="post">
	
		<fmt:message key="email" />
		<input type="text" name="user.email" value="${user.email }"/>
		</br>
		<fmt:message key="password" />
		<input type="password" name="user.password" value="${user.password }"/>
		</br>
		<input type="submit" value="Enviar"/>
	
</form>

</div>

<%@ include file="/templates/footer.jsp" %> 