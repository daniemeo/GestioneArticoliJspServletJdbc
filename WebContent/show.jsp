<%@page import="it.gestionearticoli.model.Articolo"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test = "${sessionScope.utente == null }"> 
 <c:redirect url= "index.jsp"/>
 </c:if>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="./header.jsp" />
	<title>Visualizza elemento</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="./navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio
		    </div>
		    
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Id articolo:</dt>
				  <dd class="col-sm-9"><c:out value="${requestScope.articoloPerShow.id}"></c:out></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Codice:</dt>
				  <dd class="col-sm-9"><c:out value="${requestScope.articoloPerShow.codice}"></c:out></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Descrizione</dt>
				  <dd class="col-sm-9"><c:out value="${requestScope.articoloPerShow.descrizione}"></c:out></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Prezzo:</dt>
				  <dd class="col-sm-9"><c:out value="${requestScope.articoloPerShow.prezzo}"></c:out></dd>
		    	</dl>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Categoria:</dt>
				  <dd class="col-sm-9"><c:out value="${requestScope.articoloPerShow.categoria}"></c:out></dd>
		    	</dl>
		    	
		    	
		    	
		    </div>
		    
		    <div class='card-footer'>
		        <a href="${pageContext.request.contextPath}/ListArticoliServlet"
		         class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
		    </div>
		</div>	
	