<%-- 
    Document   : update
    Created on : 22 de out. de 2024, 14:36:58
    Author     : T1092408
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Cliente</h1>
        <form action="<%=request.getContextPath()%>/update" method="post">
            <input type="hidden" name="_method" value="put"/>
            <input type="hidden" name="id" value="${cliente.id}"/>
            Nome: <input type="text" name="nome" value="${cliente.nome}"/><br/>
            Email: <input type="text" name="email" value="${cliente.email}"/><br/>
            <input type="submit" value="Atualizar"/>
        </form>
        <a href="views/read.jsp"><button>Voltar</button></a>
    </body>
</html>

