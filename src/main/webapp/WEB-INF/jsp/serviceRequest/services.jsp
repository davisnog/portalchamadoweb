
<%@ include file="/templates/header.jsp" %>

<div id="formWrap">
<fieldset>
<legend>Pesquisar serviços</legend>

<form action="<c:url value="/serviceRequest" />" name="searchForm" method="post">
		
		<label for="serviceDesc">Descrição:</label> 
		<input type="text" id="serviceDesc" name="service.description" value="${service.description}" />
		<br>
		
		<button type="submit" >Pesquisar</button>
</form>
</fieldset>
</div>	
	
	<h2>Serviços</h2>
		
		<display:table id="list" name="${services}" requestURI="/serviceRequest/list" >
			<display:column property="description" ></display:column>
			<display:column property="value" title="Valor" ></display:column>
			<display:column property="serviceProvider.fantasyName" title="Prestador de Serviço" ></display:column>
			<display:column><a href='<c:url value="/serviceRequest/${list.id}" />'>Selecionar</a></display:column>
		</display:table>
	
<jsp:include page="/templates/footer.jsp"></jsp:include>