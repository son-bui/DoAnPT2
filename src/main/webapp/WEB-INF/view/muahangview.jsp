<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <div class="col-sm-7">
                            <a href="./giohang.html" class="btn btn-secondary"><span>Item In Cart: ${totalItem}</span></a>					
                        </div>
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Tên sản phẩm</th>						
                                    <th>Quy cách</th>
                                    <th>Giá</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="prod" items="${list}">
                                    <tr>
                                        <td>${prod.id}</td>
                                        <td>${prod.tensp}</td>
                                        <td>${prod.quycach}</td>                        
                                        <td>${prod.gia}</td>
                                        <td>
                                            <form action="/sampleapp/muahang/add.html" method="post">
                                                <input type="hidden" name="prodId" value="${prod.id}" required>
                                                <input type="hidden" name="spec" value="${prod.quycach}" required>
                                                <input type="hidden" name="price" value="${prod.gia}" required>
                                                <input type="hidden" name="name" value="${prod.tensp}" required>
                                                <table>
                                                    <tbody>
                                                        <tr>
                                                            <td><input type="text" name="quantity" placeholder="Số lượng" required></td>
                                                            <td><input type="text" name="discount" placeholder="Giảm giá (%)" required></td>
                                                            <td><button type="submit" class="btn btn-primary" title="Add to Cart"><i class="fa fa-cart-plus"></i></button></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
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