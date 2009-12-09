
<%@ include file="/templates/header.jsp" %>

<div class="formWrap">
<form action="<c:url value="/classification" />" name="showForm" method="post">
		
		<input type="hidden" name="classification.id" value="${state.id}" />
		<label for="service">Prestador de Serviço</label>
		<select id="service" name="classification.serviceProvider.id" >
		<c:forEach var="serviceProvider" items="${servicesProvider}">
			<option value="${serviceProvider.id}">${serviceProvider.fantasyName}</option>
		</c:forEach>
		</select>
		<br>
		<label for="note">Nota</label>
		<input type="text" id="note" name="classification.note" value="${classification.note}"/>
		<br>
		<label for="observation">Descrição</label>
		<input type="text" id="observation" name="classification.observation" value="${classification.observation}" />
		<br>
		
		<button type="submit" name="_method" value="PUT"> Atualizar </button>
		<button type="submit" name="_method" value="DELETE">Deletar</button>
		<button type="submit" name="_method" value="GET">Cancelar</button>
</form>

</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>