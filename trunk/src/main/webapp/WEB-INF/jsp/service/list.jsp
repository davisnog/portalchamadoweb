<%@ include file="/templates/header.jsp" %>

<div class="formWrap">
<fieldset>
	<legend>Lista de Serviços</legend>


<display:table id="list" name="${services}" requestURI="/service/list" >
	<display:column property="id" sortable="true"></display:column>
	<display:column property="description" sortable="true" ></display:column>
	<display:column><a href='<c:url value="/service/${list.id}" />'>Visualizar</a></display:column>
</display:table>

<br>

	<a href="<c:url value="/service/create" />">Adicionar</a>
</fieldset>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>