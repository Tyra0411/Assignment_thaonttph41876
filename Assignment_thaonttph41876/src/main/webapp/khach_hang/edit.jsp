<%@page language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-3">
<h2 class="text-center">
    Quản Lý Khách Hàng
</h2>
<form action="/khach-hang/update/${data.id}" method="post">
    <div class="mt-3">
        <label class="form-label">Mã:</label>
        <input type="text" class="form-control" name="maKH" value="${data.maKH}">
    </div>
    <div class="mt-3">
        <label class="form-label">Tên:</label>
        <input type="text" class="form-control" name="ten" value="${data.ten}">
    </div>
    <div class="mt-3">
        <label class="form-label">Số điện thoại:</label>
        <input type="text" class="form-control" name="sdt" value="${data.sdt}">
    </div>
    <div class="mt-3">
        <label class="form-label">Trạng thái:</label>
        <select name="trangThai" class="form-control">
            <option value="1"
            ${data.trangThai == 1 ? "selected":""}>
                Đang hoạt động
            </option>
            <option value="0"
            ${data.trangThai == 0 ? "selected":""}>
                Ngừng hoạt động
            </option>
        </select>
    </div>
    <div class="mt-3">
        <button class="btn btn-primary">Update</button>
        <a href="/khach-hang/index" class="btn btn-success">Back</a>
    </div>
</form>
</body>
</html>