<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./header.jsp" />
<meta charset="ISO-8859-1">
<title>Cerca Categoria</title>
<link href="./assets/css/global.css" rel="stylesheet">
</head>
<body>
 <jsp:include page="./navbar.jsp" />
 <main role="main" class="container">
    <div class='card'>
		    <div class='card-header'>
		        Cerca Categoria
		    </div>
 
	  <!-- Main jumbotron for a primary marketing message or call to action -->
	  <div class="jumbotron" >
	    <div class="container">
	      <form action="ExecuteCercaCategoriaServlet" method="post">
	      
	        Nome Categoria
	        <input type="text" name="nome" >
	        <br>
	        Descrizione
	        <input type="text" name="descrizioneCategoria" >
	        
	        <input type="submit" value="Cerca">
	
	       </form>
	        <div class='table-responsive'>
		    	<table class='table table-striped ' >
	                <thead>
	                    <tr>
	                        
	                        <th>Nome</th>
	                        <th>Descrizione</th>
	                        
	                    </tr>
	                </thead>
		            <tbody>   
		            
					    <c:forEach items="${requestScope.listaCategorie}" var= "categoria">
						     <tr >
						           
						           <td><c:out value="${categoria.nome}"></c:out></td>
						           <td><c:out value="${categoria.descrizioneCategoria}"></c:out></td>
						           
						           
				                   
				             </tr>
					    </c:forEach>
				  	</tbody> 
			  	</table>
		  	</div>
	   </div>
	  </div>
	</div>
</main>