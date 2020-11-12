<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.gestionearticoli.model.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <c:if test = "${sessionScope.utente == null || sessionScope.utente.ruolo == 'guest' ||sessionScope.utente.ruolo == 'operatore'}"> 
 <c:redirect url= "index.jsp"/>
 </c:if>
<!DOCTYPE html>
<html lang="it">
<head>
   <jsp:include page="./header.jsp" />
    <title>controllo cancellazione</title>
     <link href="./assets/css/global.css" rel="stylesheet">
</head>

  <jsp:include page="./navbar.jsp" />
  <main role="main" class="container">
    <div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
 </div>
  <div class='card'>
      <div class='card-header'>
		     Controllo delete
		    </div>
     		    <div class='card-body'>
		    	  <dl class="row">
		    	
		    	   <% Categoria categoria = new Categoria();
					categoria = (Categoria)request.getAttribute("delete"); %>
			      </dl>
				</div>	
				
				<form method="post" action="ExecuteDeleteCategoriaServlet" novalidate="novalidate">
                  <input type="hidden" value="<%=categoria.getIdCategoria()%>" name="idCategoriaDainviare">
					
               <button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
                <a href="${pageContext.request.contextPath}/ListaCategorieServlet"
		         class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
	           </form>	
   </div>
</main>	
  <jsp:include page="./footer.jsp" />		
<body>

</body>
</html>