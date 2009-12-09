
<%@ include file="/templates/header.jsp" %>

<div id="formWrap">
<fieldset>
	<legend>Cadastro de Serviços</legend>

	<form action="<c:url value="/service" />" name="editForm" method="post">
		<input type="hidden" name="service.id" value="${service.id}" ></input>
		<input type="hidden" name="service.serviceProvider.id" value="${service.serviceProvider.id}" ></input>
		
		<label for="name">Descrição:</label>
		<input type="text" id="description" name="service.description" value="${service.description}" /> 
		<br>
		<label for="value">Estado:</label> 
		<input type="text" id="value" name="service.value" value="${service.value}" ></input>
		<br>
		<button type="submit" name="_method" value="GET">Cancelar</button>
		<button type="submit" name="_method" value="DELETE">Deletar</button>
		<button type="submit" name="_method" value="PUT"> Atualizar </button>
	</form>
</fieldset>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>