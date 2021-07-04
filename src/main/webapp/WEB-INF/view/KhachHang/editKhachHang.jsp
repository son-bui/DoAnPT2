<%-- 
    Document   : addKhachHang
    Created on : Jun 28, 2021, 5:55:34 PM
    Author     : Son_Bui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            .form-control {
                width: 50%;
            }

            .card {
                border: none;
            }
        </style>
        <title>Thêm khách hàng</title>
    </head>
    <body>

        <div style=" height: 100vh;" class="d-flex">
            <jsp:include page="/WEB-INF/view/page/navigation.jsp"/>

            <div style="width: 75%;" class="">
                <div class="card">
                    <div class="card-header">
                        <h5 class="font-weight-bold">Sửa khách hàng</h5>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="form-group">
                                <label for="name">Tên khách hàng</label>
                                <input type="text" class="form-control" id="name" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="defaultCode">Mã khách hàng</label>
                                <input type="text" class="form-control" id="defaultCode" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="unitPrice">Điện thoại</label>
                                <input type="text" class="form-control" id="unitPrice" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="address">Địa chỉ</label>
                                <input type="text" class="form-control" id="address" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="tag">Nhãn khách hàng</label>
                                <input type="text" class="form-control" id="tag" placeholder="">
                            </div>
                            <button type="submit" class="btn btn-primary">Lưu</button>
                        </form>
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
