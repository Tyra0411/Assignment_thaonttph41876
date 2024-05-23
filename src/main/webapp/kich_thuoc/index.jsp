<%@ page language="java" pageEncoding="UTF-8" %>
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
<h2 class="text-center">Quản Lý Kích Thước</h2>
<div class="text-end mt-3">
    <a href="${pageContext.request.contextPath}/kich-thuoc/create" class="btn btn-primary">Add</a>
</div>
<div class="my-3">
    <form method="get" action="${pageContext.request.contextPath}/kich-thuoc/search" class="d-flex">
        <div class="input-group">
            <input type="text" name="name" class="form-control" placeholder="Nhập tên kích thước">
            <button type="submit" class="btn btn-info">Tìm kiếm</button>
        </div>
    </form>
</div>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng thái</th>
        <th>Hoạt động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="kt" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${kt.id}</td>
            <td>${kt.ma}</td>
            <td>${kt.ten}</td>
            <td>${kt.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
            <td>
                <a href="${pageContext.request.contextPath}/kich-thuoc/edit/${kt.id}" class="btn btn-success">Update</a>
                <a onclick="return confirm('Bạn chắc chắn muốn xóa?')" href="${pageContext.request.contextPath}/kich-thuoc/delete/${kt.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Phân trang -->
<div class="d-flex justify-content-center">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                <a class="page-link" href="${pageContext.request.contextPath}/kich-thuoc/index?page=${currentPage - 1}" tabindex="-1" aria-disabled="${currentPage == 1}">Previous</a>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="pageNum">
                <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                    <a class="page-link" href="${pageContext.request.contextPath}/kich-thuoc/index?page=${pageNum}">${pageNum}</a>
                </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                <a class="page-link" href="${pageContext.request.contextPath}/kich-thuoc/index?page=${currentPage + 1}">Next</a>
            </li>
        </ul>
    </nav>
</div>

</body>
</html>
