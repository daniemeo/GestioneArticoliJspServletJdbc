<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.gestionearticoli.model.Articolo"%>
<!doctype html>
<c:if test = "${sessionScope.utente == null || sessionScope.utente.ruolo == 'guest'}"> 
 <c:redirect url= "index.jsp"/>
 </c:if>
<html lang="it">
<head>
	<jsp:include page="./header.jsp" />
	<title>modifica</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="./navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
			 	Operazione fallita!
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
		
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>modifica l'elemento</h5> 
		    </div>
		    <div class='card-body'>
                    
                     
					
					
					

					<form method="post" action="ExecuteUpdateServlet" novalidate="novalidate">
					<div class="form-row">
					<input type="hidden" name="articoloUpdate" id="articoloUpdate" value="${requestScope.articoloUpdate.id}" >
						
						
							<div class="form-group col-md-6">
								<label>Codice <span class="text-danger"></span></label>
								<input type="text" name="codice" id="codice" class="form-control" placeholder="Inserire il codice" value="${requestScope.articoloUpdate.codice}" required>
							</div>
							
							
							<div class="form-group col-md-6">
								<label>Descrizione <span class="text-danger"></span></label>
								<input type="text" name="descrizione"  id="descrizione" class="form-control" placeholder="Inserire la descrizione" value="${requestScope.articoloUpdate.descrizione}" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-3">
								<label>Prezzo <span class="text-danger"></span></label>
								<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo" value="${requestScope.articoloUpdate.prezzo}" required>
							</div>
							
						</div>
						<div class="form-group">
						<div class="form-group col-md-6">
						<label>Categoria</label>
							<select id="listaCategorieAttribute" name="idDaInviareExecuteUpdate" class="form-control">	
								<c:out value="${categoria.nome}"></c:out>
								<c:forEach items="${requestScope.listaCategorieAttribute}" var="categoria">
									<option value="${categoria.idCategoria}"><c:out value="${categoria.nome}"/></option>
								</c:forEach>
							</select>
						</div>
                      
                         </div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					

					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="./footer.jsp" />
	
</body>
</html>