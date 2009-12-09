<%@ include file="/templates/header.jsp"%>

<div id="formWrap">
<fieldset>
<legend>Cadastrar Prestador de Serviços - Pessoa Jurídica</legend>

<form action="<c:url value="/serviceProviderCorporation" />" name="createForm" method="post">
	
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
		<legend>Dados da Empresa</legend>
		<label for="cnpj">CNPJ:</label> 
		<input type="text" id="cnpj" name="corporation.cnpj" value="${corporation.cnpj}" /> 
		<br>
		<label for="corporationName">Nome da Empresa:</label> 
		<input type="text" id="corporationName" name="corporation.corporationName" value="${corporation.corporationName}" />
		<br>
		<label for="fantasyName">Nome Fantasia:</label> 
		<input type="text" id="fantasyName" name="serviceProvider.fantasyName" value="${serviceProvider.fantasyName}" /> 
		<br>
		<label for="municipalRegistration">Inscrição Municipal:</label> 
		<input type="text" id="municipalRegistration" name="corporation.municipalRegistration" value="${corporation.municipalRegistration}" /> 
		<br>
		<label for="stateRegistration">Inscrição Estadual:</label> 
		<input type="text" id="stateRegistration" name="corporation.stateRegistration" value="${corporation.stateRegistration}" /> 
		<br>
	</fieldset>

	<fieldset>
		<legend>Endereço</legend>
		
		<label for="street">Endereço:</label> 
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
		<label for="city">Estado:</label>
		<select name="address.city.id">
			<c:forEach var="dropCity" items="${cities}">
				<option value="${dropCity.id}">${dropCity.name} </option>
			</c:forEach>
		</select>

	</fieldset> 
	<br>
	
	<button type="submit" name="_method" value="GET">Cancelar</button>
	<button type="submit" > Inserir </button>
</form>
</fieldset>
</div>
<jsp:include page="/templates/footer.jsp"></jsp:include>