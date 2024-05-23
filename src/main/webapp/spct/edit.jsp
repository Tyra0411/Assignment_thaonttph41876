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
    Chỉnh Sửa Sản Phẩm Chi Tiết
</h2>
<div>
    <form method="post" action="/spct/update/${data.id}">
        <div class="mt-3">
            <label class="form-label">ID:</label>
            <input type="text" class="form-control" name="id" value="${data.id}" disabled>
        </div>
        <div class="mt-3">
            <label class="form-label">Mã Sản Phẩm Chi Tiết:</label>
            <input type="text" class="form-control" name="maSPCT" value="${data.maSPCT}">
            <c:if test="${not empty errors['maSPCT']}">
                <small class="text-danger">
                        ${errors['maSPCT']}
                </small>
            </c:if>
        </div>
        <div class="mt-3">
            <label class="form-label">Sản Phẩm:</label>
            <select name="idSanPham" class="form-control">
                <c:forEach items="${dataSP}" var="sp">
                    <option value="${sp.id}"
                        ${data.idSanPham == sp.id ? "selected" : ""}>${sp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-3">
            <label class="form-label">Kích Thước:</label>
            <select name="idKichThuoc" class="form-control">
                <c:forEach items="${dataKT}" var="kt">
                    <option value="${kt.id}"
                        ${data.idKichThuoc == kt.id ? "selected" : ""}>${kt.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-3">
            <label class="form-label">Màu Sắc:</label>
            <select name="idMauSac" class="form-control">
                <c:forEach items="${dataMS}" var="ms">
                    <option value="${ms.id}"
                        ${data.idMauSac == ms.id ? "selected" : ""}>${ms.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-3">
            <label class="form-label">Số Lượng:</label>
            <input type="number" class="form-control" name="soLuong" value="${data.soLuong}">
            <c:if test="${not empty errors['soLuong']}">
                <small class="text-danger">
                        ${errors['soLuong']}
                </small>
            </c:if>
        </div>
        <div class="mt-3">
            <label class="form-label">Đơn Giá:</label>
            <input type="number" class="form-control" name="donGia" value="${data.donGia}">
            <c:if test="${not empty errors['donGia']}">
                <small class="text-danger">
                        ${errors['donGia']}
                </small>
            </c:if>
        </div>
        <div class="mt-3">
            <label class="form-label">Trạng thái:</label>
            <select class="form-control" name="trangThai">
                <option value="1"
                ${data.trangThai==1?"selected":""}>Đang hoạt động</option>
                <option value="0"
                ${data.trangThai==0?"selected":""}>Ngừng hoạt động</option>
            </select>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary">Update</button>
            <a href="/spct/index" class="btn btn-success">Back</a>
        </div>
    </form>
</div>
</body>
</html>
