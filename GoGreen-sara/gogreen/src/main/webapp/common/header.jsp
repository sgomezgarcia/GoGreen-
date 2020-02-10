<%@ page import="com.gogreen.dto.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate"%>
<%
    String nomWeb = "GoGreen";       
    
    //Coordenades localització
    float x = 167.23f;
    float y = 168.23f; 
    
    // Recuperan usuari de la sessió si existeix 
    User usuari = (User) session.getAttribute("user");
    request.setAttribute("usuari", usuari);
    
    // Recuperam genere per configurar el menú actiu

%>
<header id="main-header" class="py-2 bg-success text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6"><h1><i class="fas fa-leaf"></i> Productos GoGreen</h1></div>
            <div class="col-3 text-right">
				
					<c:if test = "${usuari==null}">
						<p><i class="fas fa-user-lock"></i><a href="login/user-login.jsp">LOG IN</a></p>
			        </c:if>
			        <c:if test = "${usuari!=null}">
				        <c:out value="${usuari.nom}"/>
			        </c:if>
			        
					<c:set var="avui" value="<%=new java.util.Date()%>" />
			        <p>Avui:
			        <fmt:formatDate pattern = "dd-MM-yyyy" value = "${avui}" />
         			</p>
			        
				</div>
        </div>
        
    </div>
</header>