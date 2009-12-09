
<%@ include file="/templates/header.jsp" %>

<div id="formWrap">
<fieldset>
<legend>Pesquisar servi�os</legend>

<form action="<c:url value="/serviceRequest" />" name="searchForm" method="post">
		
		<label for="serviceDesc">Descri��o:</label> 
		<input type="text" id="serviceDesc" name="service.description" value="${service.description}" />
		<br>
		
		<button type="submit" >Pesquisar</button>
</form>
</fieldset>
</div>	
	
	<h2>Servi�os</h2>
		
		<display:table id="list" name="${services}" requestURI="/serviceRequest/list" >
			<display:column property="description" ></display:column>
			<display:column property="value" title="Valor" ></display:column>
			<display:column property="serviceProvider.fantasyName" title="Prestador de Servi�o" ></display:column>
			<display:column><a href='<c:url value="/serviceRequest/${list.id}" />'>Selecionar</a></display:column>
		</display:table>
	
<jsp:include page="/templates/footer.jsp"></jsp:include>