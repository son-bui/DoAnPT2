<%-- 
    Document   : listKhachHang
    Created on : Jun 28, 2021, 5:40:34 PM
    Author     : Son_Bui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

        <style>
            li:hover {
                background-color: #16232D;
            }

            * {
                box-sizing: border-box;
            }

            .card {
                border: none;
            }
        </style>
        <title>Danh sách sản phẩm</title>
    </head>
    <body>
        <div style=" height: 100vh;" class="d-flex">
            <jsp:include page="/WEB-INF/view/page/navigation.jsp"/>

            <div style="width: 75%;" class="">
                <div class="card">
                    <div class="card-header">
                        <h5 class="font-weight-bold">Danh sách sản phẩm</h5>
                    </div>
                    <div class="card-body">
                        <a href="./add.html" class="btn btn-sm btn-primary mb-2">Thêm</a>
                        <table class="table table-stripe table-bordered">
                            <thead>
                                <tr>
                                    <th scope="col">Tên sản phẩm</th>
                                    <th scope="col">Quy cách</th>
                                    <th scope="col">Giá gốc</th>
                                    <th scope="col">Thao tác</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <c:forEach var="sp" items="${list}">
                                    <tr>
                                        <td> ${sp.tensp} </td>
                                        <td> ${sp.quycach} </td>
                                        <td> ${sp.gia} </td>
                                        <td>
                                            <a href="./edit.html?id=${sp.id}" class="btn btn-sm btn-success">Sửa</a>
                                            <a href="./delete.html?id=${sp.id}" class="btn btn-sm btn-danger" onclick="return confirm('Bạn có muốn xóa sản phẩm?')">Xóa</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
        </script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
        </script>
    </body>
</html>
