<%@ include file="/templates/header.jsp" %>

<div id="formWrap">
<fieldset>
<legend>Classificar Prestadores de Serviço</legend>
<form action="<c:url value="/classification" />" name="createForm" method="post">
		
		<label for="service">Prestador:</label>
		<select id="service" name="classification.serviceProvider.id" >
		<c:forEach var="serviceProvider" items="${servicesProvider}">
			<option value="${serviceProvider.id}">${serviceProvider.fantasyName}</option>
		</c:forEach>
		</select>
		<br>
		<label for="note">Nota:</label>
		<input type="text" id="note" name="classification.note" value="${classification.note}"/>
		<br>
		<label for="observation">Descrição:</label>
		<input type="text" id="observation" name="classification.observation" value="${classification.observation}" />
		<br>
		
		<button type="submit" name="_method" value="GET">Cancelar</button>
		<button type="submit" > Inserir </button>
	
</form>

</fieldset>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>