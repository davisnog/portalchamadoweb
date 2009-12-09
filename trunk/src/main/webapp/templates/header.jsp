<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Portal Chamado Web</title>
	<link href="<c:url value="/css/default.css"/>" rel="stylesheet" type="text/css" media="screen" />
    
</head>
<body>
	
    <c:set var="path"><c:url value="/"/></c:set>
    <div >
    	<%@ include file="menu.jsp"%>
    </div>
	
	<c:if test="${not empty notice}">
		<div id="notice">
			<p>${notice }</p>
		</div>
	</c:if>
	<div id="contentWrap">
	