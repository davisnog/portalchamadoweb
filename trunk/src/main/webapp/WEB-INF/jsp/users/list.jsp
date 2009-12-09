<%@ include file="/templates/header.jsp" %> 

<div class="formWrap">
<table>
	<tr><td align="right"><a href="<c:url value="/logout" />"><fmt:message key="logout"/></a></td></tr>
</table>
</div>

<div class="formWrap">
<h1><fmt:message key="list_users"/></h1>
<hr/>
<table>
<c:forEach var="user" items="${users}">
	<tr>
		<td><a href="<c:url value="/users/${user.login}" />"><fmt:message key="view"/></a></td>
		<td>${user.name}</td>
	</tr>
</c:forEach>
</table>
</div>

<%@ include file="/templates/footer.jsp" %> 