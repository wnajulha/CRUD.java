<%-- 
    Document   : read
    Created on : 22 de out. de 2024, 14:36:47
    Author     : T1092408
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cliente" class="DAO.ClienteDAO"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Clientes</h1>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="cliente" items="${cliente.getAllClientes()}">
                <tr>
                    <td>${cliente.getNome()}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/cliente?id=${cliente.getId()}"><button>Detalhes</button></a>
                        <a href="<%=request.getContextPath()%>/update?id=${cliente.getId()}"><button>Editar</button></a>
                        <a href="<%=request.getContextPath()%>/delete?id=${cliente.getId()}"><button>Deletar</button></a>
                    </td>
            </c:forEach>
                   
        </table>
        <a href="<%=request.getContextPath()%>/index.html"><button>Voltar</button></a>
    </body>
</html>
