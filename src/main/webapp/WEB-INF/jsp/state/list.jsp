<%@ include file="/templates/header.jsp" %>

<div class="formWrap">


<display:table id="stateList" name="${states}" requestURI="/state/list" >
	<display:column property="id" sortable="true"></display:column>
	<display:column property="name" sortable="true" ></display:column>
	<display:column property="uf" sortable="true" ></display:column>
	<display:column><a href='<c:url value="/state/${stateList.id}" />'>Visualizar</a></display:column>
</display:table>

<br>

	<a href="<c:url value="/state/create" />">Adicionar</a>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>