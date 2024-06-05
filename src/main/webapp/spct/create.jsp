<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Mới Sản Phẩm Chi Tiết</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-3">
    <h2 class="text-center">Thêm Mới Sản Phẩm Chi Tiết</h2>
    <form method="post" action="/spct/store">
        <div class="mt-3">
            <label class="form-label">Mã Sản Phẩm Chi Tiết:</label>
            <input type="text" class="form-control" name="maSPCT" value="${data.maSPCT}">
            <c:if test="${not empty errors['maSPCT']}">
                <small class="text-danger">${errors['maSPCT']}</small>
            </c:if>
        </div>
        <div class="mt-3">
            <label class="form-label">Sản Phẩm:</label>
            <select name="idSP" class="form-control">
                <c:forEach items="${dataSP}" var="sp">
                    <option value="${sp.id}" ${data.idSP == sp.id ? "selected" : ""}>${sp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-3">
            <label class="form-label">Kích Thước:</label>
            <select name="idKT" class="form-control">
                <c:forEach items="${dataKT}" var="kt">
                    <option value="${kt.id}" ${data.idKT == kt.id ? "selected" : ""}>${kt.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-3">
            <label class="form-label">Màu Sắc:</label>
            <select name="idMS" class="form-control">
                <c:forEach items="${dataMS}" var="ms">
                    <option value="${ms.id}" ${data.idMS == ms.id ? "selected" : ""}>${ms.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mt-3">
            <label class="form-label">Số Lượng:</label>
            <input type="number" class="form-control" name="soLuong" value="${data.soLuong}">
            <c:if test="${not empty errors['soLuong']}">
                <small class="text-danger">${errors['soLuong']}</small>
            </c:if>
        </div>
        <div class="mt-3">
            <label class="form-label">Đơn Giá:</label>
            <input type="number" class="form-control" name="donGia" value="${data.donGia}">
            <c:if test="${not empty errors['donGia']}">
                <small class="text-danger">${errors['donGia']}</small>
            </c:if>
        </div>
        <div class="mt-3">
            <label class="form-label">Trạng Thái:</label>
            <select class="form-control" name="trangThai">
                <option value="1" ${data.trangThai == 1 ? "selected" : ""}>Đang hoạt động</option>
                <option value="0" ${data.trangThai == 0 ? "selected" : ""}>Ngừng hoạt động</option>
            </select>
        </div>
        <div class="mt-3">
            <button type="submit" class="btn btn-primary">Lưu</button>
        </div>
    </form>
</div>
</body>
</html>
