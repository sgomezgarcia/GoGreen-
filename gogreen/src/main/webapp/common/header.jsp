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
    
%>
<header id="main-header" class="py-2 bg-success text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6"><h1><i class="fas fa-leaf"></i> Productos GoGreen</h1></div>
        </div>
        
    </div>
</header>