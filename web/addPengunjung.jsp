<%-- 
    Document   : AddPengunjung
    Created on : Jul 9, 2018, 8:26:14 PM
    Author     : HP MINI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model_pengunjung.pengunjung" %>
<%@page import="model_pengunjung.pengunjungHome" %>

<%
    String uname = request.getParameter("uname");
    String password = request.getParameter("password");
    String nama = request.getParameter("nama");
    String alamat = request.getParameter("alamat");
    String email = request.getParameter("email");
    String nohp = request.getParameter("nohp");

    pengunjung pgj = new pengunjung();
    pgj.setUname(uname);
    pgj.setPassword(password);
    pgj.setNama(nama);
    pgj.setAlamat(alamat);
    pgj.setEmail(email);
    pgj.setNohp(nohp);
    request.setAttribute("dataPgj", pgj);

    pengunjungHome pengunjungBean = new pengunjungHome();
    

    if (pengunjungBean.create(pgj) == true) {
        %>
        <jsp:forward page="success.jsp"/>
        <%
    } else {
        %>
        <jsp:forward page="fail.jsp"/>
        <%
    }
%>
