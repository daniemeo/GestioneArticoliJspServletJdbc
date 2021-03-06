<!-- navbar -->
<%@page import="it.gestionearticoli.model.Utente"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-primary">

	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="home.jsp">Home</a>
          <a class="dropdown-item" href="ListArticoliServlet">Risultati</a>
          <c:if test="${sessionScope.utente.ruolo=='admin' || sessionScope.utente.ruolo=='operatore' }">
          <a class="dropdown-item" href="insert.jsp">Inserisci nuovo elemento</a>
          </c:if>
        </div>
      </li>
      <li class="nav-item active">
      <a class= "nav-link" href="#"> <c:out value="${sessionScope.utente.nome}"/>  <c:out value="${sessionScope.utente.cognome}" default="null"/>   </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="LogoutServlet"> Logout <span class="sr-only">(current)</span></a>
      </li>
      
    </ul>
   
  
   
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
