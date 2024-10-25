<%-- 
    Document   : create
    Created on : 22 de out. de 2024, 14:36:20
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
        <h1>Criando cliente</h1>
        <form action="<%=request.getContextPath()%>/create" method="post">
            Nome: <input type="text" name="nome"/><br/>
            Email: <input type="text" name="email"/><br/>
            <input type="submit" value="Adicionar"/>
        </form>
    </body>
</html>
