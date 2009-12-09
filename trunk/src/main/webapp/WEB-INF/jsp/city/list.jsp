<%@ include file="/templates/header.jsp" %>

<div class="formWrap">


<display:table id="list" name="${citiesList}" requestURI="/city/list" >
	<display:column property="id" sortable="true"></display:column>
	<display:column property="name" sortable="true" ></display:column>
	<display:column><a href='<c:url value="/city/${list.id}" />'>Visualizar</a></display:column>
</display:table>

<br>

	<a href="<c:url value="/city/create" />">Adicionar</a>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>