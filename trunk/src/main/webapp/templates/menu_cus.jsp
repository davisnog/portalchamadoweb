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
									<a href='<c:url value="/classification"/>'>Classificar Prestador de Servi�o</a>
								</li>
								<li>
									<a href='<c:url value="/serviceRequest"/>'>Solicitar servi�o</a>
								</li>
								<li>
									<a href='<c:url value="/serviceProviderCorporation/${userInfo.user.id}"/>'>Prestador de Servi�o - Pessoa Juridica</a>
								</li>
								<li>
									<a href='<c:url value="/serviceProviderIndividual/${userInfo.user.id}"/>'>Prestador de Servi�o - Pessoa F�sica</a>
								</li>
			   				</ul>
			   				<div class="btm-bg"></div>
			   			</div>
			   		</li>
			   		
</html>

    