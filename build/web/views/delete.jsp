<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deletar Cliente</title>
    </head>
    <body>
        <h1>Deletar Cliente</h1>
        <p>Tem certeza de que deseja deletar o seguinte cliente?</p>
        <p>Nome: ${cliente.nome}</p>
        <p>Email: ${cliente.email}</p>
        <form action="delete" method="post">
            <input type="hidden" name="_method" value="delete"/>
            <input type="hidden" name="id" value="${cliente.id}"/>
            <input type="submit" value="Deletar"/>
        </form>
        <a href="views/read.jsp"><button>Cancelar</button></a>
    </body>
</html>
