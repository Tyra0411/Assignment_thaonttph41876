<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-3">
<h2 class="text-center">
    Danh Sách Sản Phẩm
</h2>
<form action="/san-pham/search" method="get" class="mb-3">
    <div class="input-group">
        <input type="text" class="form-control" placeholder="Search for products..." name="keyword">
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</form>
<div class="text-end">
    <a href="/san-pham/create" class="btn btn-primary">
        Add
    </a>
</div>
<table class="table table-bordered mt-3">
    <thead>
    <th>ID</th>
    <th>Mã</th>
    <th>Tên</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="sp">
        <tr>
            <td>${sp.id}</td>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>${sp.trangThai == 1 ? "Dang hoat dong" : "Ngung hoat dong"}</td>
            <td>
                <a href="/san-pham/edit/${sp.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Ban chắc chắn muốn xóa?')" href="/san-pham/delete/${sp.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                <a class="page-link" href="/san-pham/search?keyword=${keyword}&page=${currentPage - 1}&size=${size}" tabindex="-1" aria-disabled="${currentPage == 1}">Previous</a>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="pageNum">
                <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                    <a class="page-link" href="/san-pham/search?keyword=${keyword}&page=${pageNum}&size=${size}">${pageNum}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                <a class="page-link" href="/san-pham/search?keyword=${keyword}&page=${currentPage + 1}&size=${size}">Next</a>
            </li>
        </ul>
    </nav>
</div>

</body>
</html>