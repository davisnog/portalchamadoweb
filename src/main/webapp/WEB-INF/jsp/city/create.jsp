<%@ include file="/templates/header.jsp"%>


<div id="formWrap">
<fieldset>
	<legend>Cadastro de Cidades</legend>

	<form action="<c:url value="/city" />" name="createForm" method="post">
		<label for="name">Nome:</label>
		<input type="text" id="name" name="city.name" value="${city.name}" /> 
		<br>
		<label for="state">Estado:</label> 
		<select id="state" name="city.state.id">
			<c:forEach var="dropState" items="${states}">
				<option value="${dropState.id}">${dropState.uf}</option>
			</c:forEach>
		</select> 
		<br>
		<button type="submit" name="_method" value="GET">Cancelar</button>
		<button type="submit" > Inserir </button>
	</form>
</fieldset>
</div>

<jsp:include page="/templates/footer.jsp"></jsp:include>