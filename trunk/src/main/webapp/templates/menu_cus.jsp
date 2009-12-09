<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html >
			   		<li class="">
						<a href="#">
							<span class="menu-left"></span>
							<span class="menu-mid">Menu</span>
							<span class="menu-right"></span>
						</a>
			   			<div class="sub">
			   				<ul>
			   					<li>
									<a href='<c:url value="/classification"/>'>Classificar Prestador de Serviço</a>
								</li>
								<li>
									<a href='<c:url value="/serviceRequest"/>'>Solicitar serviço</a>
								</li>
								<li>
									<a href='<c:url value="/serviceProviderCorporation/${userInfo.user.id}"/>'>Prestador de Serviço - Pessoa Juridica</a>
								</li>
								<li>
									<a href='<c:url value="/serviceProviderIndividual/${userInfo.user.id}"/>'>Prestador de Serviço - Pessoa Física</a>
								</li>
			   				</ul>
			   				<div class="btm-bg"></div>
			   			</div>
			   		</li>
			   		
</html>

    