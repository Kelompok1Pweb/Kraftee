<%-- 
    Document   : success
    Created on : Jul 9, 2018, 7:59:36 PM
    Author     : HP MINI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="pgj" class="model_pengunjung.pengunjung"/>
    <%
        pgj=(model_pengunjung.pengunjung)request.getAttribute("dataPgj");%>
    <body>
        
        <h1>Hello <%=pgj.getNama()%> </h1>
        <h3>Kamu berhasil resgistrasi, silahkan klik link <a href="login.html"> LOGIN</a> untuk login</h3>
    </body>
</html>
