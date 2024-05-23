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
    Thêm Mới Hóa Đơn Chi Tiết
</h2>
<form action="/hdct/store" method="post">
    <div class="mt-3">
        <label class="form-label">ID hóa đơn:</label>
        <select name="idHoaDon" class="form-control">
            <c:forEach items="${dataHD}" var="hd">
                <option value="${hd.id}"
                    ${data.idHoaDon==hd.id?"selected":""}>
                        ${hd.id}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="mt-3">
        <label class="form-label">ID SPCT:</label>
        <select name="idSPCT" class="form-control">
            <c:forEach items="${dataSPCT}" var="spct">
                <option value="${spct.id}"
                    ${data.idSPCT==spct.id?"selected":""}>
                        ${spct.id}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="mt-3">
        <label class="form-label">Số Lượng:</label>
        <input type="number" class="form-control" name="soLuong" value="${data.soLuong}">
        <c:if test="${not empty errors['soLuong']}">
            <small class="text-danger">
                Số Lượng phải là số nguyên > 0
            </small>
        </c:if>
    </div>
    <div class="mt-3">
        <label class="form-label">Đơn Giá:</label>
        <input type="number" class="form-control" name="donGia" value="${data.donGia}">
        <c:if test="${not empty errors['donGia']}">
            <small class="text-danger">
                Đơn giá phải là số > 100.000
            </small>
        </c:if>
    </div>
    <div class="mt-3">
        <label class="form-label">Trạng thái:</label>
        <select name="trangThai" class="form-control">
            <option value="1"
            ${data.trangThai == 1 ? "selected":""}>Đã thanh toán
            </option>
            <option value="0"
            ${data.trangThai == 0 ? "selected":""}>Chưa thanh toán
            </option>
        </select>
    </div>
    <div class="mt-3">
        <button class="btn btn-primary">Add</button>
        <a href="/hdct/index" class="btn btn-success">List</a>
    </div>
</form>
</body>
</html>