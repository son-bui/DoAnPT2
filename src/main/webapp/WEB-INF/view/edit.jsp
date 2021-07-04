<%-- 
    Document   : edit
    Created on : Jun 5, 2021, 7:05:22 PM
    Author     : pmtu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cap nhat nhan vien</h1>
        <form action="./save.html" method="POST">
            <input type="hidden" name="manv" value="${nv.manv}"/>
            Ho ten: <input type="text" name="hoten" value="${nv.hoten}"/> <br/>
            Dia chi: <input type="text" name="diachi" value="${nv.diachi}" /> <br/>
            Dien thoai: <input type="text" name="dienthoai" value="${nv.dienthoai}"/> <br/>
            <input type="submit" value="Cap Nhat"/>
        </form>
    </body>
</html>
