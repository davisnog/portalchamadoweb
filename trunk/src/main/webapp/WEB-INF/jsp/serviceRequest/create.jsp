
<%@ include file="/templates/header.jsp" %>

<div id="formWrap">
<fieldset>
<legend>Solicitar servi�o</legend>

<form action="<c:url value="/serviceRequest" />" name="createForm" method="post">
		
		<input type="hidden" name="service.serviceProvider.id" value="${service.serviceProvider.id}" />
		
		<label for="name">Empresa:</label> 
		<input type="text" id="name" name="service.serviceProvider.fantasyName" value="${service.serviceProvider.fantasyName}" readonly="readonly" />
		<br>
		<label for="serviceDesc">Servi�o solicitado:</label> 
		<input type="text" id="serviceDesc" name="service.description" value="${service.description}" readonly="readonly"/>
		<br>
		
		<label for="description">Descri��o da Solicia��o:</label>
		<textarea id="description" rows="5" cols="20" name="serviceRequest.description" value="${serviceRequest.description}">

		</textarea>
		
		<br>
		<button type="submit" name="_method" value="GET">Cancelar</button>
		<button type="submit" name="_method" value="PUT"> Solicitar servi�o </button>
</form>
</fieldset>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>