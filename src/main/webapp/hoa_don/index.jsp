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
    <c:forEach items="${data}" var="hd" varStatus="i">
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
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                <a class="page-link" href="/hoa-don/search?trangThai=${trangThai}&page=${currentPage - 1}" tabindex="-1" aria-disabled="${currentPage == 1}">Previous</a>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="pageNum">
                <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                    <a class="page-link" href="/hoa-don/search?trangThai=${trangThai}&page=${pageNum}">${pageNum}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                <a class="page-link" href="/hoa-don/search?trangThai=${trangThai}&page=${currentPage + 1}">Next</a>
            </li>
        </ul>
    </nav>
</div>


</body>
</html>