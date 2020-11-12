<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
   <jsp:include page="./header.jsp" />

 <title>login</title>
  <link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>
 <main role="main">
     <div class='card'>
		 <div class='card-header'>
		       Inserisci le tue credenziali
		</div>
 
	  <!-- Main jumbotron for a primary marketing message or call to action -->
	 
	  <div class='card-body' >
	    <div class="container">
	      <form action="LoginServlet" method="post" class="needs-validation" novalidate>
	         <div class="form-row">
	           <div class="form-group col-md-6">
	             <label>Username: <span class="text-danger"></span></label>
		         <input type="text" name="username" id="nome" class="form-control mr-sm-2" placeholder="Username" required>
	             <div class="invalid-feedback">
                    Attenzione! Devi inserire il tuo username
                 </div>
               </div>
	        <br>
	        <div class="form-group col-md-6">
					<label>Password: <span class="text-danger">*</span></label>
					<input type="password" name="password" id="password" class="form-control mr-sm-2" placeholder="password" required>
					<div class="invalid-feedback">
                          Attenzione! Devi inserire la password
                     </div>
			</div>
			
	        <input type="submit" value="Accedi">
	         </div>
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
		
</main>	

 
	
</body>
</html>