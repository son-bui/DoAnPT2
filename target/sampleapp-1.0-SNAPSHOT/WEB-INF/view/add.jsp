<%-- 
    Document   : add
    Created on : Jun 5, 2021, 5:31:15 PM
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
        <h1>Them nhan vien</h1>
        <form action="./save.html" method="POST">
            Ho ten: <input type="text" name="hoten"/> <br/>
            Dia chi: <input type="text" name="diachi" /> <br/>
            Dien thoai: <input type="text" name="dienthoai" /> <br/>
            <input type="submit" value="Luu"/>
        </form>
    </body>
</html>
