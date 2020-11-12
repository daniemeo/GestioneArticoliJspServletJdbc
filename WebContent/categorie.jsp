<%@page import="it.gestionearticoli.model.Categoria"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test = "${sessionScope.utente == null }"> 
 <c:redirect url= "index.jsp"/>
 </c:if>
 
<!DOCTYPE html>
<html lang="it">
<head>

<jsp:include page="./header.jsp" />
<title>lista categorie</title>

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
		    
		  <h5>Lista delle categorie</h5> 
		    </div>
		    <div class='card-body'>
		    <c:if test="${sessionScope.utente.ruolo=='admin' || sessionScope.utente.ruolo=='operatore' }">
		    	<a class="btn btn-primary " href="PrepareInsertCategoriaServlet">Add New</a>
		   </c:if>
		    	
		    	 <div class='table-responsive'>
		            <table class='table table-striped ' >
		                <thead>
		                    <tr>
		                        <th>Id</th>
		                        <th>Nome</th>
		                        <th>Descrizione</th>
		                    </tr>
		                </thead>
		            <tbody>   
		               <c:forEach items = "${requestScope.listaCategorieAttribute }" var= "categoria">
		                      <tr >
		                		 <td><c:out value="${categoria.idCategoria}"> </c:out></td>
		                        <td><c:out value="${categoria.nome}"></c:out></td>
		                        <td><c:out value="${categoria.descrizioneCategoria}"></c:out></td>
                                <td>
                                <a class="btn  btn-sm btn-outline-secondary" href="VisualizzaCategoria?idCategoriaDainviare=${categoria.idCategoria}"> Visualizza</a>
									<c:if test="${sessionScope.utente.ruolo =='admin' || sessionScope.utente.ruolo=='operatore' }">
									<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="prepareUpdateCategoriaServlet?idCategoriaDainviare=${categoria.idCategoria}">Edit</a>
									</c:if>
									<c:if test="${sessionScope.utente.ruolo=='admin'}">
									<a class="btn btn-outline-danger btn-sm" href="PreparedDeleteCategorieServlet?idCategoriaDainviare=${categoria.idCategoria}">Delete</a>
									</c:if>
								</td>
		                    </tr>

		               </c:forEach>
		               
                   </tbody>
                </table>
                
		                
		      </div>
		    </div>
		   </div>
	  </main>
	<jsp:include page="./footer.jsp" />   
</body>
</html>