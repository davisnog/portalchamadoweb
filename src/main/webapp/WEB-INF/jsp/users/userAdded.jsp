<%@ include file="/templates/header.jsp" %> 
<div class="formWrap">
<h1>${user.name}: <fmt:message key="user_added"/></h1>
<hr/>
<a href="<c:url value="/" />" id="index"><fmt:message key="login_now"/></a>
</div>
<%@ include file="/templates/footer.jsp" %> 