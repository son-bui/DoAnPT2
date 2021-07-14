<%-- 
    Document   : listMuaHang
    Created on : Jul 12, 2021, 2:47:33 PM
    Author     : Trung
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
                        <h5 class="font-weight-bold">Danh sách Giỏ hàng</h5>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Tên sp</th>						
                                    <th>Số lượng</th>
                                    <th>Giảm giá</th>
                                    <th>Khuyến mãi</th>
                                    <th>Tổng</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${list}">
                                    <tr>
                                        <td>${item.name}</td>
                                        <td>${item.quantity}</td>
                                        <td>${item.discount}%</td>                        
                                        <td><del class="text-error">${item.totalPrice}</del></td>
                                        <td>${item.afterDiscount}</td>
                                        <td>
                                            <a href="./giohang/delete.html?id=${item.prodId}" class="delete" title="Delete" data-
                                               toggle="tooltip">Xóa</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <form action="./thanhtoan.html" method="POST">
                                <div class="d-flex">
                                    <select class="form-control mb-2" style="width: 50%;" id="id" name="id">
                                        <c:forEach var="kh" items="${lstcus}">
                                            <option value="${kh.id}" selected>${kh.tenKh}</option>                                      
                                        </c:forEach>
                                    </select>
                                    <!--<input href="./thanhtoan.html" class="btn btn-sm btn-primary mb-2">Thanh toán</a>-->
                                    <input type="submit" style="height: 38px;" class="btn btn-primary" value="Thanh toán"/>
                                </div>
                            </form>
                            <a href="./giohang/clear.html" style="" class="btn btn-sm btn-primary mb-2 mr-2">Xóa tất cả</a>

                        </table>
                        <div class="clearfix"  style="float: right;">
                            <ul class="pagination">
                                <li class="page-item"><b>Tổng tiền: ${totalprice}</b></li>
                            </ul>
                        </div>
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
