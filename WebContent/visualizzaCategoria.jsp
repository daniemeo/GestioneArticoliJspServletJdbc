<%@page import="it.gestionearticoli.model.Articolo"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<c:if test = "${sessionScope.utente == null }"> 
 <c:redirect url= "index.jsp"/>
 </c:if>
<html lang="it">
<head>
<jsp:include page="./header.jsp" />
<meta charset="ISO-8859-1">
<title>Visualizza Categoria</title>

<link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>
<jsp:include page="./navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		      Tipo Categoria: <c:out value="${requestScope.dettaglioCategoria.nome}"></c:out> 
		    </div>
		    <div class='table-responsive'>
		    	<table class='table table-striped ' >
	                <thead>
	                    <tr>
	                        
	                        <th>Codice</th>
	                        <th>Descrizione</th>
	                        <th>Prezzo</th>
	                    </tr>
	                </thead>
		            <tbody>   
		            
					    <c:forEach items="${requestScope.dettaglioCategoria.listaArticoli}" var= "articolo">
						     <tr >
						           
						           <td><c:out value="${articolo.codice}"></c:out></td>
						           <td><c:out value="${articolo.descrizione}"></c:out></td>
						           <td><c:out value="${articolo.prezzo}"></c:out></td>
						           
				                   
				             </tr>
					    </c:forEach>
				  	</tbody> 
			  	</table>
		  	</div>
	    </div>
	</main>
		    
</body>
</html>