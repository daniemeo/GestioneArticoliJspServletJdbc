<%@page import="it.gestionearticoli.model.Articolo"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<c:if test = "${sessionScope.utente == null }"> 
 <c:redirect url= "index.jsp"/>
 </c:if>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="./header.jsp" />
	<title>Pagina dei risultati</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="./navbar.jsp" />
	
	<main role="main" class="container">
	    
	    <div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	
		<div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none': ''}" role="alert">
		  ${successMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
		  Esempio di operazione fallita!
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
		  Aggiungere d-none nelle class per non far apparire
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Lista dei risultati</h5> 
		    </div>
		    <div class='card-body'>
		        <c:if test="${sessionScope.utente.ruolo=='admin' || sessionScope.utente.ruolo=='operatore' }">
		    	<a class="btn btn-primary " href="PrepareInsertArticoloServlet">Add New</a>
		        </c:if>
		        <div class='table-responsive'>
		            <table class='table table-striped ' >
		                <thead>
		                    <tr>
		                        <th>Id</th>
		                        <th>Codice</th>
		                        <th>Descrizione</th>
		                        <th>Prezzo</th>
		                        <th>Categoria</th>
		                        <th>Azioni</th>
		                    </tr>
		                </thead>
		                <tbody>
		                	
		                		
		                		<c:forEach items = "${requestScope.listaArticoliAttribute }" var= "articolo">
		                		<tr >
		                		 <td><c:out value="${articolo.id}"> </c:out></td>
		                        <td><c:out value="${articolo.codice}"></c:out></td>
		                        <td><c:out value="${articolo.descrizione}"></c:out></td>
		                        <td><c:out value= "${articolo.prezzo}"></c:out></td>
		                        <td><c:out value= "${articolo.categoria}"></c:out></td>
		                        <td>
									<a class="btn  btn-sm btn-outline-secondary" href="visualizzaServlet?idDaInviareComeParametro=${articolo.id}"> Visualizza</a>
									<c:if test="${sessionScope.utente.ruolo=='admin' || sessionScope.utente.ruolo=='operatore' }">
									<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="prepareUpdateServlet?idDaInviareExecuteUpdate=${articolo.id}">Edit</a>
									</c:if>
									<c:if test="${sessionScope.utente.ruolo=='admin'}">
									<a class="btn btn-outline-danger btn-sm" href="deleteServlet?idDaInviareComeParametro=${articolo.id}">Delete</a>
									</c:if>
								</td>
		                		</tr>
		                		
		                		
		                		</c:forEach>
		                    
		                       
		                  
		                </tbody>
		            </table>
		        </div>
		   
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	
	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="./footer.jsp" />
	
</body>
</html>