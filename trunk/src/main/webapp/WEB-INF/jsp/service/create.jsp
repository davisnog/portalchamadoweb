<%@ include file="/templates/header.jsp"%>


<div id="formWrap">
<fieldset>
	<legend>Cadastro de Serviços</legend>

	<form action="<c:url value="/service" />" name="createForm" method="post">
		<label for="name">Descrição:</label>
		<input type="text" id="description" name="service.description" value="${service.description}" /> 
		<br>
		<label for="value">Valor R$:</label> 
		<input type="text" id="value" name="service.value" value="${service.value}" ></input>
		<br>
		<button type="submit" name="_method" value="GET">Cancelar</button>
		<button type="submit" > Inserir </button>
	</form>
</fieldset>
</div>

<jsp:include page="/templates/footer.jsp"></jsp:include>