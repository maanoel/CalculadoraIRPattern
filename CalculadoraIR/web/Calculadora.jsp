<%-- 
    Document   : Calculadora
    Created on : 17/06/2017, 14:49:26
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Calculadora de Salário Líquido</title>
    </head>
    <body>
        <h1>Informe seus dados pessoais:</h1>
        <form method="post" action="CalculadoraIRServlet">
            Nome: <br>
            <input type="text" name="nome" required><br>
            Salário: <br>
            <input type="number" name="salario" required><br>
            Outros descontos: <br>
            <input type="number" name="outrosDesc"><br><br>
            <button  type="submit" class="btn btn-primary">Enviar</button>
        </form> 
    </body>
</html>
