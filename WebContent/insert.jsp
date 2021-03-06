<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:if test = "${sessionScope.utente == null || sessionScope.utente.ruolo == 'guest'}"> 
 <c:redirect url= "index.jsp"/>
 </c:if>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="./header.jsp" />
	<title>Inserisci nuovo</title>
	
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
		        <h5>Inserisci nuovo elemento</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteInsertArticoloServlet" class= "needs-validation" novalidate>
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Codice <span class="text-danger">*</span></label>
								<input type="text" name="codice" id="codice" class="form-control" placeholder="Inserire il codice" required>
								<div class="invalid-feedback">
                                   Attenzione! Devi inserire il codice per creare il nuovo articolo
                                 </div>
							</div>
							
							<div class="form-group col-md-6">
								<label>Descrizione <span class="text-danger">*</span></label>
								<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione" required>
								<div class="invalid-feedback">
                                   Attenzione! Devi inserire descrizione per creare il nuovo articolo
                                 </div>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-3">
								<label>Prezzo <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo" required>
								<div class="invalid-feedback">
                                   Attenzione! Devi inserire il prezzo per il nuovo articolo
                                 </div>
							</div>
							
						</div>
						<div class="form-row">	
							<div class="form-group col-md-3">
						    <label>Categoria</label>
							<select id="listaCategorieAttribute" name="listaCategorie" class="custom-select browser-default" required>	
								<option value="">- Seleziona Categoria -</option>
								<c:forEach items="${requestScope.listaCategorieAttribute}" var="categoria">
									<option value="${categoria.idCategoria}"><c:out value="${categoria.nome}"/></option>
								</c:forEach>
							</select>
							<div class="invalid-feedback"> Attenzione!!Seleziona la categoria </div>
						</div>
                      
                         </div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					

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

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="./footer.jsp" />
	
</body>
</html>