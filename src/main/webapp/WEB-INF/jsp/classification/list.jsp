<%@ include file="/templates/header.jsp" %>

<div class="formWrap">


<display:table id="list" name="${classificationsList}" requestURI="/classification/list" >
	<display:column property="id" sortable="true"></display:column>
	<display:column property="note" sortable="true" ></display:column>
	<display:column property="observation" sortable="true" ></display:column>
	<display:column><a href='<c:url value="/classification/${list.id}" />'>Visualizar</a></display:column>
</display:table>

<br>

	<a href="<c:url value="/classification/create" />">Adicionar</a>
	<a href="<c:url value="/home" />">Home</a>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>