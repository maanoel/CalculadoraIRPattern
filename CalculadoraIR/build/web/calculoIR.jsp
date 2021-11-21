<%-- 
    Document   : calculoIR
    Created on : 08/07/2017, 11:18:44
    Author     : aluno
--%>
<%
    String salario = request.getParameter("sal");
    String descIR = request.getParameter("ir");
    String descInss = request.getParameter("inss");
    String referencia = request.getParameter("ref");
    String nome = request.getParameter("nome");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado</h1>
        <table class="table">
          <thead>
            <tr>
                <th>Nome</th>
                <th>Referencia</th>
                <th>IR</th>
                <th>INSS</th>
                <th>Salário Líquido</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%=nome%></td>
                <td><%=referencia%>%</td>
                <td >R$ <%=descIR%></td>
                <td>R$ <%=descInss%></td>
                <td>R$ <%=salario%></td>
            </tr>
            </tbody>
        </table>
            
        <button  type="submit" class="btn btn-success" onclick="window.history.back();">Voltar</button>
    </body>
</html>
