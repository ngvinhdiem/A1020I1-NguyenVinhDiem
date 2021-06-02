
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css" />
</head>
<body>
<header>
    <%@include file="../body/header.jsp" %>
</header>

        <div align="center">
            <br><h3>Danh Sach Mat Bang:</h3><br>

            <form method="post">
                <label>
                    <span>Loai Mat Bang: </span>

                    <select class="form-control form-select" name="loaiMatBang">
                        <option value="Chia Se">Chia Se</option>
                        <option value="Tron Goi">Tron Goi</option>
                    </select>
                    <input type="submit" value="Tim kiem"><br>
                </label>
            </form>

            <form method="post" action="matbang?action=selectByTang">
                <label>
                    <span>Tang: </span>
                    <select class="form-control form-select" name="tang">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                    </select>
                    <input type="submit" value="Tim kiem"><br>
                </label>
            </form>

            <form method="post" action="matbang?action=selectByGiaThue">
                <label>
                    <span>Gia Thue: </span>
                    <input type="text" name="giaThue">
                    <input type="submit" value="Tim kiem"><br>
                </label>
            </form>

            <table id="tableMatBang" class="table table-striped table-bordered" style="width:90%">
                <thead>
                <tr>
                    <th>Ma Mat Bang</th>
                    <th>Trang Thai</th>
                    <th>Dien Tich</th>
                    <th>Tang</th>
                    <th>Loai Mat Bang</th>
                    <th>Gia Tien</th>
                    <th>Ngay Bat Dau</th>
                    <th>Ngay Ket Thuc</th>
                    <th>Hanh Dong</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="matBang" items="${matBangList}">
                    <tr>
                        <td><c:out value="${matBang.maMatBang}"/></td>
                        <td><c:out value="${matBang.trangThai}"/></td>
                        <td><c:out value="${matBang.dienTich}"/></td>
                        <td><c:out value="${matBang.tang}"/></td>
                        <td><c:out value="${matBang.loaiMatBang}"/></td>
                        <td><c:out value="${matBang.giaTien}"/></td>
                        <td><c:out value="${matBang.ngayBatDau}"/></td>
                        <td><c:out value="${matBang.ngayKetThuc}"/></td>
                        <td>
<%--                            <a class="btn btn-light" href="matbang?action=edit-mat-bang&id=${matBang.maMatBang}">Edit | </a>--%>
                            <a class="btn btn-danger"
                               href="#"
                               onclick="matBangSetId('${matBang.maMatBang}')"
                               data-toggle="modal" data-target="#deleteModal">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Xoa</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <input type="text" id="modelId" size="50" disabled style="border: none;background: white; color: red">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                            <button type="button" class="btn btn-primary" onclick="submitDelete()">Yes</button>
                        </div>
                    </div>
                </div>
            </div>

            <form action="matbang" id="deleteMatBang">
                <input type="hidden" name="action" value="delete-mat-bang">
                <input type="hidden" name="id" id="id">
            </form>





        </div>

<footer>
    <%@include file="../body/footer.jsp" %>
</footer>


<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>


<script>

    function matBangSetId(id) {
        document.getElementById("id").value = id;
        document.getElementById("modelId").value = "Ban co muon xoa mat bang voi ma: " + id;
    }

    function submitDelete() {
        <!-- để submit form delete  -->
        document.getElementById("deleteMatBang").submit();
    }

</script>


<script>
    $(document).ready(function() {
        $('#tableMatBang').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        } );
    } );
</script>
</body>
</html>
