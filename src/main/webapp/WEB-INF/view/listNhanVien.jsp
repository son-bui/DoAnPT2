<%-- 
    Document   : listNhanVien
    Created on : Jun 5, 2021, 12:15:45 PM
    Author     : pmtu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="page/navigation.jsp"/>
            <h1>Danh sach nhan vien</h1>
            <table border="1" cellspacing="0" cellpadding="0">
                <th>Manv</th>
                <th>Hoten</th>
                <th>Diachi</th>
                <th>DienThoai</th>

                <c:forEach var="nv" items="${list}">
                    <tr>
                        <td> ${nv.manv} </td>
                        <td> ${nv.hoten} </td>
                        <td> ${nv.diachi} </td>
                        <td> ${nv.dienthoai} </td>
                        <td><a href="./edit.html?manv=${nv.manv}">Edit</a></td>
                        <td><a href="./delete.html?manv=${nv.manv}" onclick="return confirm('Ban co chac chan muon xoa nhan vien?')">Delete</a> </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="./add.html">Them nhan vien</a>
                    <div th:replace="~{page/footer :: footer}"></div>

            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
