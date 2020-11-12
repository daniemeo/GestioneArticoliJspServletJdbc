<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test = "${sessionScope.utente == null || sessionScope.utente.ruolo == 'guest' }"> 
 <c:redirect url= "index.jsp"/>
 </c:if>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./header.jsp" />
	<title>Inserisci nuova Categoria</title>
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
		        <h5>Inserisci nuova categoria</h5> 
		    </div>
		    
		     <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteInsertCategoriaServlet" class ="needs-validation" novalidate>
					
					<div class="form-row">
							<div class="form-group col-md-6">
								<label>Nome <span class="text-danger">*</span></label>
								<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome" required>
								<div class="invalid-feedback">
                                   Attenzione! Devi inserire il nome della categoria che vuoi creare
                                 </div>
							</div>
                            
                            <div class="form-group col-md-6">
								<label>Descrizione <span class="text-danger">*</span></label>
								<input type="text" name="descrizioneCat" id="descrizioneCat" class="form-control" placeholder="Inserire la descrizione" required>
								<div class="invalid-feedback">
                                   Attenzione! Devi inserire la descrizione della nuova categoria
                                 </div>
							</div>
					</div>
						
				   			<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					        <a href="${pageContext.request.contextPath}/ListaCategorieServlet"
		                        class='btn btn-outline-secondary' style='width:80px'>
		                        <i class='fa fa-chevron-left'></i> Back
		                    </a>

					</form>
					
				  <script type="text/javascript">
				  (function() {
					  'use strict';
					  window.addEventListener('load', function() {
					  
					     var forms = document.getElementsByClassName('needs-validation');
					 
					     var validation = Array.prototype.filter.call(forms, function(form) {
					       form.addEventListener('submit', function(event) {
					  		 if (form.checkValidity() === false) {
					  			event.preventDefault();
					  			event.stopPropagation();
					  		 }
					  		form.classList.add('was-validated');
					  	    }, false);
					     });
					  }, false);
					})();
				  
				  </script>
		 		</div>
			</div>
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="./footer.jsp" />
	
				   
</body>
</html>