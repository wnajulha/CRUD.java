<%-- 
    Document   : cliente
    Created on : 23 de out. de 2024, 14:53:07
    Author     : T1092408
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Detalhes do Cliente</h1>
        <p>Nome: ${cliente.getNome()}</p>
        <p>Email: ${cliente.email}</p>
        <a href="views/read.jsp"><button>Voltar</button></a>
    </body>
</html>
