<%@page import="it.gestionearticoli.model.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <c:if test = "${sessionScope.utente == null || sessionScope.utente == 'guest' }"> 
 <c:redirect url= "index.jsp"/>
 </c:if>
<!DOCTYPE html>
<html>
<head>
   
  <jsp:include page="./header.jsp" />
  <title>modifica Categoria</title>
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
		        <h5>modifica genere</h5> 
		    </div>
		    <div class='card-body'>
                    
                     
				
					
					

					<form method="post" action="ExecuteUpdateCategoriaServlet" novalidate="novalidate">
					<input type="hidden" value="${requestScope.descrizione.idCategoria}" name="idCategoriaDainviare">
						<div class="form-row">
						
							<div class="form-group col-md-6">
								<label>Nome <span class="text-danger"></span></label>
								<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il codice" value="${requestScope.descrizione.nome}" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Descrizione <span class="text-danger"></span></label>
								<input type="text" name="descrizione"  id="descrizione" class="form-control" placeholder="Inserire la descrizione" value="${requestScope.descrizione.descrizioneCategoria}" required>
							</div>
						</div>
					<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					

				</form>
				
				</div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="./footer.jsp" />
					

</body>
</html>