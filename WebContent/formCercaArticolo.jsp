<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./header.jsp" />
<meta charset="ISO-8859-1">
<title>Cerca Articolo</title>
<link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>
<jsp:include page="./navbar.jsp" />
 <main role="main" class="container">
    <div class='card'>
		    <div class='card-header'>
		        Cerca Articolo
		    </div>
		    
 
	  <!-- Main jumbotron for a primary marketing message or call to action -->
	  <div class="jumbotron" >
	    <div class="container">
	      <form action="ExecuteCercaArticoloServlet" method="post">
	        Codice:
	        <input type="text" name="codice" >
	        <br>
	        Descrizione
	        <input type="text" name="descrizione" >
	        <br>
	  
	        
	        <input type="submit" value="Cerca">
	
          </form>
	    </div>
	   
	      
	      	<div class='table-responsive'>
		    	<table class='table table-striped ' >
	                <thead>
	                    <tr>
	                        
	                        <th>Codice</th>
	                        <th>Descrizione</th>
	                        <th>Prezzo</th>
	                        <th> Categoria </th>
	                        
	                    </tr>
	                </thead>
		            <tbody>   
		            
					    <c:forEach items="${requestScope.listaArticoli}" var= "articolo">
						     <tr >
						           <td><c:out value="${articolo.codice}"></c:out></td>
						           <td><c:out value="${articolo.descrizione}"></c:out></td>
						           <td><c:out value="${articolo.prezzo}"></c:out></td>
						           <td><c:out value="${articolo.categoria.nome}"></c:out></td>
						          
						           
				                   
				             </tr>
					    </c:forEach>
				  	</tbody> 
			  	</table>
		  	</div>
	   </div>
	  </div>
		
</main>	
</body>
</html>