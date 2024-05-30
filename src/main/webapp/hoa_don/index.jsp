<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../navbar.jsp" %>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-3">
<h2 class="text-center">Quản Lý Hóa Đơn</h2>
<%--<div class="text-end my-3">--%>
<%--    <a href="/hoa-don/create" class="btn btn-primary">--%>
<%--        Add--%>
<%--    </a>--%>
<%--</div>--%>

<form action="/hoa-don/search" method="GET">
    <div class="form-group">
        <label for="trangThai">Trạng thái:</label>
        <select class="form-control" id="trangThai" name="trangThai">
            <option value="">Tất cả</option>
            <option value="1" ${trangThai == 1 ? 'selected' : ''}>Đã thanh toán</option>
            <option value="0" ${trangThai == 0 ? 'selected' : ''}>Chưa thanh toán</option>
        </select>
    </div>
    <div class="mt-3 text-end">
        <button type="submit" class="btn btn-info">Search</button>
    </div>
</form>


<table class="table table-bordered mt-3">
    <thead>
    <th>ID</th>
    <th>ID nhân viên</th>
    <th>ID khách hàng</th>
    <th>Ngày mua hàng</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${data.content}" var="hd" varStatus="i">
        <tr>
            <td>${hd.id}</td>
            <td>${hd.idNhanVien}</td>
            <td>${hd.idKhachHang}</td>
            <td>${hd.ngayMuaHang}</td>
            <td>${hd.trangThai == 1 ? "Đã thanh toán" : "Chưa thanh toán"}</td>
            <td>
                <a href="/hoa-don/edit/${hd.id}" class="btn btn-success">Update</a>
<%--                <a onclick="return confirm('Ban chắc chắn muốn xóa?')" href="/hoa-don/delete/${hd.id}" class="btn btn-danger">Delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation" class="mt-3">
        <ul class="pagination justify-content-center">
            <c:if test="${currentPage > 0}">
                <li class="page-item">
                    <a class="page-link" href="/hoa-don/index?page=0&size=${data.size}" aria-label="First">
                        <span aria-hidden="true">&laquo;&laquo; First</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/hoa-don/index?page=${currentPage - 1}&size=${data.size}" aria-label="Previous">
                        <span aria-hidden="true">&laquo; Previous</span>
                    </a>
                </li>
            </c:if>
            <li class="page-item disabled">
                <a class="page-link" href="#">Page ${currentPage + 1} of ${totalPages}</a>
            </li>
            <c:if test="${currentPage < totalPages - 1}">
                <li class="page-item">
                    <a class="page-link" href="/hoa-don/index?page=${currentPage + 1}&size=${data.size}" aria-label="Next">
                        <span aria-hidden="true">Next &raquo;</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/hoa-don/index?page=${totalPages - 1}&size=${data.size}" aria-label="Last">
                        <span aria-hidden="true">Last &raquo;&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>

</body>
</html>