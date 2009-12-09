
<%@ include file="/templates/header.jsp" %>

<div id="formWrap">
<fieldset>
<legend>Atualizar Cidade</legend>
<form action="<c:url value="/city" />" name="showForm" method="post">
		
		<label for="name">Nome:</label>
		<input type="text" id="name" name="city.name" value="${city.name}"/>
		
		<input type="hidden" name="city.id" value="${city.id}" />
		<input type="hidden" name="city.state.id" value="${city.state.id}" ></input>
		<br>
		<button type="submit" name="_method" value="GET">Cancelar</button>
		<button type="submit" name="_method" value="DELETE">Deletar</button>
		<button type="submit" name="_method" value="PUT"> Atualizar </button>
</form>
</fieldset>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>