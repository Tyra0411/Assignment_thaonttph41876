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
<h2 class="text-center">
    Danh Sách Sản Phẩm
</h2>
<div class="text-end my-3">
    <a href="/san-pham/create" class="btn btn-primary">
        Add
    </a>
</div>
<form action="/san-pham/search" method="get" class="mb-3">
    <div class="input-group">
        <input type="text" class="form-control" placeholder="Nhập tên sản phẩm" name="keyword"  value="${keyword}">
        <button type="submit" class="btn btn-info">Search</button>
    </div>
</form>
<table class="table table-bordered mt-3">
    <thead>
    <th>ID</th>
    <th>Mã</th>
    <th>Tên</th>
    <th>Trạng thái</th>
    <th>Hoạt động</th>
    </thead>
    <tbody>
    <c:forEach items="${data.content}" var="sp">
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
    <nav aria-label="Page navigation" class="mt-3">
        <ul class="pagination justify-content-center">
            <c:if test="${currentPage > 0}">
                <li class="page-item">
                    <a class="page-link" href="/san-pham/index?page=0&size=${data.size}" aria-label="First">
                        <span aria-hidden="true">&laquo;&laquo; First</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/san-pham/index?page=${currentPage - 1}&size=${data.size}" aria-label="Previous">
                        <span aria-hidden="true">&laquo; Previous</span>
                    </a>
                </li>
            </c:if>
            <li class="page-item disabled">
                <a class="page-link" href="#">Page ${currentPage + 1} of ${totalPages}</a>
            </li>
            <c:if test="${currentPage < totalPages - 1}">
                <li class="page-item">
                    <a class="page-link" href="/san-pham/index?page=${currentPage + 1}&size=${data.size}" aria-label="Next">
                        <span aria-hidden="true">Next &raquo;</span>
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="/san-pham/index?page=${totalPages - 1}&size=${data.size}" aria-label="Last">
                        <span aria-hidden="true">Last &raquo;&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>






<%--<div class="d-flex justify-content-center">--%>
<%--    <nav aria-label="Page navigation">--%>
<%--        <ul class="pagination">--%>
<%--            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">--%>
<%--                <a class="page-link" href="/san-pham/search?keyword=${keyword}&page=${currentPage - 1}&size=${size}" tabindex="-1" aria-disabled="${currentPage == 1}">Previous</a>--%>
<%--            </li>--%>
<%--            <c:forEach begin="1" end="${totalPages}" var="pageNum">--%>
<%--                <li class="page-item ${pageNum == currentPage ? 'active' : ''}">--%>
<%--                    <a class="page-link" href="/san-pham/search?keyword=${keyword}&page=${pageNum}&size=${size}">${pageNum}</a>--%>
<%--                </li>--%>
<%--            </c:forEach>--%>
<%--            <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">--%>
<%--                <a class="page-link" href="/san-pham/search?keyword=${keyword}&page=${currentPage + 1}&size=${size}">Next</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </nav>--%>
<%--</div>--%>

</body>
</html>