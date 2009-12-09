
<%@ include file="/templates/header.jsp" %>

<div id="formWrap">
<fieldset>
<legend>Atualizar Cidade</legend>
<form action="<c:url value="/state" />" name="editForm" method="post">
		
		<input type="hidden" name="state.id" value="${state.id}" />
		<label for="name">Nome:</label>
		<input type="text" id="name" name="state.name" value="${state.name}"/>
		<br>
		<label for="uf">UF: </label>
		<input type="text" id="uf" name="state.uf" value="${state.uf}" />
		<br>
		
		<button type="submit" name="_method" value="GET">Cancelar</button>
		<button type="submit" name="_method" value="DELETE">Deletar</button>
		<button type="submit" name="_method" value="PUT"> Atualizar </button>
</form>
</fieldset>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>