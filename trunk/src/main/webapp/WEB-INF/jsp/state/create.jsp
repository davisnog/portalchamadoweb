<%@ include file="/templates/header.jsp" %>

<div id="formWrap">
<fieldset>
<legend>Cadastro de Cidades</legend>

<form action="<c:url value="/state" />" name="createForm" method="post">
		
		<label for="name">Nome</label>
		<input type="text" id="name" name="state.name" value="${state.name}"/>
		<br>
		<label for="uf">UF</label>
		<input type="text" id="uf" name="state.uf" value="${state.uf}" maxlength="2" />
		<br>
		
		<button type="submit" name="_method" value="GET">Cancelar</button>
		<button type="submit" > Inserir </button>
	
</form>

</fieldset>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>