<%@ include file="/templates/header.jsp"%>

<div id="formWrap">
<fieldset>
<legend>Atualizar Prestador de Servi�os - Pessoa Fisica</legend>

<form action="<c:url value="/serviceProviderIndividual" />" name="showForm" method="post">
	<input type="hidden" name="person.id" value="${person.id}" ></input>
	<input type="hidden" name="address.id" value="${address.id}" ></input>
	<input type="hidden" name="serviceProvider.id" value="${serviceProvider.id}" ></input>
	<input type="hidden" name="individual.id" value="${individual.id}" ></input>
	
	<fieldset>
	<legend>Dados Pessoais</legend>
	
		<label for="name">Nome:</label>
		<input type="text" id="name" name="person.name" value="${person.name}" /> 
		<br>
		<label for="email">Email:</label> 
		<input type="text" id="email" name="person.email" value="${person.email}" /> 
		<br>
		<label for="password">Senha:</label> 
		<input type="password" id="password" name="person.password" value="${person.password}" /> 
		<br>
		<label for="phone">Telefone:</label> 
		<input type="text" id="phone" name="person.phone" value="${person.phone}" /> 
		<br>
		
		<label for="cell">Celular:</label> 
		<input type="text" id="cell" name="person.cell" value="${person.cell}" /> 
		<br>
	</fieldset>
	
	<fieldset>
		<legend>Dados da Representa��o</legend>
		<label for="cpf">CPF:</label> 
		<input type="text" id="cpf" name="individual.cpf" value="${individual.cpf}" /> 
		<br>
		<label for="fantasyName">Nome Fantasia:</label> 
		<input type="text" id="fantasyName" name="serviceProvider.fantasyName" value="${serviceProvider.fantasyName}" /> 
		<br>
	</fieldset>

	<fieldset>
		<legend>Endere�o</legend>
		
		<label for="street">Endere�o:</label> 
		<input type="text" id="street" name="address.street" value="${address.street}" /> 
		<br>
		
		<label for="number">Numero:</label> 
		<input type="text" id="number" name="address.number" value="${address.number}" /> 
		<br>
		
		<label for="complement">Complemento:</label> 
		<input type="text" id="complement" name="address.complement" value="${address.complement}" /> 
		<br>
		
		<label for="district">Bairro:</label> 
		<input type="text" id="street" name="address.district" value="${address.district}" /> 
		<br>
		
		<label for="zipCode">CEP:</label> 
		<input type="text" id="zypCode" name="address.zipCode" value="${address.zipCode}" /> 
		<br>
		<label for="city">Cidade:</label>
		<select name="address.city.id">
			<c:forEach var="dropCity" items="${cities}">
				<option value="${dropCity.id}">${dropCity.name} </option>
			</c:forEach>
		</select>

	</fieldset> 
	<br>
		<button type="submit" name="_method" value="GET">Cancelar</button>
		<button type="submit" name="_method" value="PUT"> Atualizar </button>
</form>
</fieldset>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>