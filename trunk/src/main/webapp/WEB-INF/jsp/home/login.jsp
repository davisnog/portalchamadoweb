
<%@ include file="/templates/header.jsp" %> 

<div id="formWrap">

<form action="<c:url value="/home/login"/>" name="loginForm" method="post">
	<fieldset>
		<legend>Efetuar Login</legend>
		<label for="email">Email:</label>
		<input type="text" name="email" id="email" />	
		<label for="password">Senha:</label>
		<input type="password" name="password" id="password"/>
		<br>
		<button type="submit" id="submit">Entrar</button>
	</fieldset>
</form>

<form action="<c:url value="/users" />" name="registerForm" method="post">
	<fieldset>
		<legend>Cadastrar Usuário</legend>
		<label for="user.name">Nome:</label>
		<input type="text" name="user.name" value="${user.name}"/>
		<label for="user.email">Email:</label>
		<input type="text" name="user.email" value="${user.email}"/>
		<label for="user.password">Senha:</label>
		<input type="password" name="user.password" value="${user.password }"/>
		<br>
		<button type="submit" id="user.submit">Cadastrar</button>
	</fieldset>
</form>
</div>


<%@ include file="/templates/footer.jsp" %> 