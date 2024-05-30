<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        .navbar-nav .nav-link {
            font-size: 18px; /* Thay đổi kích thước chữ tại đây */
            /* Các thuộc tính CSS khác tùy ý */
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light mb-4">
    <div class="container-fluid">
        <ul class="navbar-nav mb-3">
<%--            <c:if test="${sessionScope.role == 'ADMIN'}">--%>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/hoa-don/index">Hóa đơn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/hdct/index">Hóa đơn chi tiết</a>
                </li>
<%--            </c:if>--%>
            <li class="nav-item">
                <a class="nav-link" href="/san-pham/index">Sản phẩm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/spct/index">Sản phẩm chi tiết</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/kich-thuoc/index">Kích thước</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/mau-sac/index">Màu sắc</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/khach-hang/index">Khách hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/nhan-vien/index">Nhân viên</a>
            </li>
        </ul>
<%--        <ul>--%>
<%--            <label>Hello: ${sessionScope.tenDangNhap}</label>--%>
<%--        </ul>--%>
<%--        <ul class="navbar-nav mb-3">--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="/auth/logout">Logout</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
    </div>
</nav>

</body>
</html>
